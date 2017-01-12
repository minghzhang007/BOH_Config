package com.lewis.bohconfig.service.impl;

import com.lewis.bohconfig.dao.BohSwitchDao;
import com.lewis.bohconfig.domain.BohSwitchDO;
import com.lewis.bohconfig.service.BohSwitchService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangminghua on 2017/1/12.
 */
@Service
public class BohSwitchServiceImpl implements BohSwitchService {

    @Resource
    private BohSwitchDao bohSwitchDao;

    public int insertBohSwitch(BohSwitchDO bohSwitchDO) {
        return bohSwitchDao.insertBohSwitch(bohSwitchDO);
    }

    public int deleteBohSwitch(String identity) {
        return bohSwitchDao.deleteBohSwitch(identity);
    }

    public int updateBohSwitch(BohSwitchDO bohSwitchDO) {
        return bohSwitchDao.updateBohSwitch(bohSwitchDO);
    }

    public List<BohSwitchDO> getAllBohSwitch() {
        return bohSwitchDao.getAllBohSwitch();
    }

    public BohSwitchDO getBohSwitchByIdentity(String identity) {
        return bohSwitchDao.getBohSwitchByIdentity(identity);
    }
}
