package com.lewis.bohconfig.service.impl;

import com.lewis.bohconfig.common.business.SwitchWrapperUtil;
import com.lewis.bohconfig.common.domain.PageParam;
import com.lewis.bohconfig.common.domain.ZKNode;
import com.lewis.bohconfig.common.enumer.OperationEnum;
import com.lewis.bohconfig.common.util.ListUtil;
import com.lewis.bohconfig.dao.BohSwitchDao;
import com.lewis.bohconfig.domain.AppDO;
import com.lewis.bohconfig.domain.BohSwitchDO;
import com.lewis.bohconfig.domain.BohSwitchDOWithHost;
import com.lewis.bohconfig.service.BohSwitchService;
import com.lewis.bohconfig.zk.ZKManager;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangminghua on 2017/1/12.
 */
@Service
public class BohSwitchServiceImpl implements BohSwitchService {

    @Resource
    private ZKManager zkManager;

    @Resource
    private BohSwitchDao bohSwitchDao;

    public int insertBohSwitch(BohSwitchDO bohSwitchDO) {
        ZKNode wrapper = SwitchWrapperUtil.wrapper(bohSwitchDO, OperationEnum.CREATE);
        bohSwitchDO.setIdentity(wrapper.getIdentity());
        int i = bohSwitchDao.insertBohSwitch(bohSwitchDO);
        zkManager.createPersistentNode(wrapper.getPath(), wrapper.getData());
        zkManager.addPathChildrenListener(wrapper.getPath());
        return i;
    }

    public int deleteBohSwitch(String identity) {
        return bohSwitchDao.deleteBohSwitch(identity);
    }

    public int updateBohSwitch(BohSwitchDOWithHost bohSwitchDO) {
        ZKNode wrapper = SwitchWrapperUtil.wrapper(bohSwitchDO, OperationEnum.UPDATE);
        int i = bohSwitchDao.updateBohSwitch(bohSwitchDO);
        zkManager.setData(wrapper.getPath(), wrapper.getData());
        List<String> hosts = bohSwitchDO.getHosts();
        if (ListUtil.isEmpty(hosts)) {
            hosts = zkManager.getChildren(wrapper.getPath());
        }
        for (String host : hosts) {
            String path = wrapper.getPath()+"/"+host;
            zkManager.setData(path,String.valueOf(bohSwitchDO.getDelFlag()));
        }
        return i;
    }

    public List<BohSwitchDO> getAllBohSwitch() {
        return bohSwitchDao.getAllBohSwitch();
    }

    public BohSwitchDO getBohSwitchByIdentity(String identity) {
        return bohSwitchDao.getBohSwitchByIdentity(identity);
    }

    public List<BohSwitchDOWithHost> getBohSwitchesPage(PageParam pageParam) {
        List<BohSwitchDOWithHost> retList = null;
        List<BohSwitchDO> bohSwitchesPage = bohSwitchDao.getBohSwitchesPage(pageParam);
        if (ListUtil.isNotEmpty(bohSwitchesPage)) {
            retList = new ArrayList<BohSwitchDOWithHost>(bohSwitchesPage.size());
            try {
                for (BohSwitchDO bohSwitchDO : bohSwitchesPage) {
                    BohSwitchDOWithHost dto = new BohSwitchDOWithHost();
                    BeanUtils.copyProperties(dto, bohSwitchDO);
                    ZKNode zkNode = SwitchWrapperUtil.wrapper(bohSwitchDO, OperationEnum.QUERY);
                    List<String> children = zkManager.getChildren(zkNode.getPath());
                    dto.setHosts(children);
                    retList.add(dto);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return retList;
    }

    public int getAllCount() {
        return bohSwitchDao.getAllCount();
    }

    public List<BohSwitchDO> queryAvaliableSwitches(AppDO appDO) {
        return bohSwitchDao.queryAvaliableSwitches(appDO);
    }
}
