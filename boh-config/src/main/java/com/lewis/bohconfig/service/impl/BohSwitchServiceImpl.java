package com.lewis.bohconfig.service.impl;

import com.lewis.bohconfig.common.business.SwitchWrapperUtil;
import com.lewis.bohconfig.common.domain.PageParam;
import com.lewis.bohconfig.common.domain.ZKNode;
import com.lewis.bohconfig.common.enumer.OperationEnum;
import com.lewis.bohconfig.dao.BohSwitchDao;
import com.lewis.bohconfig.domain.AppDO;
import com.lewis.bohconfig.domain.BohSwitchDO;
import com.lewis.bohconfig.service.BohSwitchService;
import com.lewis.bohconfig.zk.ZKManager;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
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
        zkManager.createPersistentNode(wrapper.getPath(),wrapper.getData());
        return i;
    }

    public int deleteBohSwitch(String identity) {
        return bohSwitchDao.deleteBohSwitch(identity);
    }

    public int updateBohSwitch(BohSwitchDO bohSwitchDO) {
        ZKNode wrapper = SwitchWrapperUtil.wrapper(bohSwitchDO,OperationEnum.UPDATE);
        //bohSwitchDO.setIdentity(wrapper.getIdentity());
        int i = bohSwitchDao.updateBohSwitch(bohSwitchDO);
        zkManager.setData(wrapper.getPath(),wrapper.getData());
        return i;
    }

    public List<BohSwitchDO> getAllBohSwitch() {
        return bohSwitchDao.getAllBohSwitch();
    }

    public BohSwitchDO getBohSwitchByIdentity(String identity) {
        return bohSwitchDao.getBohSwitchByIdentity(identity);
    }

    public List<BohSwitchDO> getBohSwitchesPage(PageParam pageParam) {

        return bohSwitchDao.getBohSwitchesPage(pageParam);
    }

    public int getAllCount() {
        return bohSwitchDao.getAllCount();
    }

    public List<BohSwitchDO> queryAvaliableSwitches(AppDO appDO) {
        return bohSwitchDao.queryAvaliableSwitches(appDO);
    }
}
