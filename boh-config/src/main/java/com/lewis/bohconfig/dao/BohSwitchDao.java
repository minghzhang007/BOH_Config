package com.lewis.bohconfig.dao;

import com.lewis.bohconfig.common.domain.PageParam;
import com.lewis.bohconfig.domain.AppDO;
import com.lewis.bohconfig.domain.BohSwitchDO;

import java.util.List;

/**
 * Created by zhangminghua on 2017/1/12.
 */
public interface BohSwitchDao {

    int insertBohSwitch(BohSwitchDO bohSwitchDO);

    int deleteBohSwitch(String identity);

    int updateBohSwitch(BohSwitchDO bohSwitchDO);

    List<BohSwitchDO> getAllBohSwitch();

    BohSwitchDO getBohSwitchByIdentity(String identity);

    List<BohSwitchDO> getBohSwitchesPage(PageParam pageParam);

    int getAllCount();
    List<BohSwitchDO> queryAvaliableSwitches(AppDO appDO);
}
