package com.lewis.bohconfig.common.business;

import com.lewis.bohconfig.common.domain.ZKNode;
import com.lewis.bohconfig.common.enumer.OperationEnum;
import com.lewis.bohconfig.common.enumer.SwitchEnum;
import com.lewis.bohconfig.common.enumer.SystemEnum;
import com.lewis.bohconfig.common.util.JsonUtil;
import com.lewis.bohconfig.domain.BohSwitchDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhangminghua on 2017/1/13.
 */
public class SwitchWrapperUtil {
    private static Logger LOG = LoggerFactory.getLogger(SwitchWrapperUtil.class);

    private SwitchWrapperUtil(){}

    public static ZKNode wrapper(BohSwitchDO bohSwitchDO, OperationEnum operationEnum){
        try {
            ZKNode zkNode = new ZKNode();
            zkNode.setData(bohSwitchDO.getContent());
            String systemName = SystemEnum.of(bohSwitchDO.getSystemId()).getSystemName();
            String namePre = SwitchEnum.of(bohSwitchDO.getLevel()).getNamePre();
            StringBuilder sb = new StringBuilder();
            sb.append("/").append(systemName).append("/");
            if (operationEnum == OperationEnum.CREATE) {
                sb.append(namePre);
                zkNode.setIdentity(namePre+bohSwitchDO.getIdentity());
            }else{
                zkNode.setIdentity(bohSwitchDO.getIdentity());
            }
            sb.append(bohSwitchDO.getIdentity());
            zkNode.setPath(sb.toString());
            return zkNode;
        } catch (Exception e) {
            LOG.error("SwitchWrapperUtil.wrapper param is {},error is {}", JsonUtil.toString(bohSwitchDO),e);
        }
        return null;
    }
}
