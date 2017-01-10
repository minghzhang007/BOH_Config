package com.lewis.bohconfig.service;

import com.lewis.bohconfig.domain.VarParamSwitch;

import java.util.List;

/**
 * Created by zhangminghua on 2017/1/10.
 */
public interface IVarParamService {

    int addVarParamSwitch(VarParamSwitch varParam);

    int updateVarParamSwitch(VarParamSwitch varParam);

    int deleteVarParamSwitch(VarParamSwitch varParam);

    List<VarParamSwitch> queryAllVarParamSwitchs();

    VarParamSwitch queryVarParamSwitchByIdentity(String identity);

}
