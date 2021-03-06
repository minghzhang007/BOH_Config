package com.lewis.bohconfig.controller;

import com.lewis.bohconfig.common.domain.PageParam;
import com.lewis.bohconfig.common.enumer.Json;
import com.lewis.bohconfig.common.enumer.ResponseJson;
import com.lewis.bohconfig.common.util.JsonUtil;
import com.lewis.bohconfig.common.util.Pager;
import com.lewis.bohconfig.domain.AppDO;
import com.lewis.bohconfig.domain.BohSwitchDO;
import com.lewis.bohconfig.domain.BohSwitchDOWithHost;
import com.lewis.bohconfig.domain.UpdateRequestVo;
import com.lewis.bohconfig.service.BohSwitchService;
import com.tuniu.operation.platform.tsg.client.annotation.TSPServiceInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangminghua on 2017/1/10.
 */
@Controller
@RequestMapping("/zk")
public class CRUDController {

    @Resource
    private BohSwitchService bohSwitchService;

    @RequestMapping("/toList")
    public String list(Model model) {
        List<BohSwitchDO> switches = bohSwitchService.getAllBohSwitch();
        model.addAttribute("switches", switches);
        return "list";
    }

    @RequestMapping("/toPaginationList")
    public String paginationList() {
        return "paginationList";
    }

    @RequestMapping("/getListJson")
    @ResponseBody
    public String getListJson(Integer page,Integer rows) {
        PageParam pageParam = new PageParam((page-1)*rows,rows);
        List<BohSwitchDOWithHost> switches = bohSwitchService.getBohSwitchesPage(pageParam);
        int totalCount = bohSwitchService.getAllCount();
        Pager<BohSwitchDOWithHost> pager = new Pager<BohSwitchDOWithHost>(totalCount,switches);
        return  JsonUtil.toString(pager);
    }


    @RequestMapping("/toAdd")
    public String toAdd() {
        return "addSwitch";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public String addVarParam(@Json BohSwitchDO bohSwitchDO) {
        System.out.println(bohSwitchDO);
        if (bohSwitchDO != null) {
            bohSwitchService.insertBohSwitch(bohSwitchDO);
        }
        String flag= "{\"success\":true}";
        return flag;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String delete(String identity){
        if (StringUtils.isNotEmpty(identity)) {
            bohSwitchService.deleteBohSwitch(identity);
        }
        return "redirect:toPaginationList";
    }

    @RequestMapping(value = "/toUpdate",method = RequestMethod.GET)
    public String toUpdate(@Json UpdateRequestVo requestVo, Model model){
        BohSwitchDO bohSwitch = bohSwitchService.getBohSwitchByIdentity(requestVo.getIdentity());
        model.addAttribute("bohSwitch",bohSwitch);
        model.addAttribute("hosts",requestVo.getHosts());
        return "update";
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public String update(@Json BohSwitchDOWithHost bohSwitchDO,Model model){
        bohSwitchService.updateBohSwitch(bohSwitchDO);
        List<BohSwitchDO> switches = bohSwitchService.getAllBohSwitch();
        model.addAttribute("switches", switches);
        String flag= "{\"success\":true}";
        return flag;
    }

    @ResponseJson
    @RequestMapping("/queryAvailableSwitches")
    @TSPServiceInfo(name ="BOH.CNF.CRUDController.queryAvailableSwitches",description = "查询BOH应用的开关数据")
    public List<BohSwitchDO> queryAvailableSwitches(@Json AppDO appDO){
        List<BohSwitchDO> bohSwitchDOs = bohSwitchService.queryAvaliableSwitches(appDO);
        return bohSwitchDOs;
    }

}
