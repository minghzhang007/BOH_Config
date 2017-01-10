package com.lewis.bohconfig.controller;

import com.lewis.bohconfig.common.enumer.Json;
import com.lewis.bohconfig.domain.VarParamSwitch;
import com.lewis.bohconfig.service.IVarParamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangminghua on 2017/1/10.
 */
@Controller
@RequestMapping("/zk")
public class CRUDController {

    @Resource
    private IVarParamService varParamService;

    @RequestMapping("/toList")
    public String list(Model model){
        List<VarParamSwitch> varParamSwitches = varParamService.queryAllVarParamSwitchs();
        model.addAttribute("varParamSwitches",varParamSwitches);
        model.addAttribute("name","lewis!");
        return "list";
    }

    @RequestMapping("/toAddVarParam")
    public String toAdd(){
        return "addVarParam";
    }

    @RequestMapping("/addVarParam")
    public String addVarParam(@Json VarParamSwitch varParamSwitch){
        System.out.println(varParamSwitch);
        varParamService.addVarParamSwitch(varParamSwitch);
        return "redirect:toList";
    }

}
