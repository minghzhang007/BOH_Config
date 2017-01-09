package com.lewis.bohconfig.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;

public class IpUtil {
	private static final Logger log = LoggerFactory.getLogger(IpUtil.class);

	/**
	 * 获取IP地址
	 * 
	 * @return
	 */
	public static String getIp() {
		String ip = null;
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (Exception e) {
			log.error("获取IP地址出错: <{}>.", e.getMessage());
		}
		return ip;
	}
}
