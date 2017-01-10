package com.lewis.bohconfig.service.impl;

import com.lewis.bohconfig.dao.IVarParamSwitchDao;
import com.lewis.bohconfig.domain.VarParamSwitch;
import com.lewis.bohconfig.service.IVarParamService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangminghua on 2017/1/10.
 */
@Service
public class VarParamServiceImpl implements IVarParamService {

    @Resource
    private IVarParamSwitchDao  varParamSwitchDao;

    public int addVarParamSwitch(VarParamSwitch varParam) {
        return varParamSwitchDao.addVarParamSwitch(varParam);
    }

    public int updateVarParamSwitch(VarParamSwitch varParam) {
        return varParamSwitchDao.updateVarParamSwitch(varParam);
    }

    public int deleteVarParamSwitch(VarParamSwitch varParam) {
        return varParamSwitchDao.deleteVarParamSwitch(varParam);
    }

    public List<VarParamSwitch> queryAllVarParamSwitchs() {
        return varParamSwitchDao.queryAllVarParamSwitchs();
    }

    public VarParamSwitch queryVarParamSwitchByIdentity(String identity) {
        return varParamSwitchDao.queryVarParamSwitchByIdentity(identity);
    }
}
