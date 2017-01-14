package com.lewis.bohconfig.controller;

import com.lewis.bohconfig.common.enumer.Json;
import com.lewis.bohconfig.common.util.Pager;
import com.lewis.bohconfig.domain.BohSwitchDO;
import com.lewis.bohconfig.service.BohSwitchService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
        //model.addAttribute("switches", switches);
        Pager<BohSwitchDO> pager = new Pager<BohSwitchDO>(switches.size(),switches);
        model.addAttribute("data",pager);
        return "paginationList";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "addSwitch";
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String addVarParam(@Json BohSwitchDO bohSwitchDO) {
        System.out.println(bohSwitchDO);
        if (bohSwitchDO != null) {
            bohSwitchService.insertBohSwitch(bohSwitchDO);
        }
        return "redirect:toList";
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String delete(String identity){
        if (StringUtils.isNotEmpty(identity)) {
            bohSwitchService.deleteBohSwitch(identity);
        }
        return "redirect:toList";
    }

    @RequestMapping(value = "/toUpdate",method = RequestMethod.GET)
    public String toUpdate(@RequestParam  String identity,Model model){
        BohSwitchDO bohSwitch = bohSwitchService.getBohSwitchByIdentity(identity);
        model.addAttribute("bohSwitch",bohSwitch);
        return "update";
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public String update(@Json BohSwitchDO bohSwitchDO,Model model){
        bohSwitchService.updateBohSwitch(bohSwitchDO);
        List<BohSwitchDO> switches = bohSwitchService.getAllBohSwitch();
        model.addAttribute("switches", switches);
        String flag= "{\"success\":true}";
        return flag;
    }

}
