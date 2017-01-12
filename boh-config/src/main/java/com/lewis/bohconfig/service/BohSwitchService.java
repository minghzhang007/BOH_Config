package com.lewis.bohconfig.service;

import com.lewis.bohconfig.domain.BohSwitchDO;

import java.util.List;

/**
 * Created by zhangminghua on 2017/1/12.
 */
public interface BohSwitchService {

    int insertBohSwitch(BohSwitchDO bohSwitchDO);

    int deleteBohSwitch(String identity);

    int updateBohSwitch(BohSwitchDO bohSwitchDO);

    List<BohSwitchDO> getAllBohSwitch();

    BohSwitchDO getBohSwitchByIdentity(String identity);
}
