package com.lewis.bohconfig.service.impl;

import com.lewis.bohconfig.dao.IVarParamSwitchDao;
import com.lewis.bohconfig.domain.VarParamSwitch;
import com.lewis.bohconfig.service.ITestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangminghua on 2017/1/7.
 */
@Service
public class TestServiceImpl implements ITestService {

    @Resource
    private IVarParamSwitchDao varParamSwitchDao;

    public List<VarParamSwitch> queryAllVarParamSwitch() {
        List<VarParamSwitch> allVarParamSwitch = varParamSwitchDao.queryAllVarParamSwitchs();
        return allVarParamSwitch;
    }
}
