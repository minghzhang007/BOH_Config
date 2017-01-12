package com.lewis.bohconfig.controller;

import com.lewis.bohconfig.common.enumer.Json;
import com.lewis.bohconfig.domain.BohSwitchDO;
import com.lewis.bohconfig.service.BohSwitchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        model.addAttribute("name", "lewis!");
        return "list";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "addSwitch";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addVarParam(@Json BohSwitchDO bohSwitchDO) {
        System.out.println(bohSwitchDO);
        if (bohSwitchDO != null) {
            bohSwitchService.insertBohSwitch(bohSwitchDO);
        }
        return "redirect:toList";
    }

}
