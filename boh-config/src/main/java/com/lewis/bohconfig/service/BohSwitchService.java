package com.lewis.bohconfig.service;

import com.lewis.bohconfig.common.domain.PageParam;
import com.lewis.bohconfig.domain.AppDO;
import com.lewis.bohconfig.domain.BohSwitchDO;
import com.lewis.bohconfig.domain.BohSwitchDOWithHost;

import java.util.List;

/**
 * Created by zhangminghua on 2017/1/12.
 */
public interface BohSwitchService {

    int insertBohSwitch(BohSwitchDO bohSwitchDO);

    int deleteBohSwitch(String identity);

    int updateBohSwitch(BohSwitchDOWithHost bohSwitchDO);

    List<BohSwitchDO> getAllBohSwitch();

    BohSwitchDO getBohSwitchByIdentity(String identity);

    List<BohSwitchDOWithHost> getBohSwitchesPage(PageParam pageParam);

    int getAllCount();

    List<BohSwitchDO> queryAvaliableSwitches(AppDO appDO);
}
