package com.lewis.bohconfig.common.util;

import org.apache.catalina.Server;
import org.apache.catalina.Service;
import org.apache.catalina.connector.Connector;
import org.apache.coyote.ProtocolHandler;
import org.apache.coyote.http11.Http11AprProtocol;
import org.apache.coyote.http11.Http11NioProtocol;
import org.apache.coyote.http11.Http11Protocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;
import java.util.List;

/*
 * 获取Tomcat提供服务的端口
 */
public class PortUtil {
    /**
     * get tomcat service port
     */
	private static final Logger LOG = LoggerFactory.getLogger(PortUtil.class);
    public  static int getTomcatPort() {
        int port = 8080;
        try {
            List<MBeanServer> mBeanServerArrayList = MBeanServerFactory.findMBeanServer(null);
            if (null != mBeanServerArrayList && !mBeanServerArrayList.isEmpty()) {
                MBeanServer mBeanServer = mBeanServerArrayList.get(0);
                ObjectName name = new ObjectName("Catalina", "type", "Server");
                Server server = (Server) mBeanServer.getAttribute(name, "managedResource");

                Service[] services = server.findServices();
                for (Service service : services) {
                    for (Connector connector : service.findConnectors()) {
                        ProtocolHandler protocolHandler = connector.getProtocolHandler();
                        if (protocolHandler instanceof Http11Protocol
                                || protocolHandler instanceof Http11AprProtocol
                                || protocolHandler instanceof Http11NioProtocol) {
                            port = connector.getPort();
                            return port;
                        }
                    }
                }
            } else {
            	port=-1;
                LOG.error("[PortUtil][getTomcatPort]cannot get Tomcat Port. Not use tomcat?");
            }

        } catch (Exception e) {
        	port=-1;
            LOG.error("[PortUtil][getTomcatPort]",e);
        }
        return port;
    }
}