package com.lewis.bohconfig.controller;

import com.lewis.bohconfig.domain.VarParamSwitch;
import com.lewis.bohconfig.service.ITestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangminghua on 2017/1/7.
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @Resource
    private ITestService testService;

    @RequestMapping("/say")
    public String sayHello(Model model){
        model.addAttribute("name","lewis");
        List<VarParamSwitch> varParamSwitches = testService.queryAllVarParamSwitch();
        model.addAttribute("params",varParamSwitches);
        return "Hello";
    }
}
