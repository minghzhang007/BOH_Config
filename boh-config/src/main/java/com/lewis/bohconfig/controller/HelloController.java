package com.lewis.bohconfig.controller;

import com.lewis.bohconfig.common.enumer.Json;
import com.lewis.bohconfig.common.enumer.ResponseJson;
import com.lewis.bohconfig.common.enumer.SwitchType;
import com.lewis.bohconfig.common.util.IpUtil;
import com.lewis.bohconfig.common.util.PortUtil;
import com.lewis.bohconfig.domain.SwitchRequestParam;
import com.lewis.bohconfig.domain.VarParamSwitch;
import com.lewis.bohconfig.service.ITestService;
import com.lewis.bohconfig.zk.ZKManager;
import com.tuniu.operation.platform.tsg.client.annotation.TSPServiceInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @Resource
    private ZKManager zkManager;

    @RequestMapping("/say")
    public String sayHello(Model model){
        model.addAttribute("name","lewis");
        List<VarParamSwitch> varParamSwitches = testService.queryAllVarParamSwitch();
        model.addAttribute("params",varParamSwitches);
        return "Hello";
    }

    @RequestMapping("/test/zk")
    @ResponseBody
    public String testZk(){
        zkManager.createPersistentNode("/varParam/queryProductDatePriceResIdNumberPerThread","20");
        String resp = zkManager.readNode("/varParam/queryProductDatePriceResIdNumberPerThread");
        String ip = IpUtil.getIp();
        int tomcatPort = PortUtil.getTomcatPort();
        System.out.println(ip+":"+tomcatPort);
        return resp.toString();
    }


    @RequestMapping("/zk/create")
    @ResponseJson
    @TSPServiceInfo(name="BOH.CNF.HelloController.create",description = "BOH.CNF测试")
    public SwitchRequestParam create(@Json SwitchRequestParam param){
       /* SwitchRequestParam param = new SwitchRequestParam();
        param.setContext("hehe");*/
        String swithType = param.getSwithType();
        StringBuilder sb = new StringBuilder();
        String data  = null;
        if (swithType.equals(SwitchType.FUNCTION_SWITCH.getType())) {
            Boolean switchOn = param.isOnOff();
            data = switchOn.toString();
        }else if (swithType.equals(SwitchType.VAR_PARAM.getType())) {
            data = param.getContext();
        }
        sb.append("/").append(param.getSwithType()).append("/").append(param.getIdentity());
        zkManager.createPersistentNode(sb.toString(),data);
        String resp = zkManager.readNode(sb.toString());
        param.setOnOff(false);
        param.setContext("hahah");
        return param;
    }

    @RequestMapping(value = "/zk/test",method = RequestMethod.POST)
    @ResponseJson
    public SwitchRequestParam test(@Json SwitchRequestParam param){
        param.setContext("hehe");
        param.setOnOff(false);
        return param;
    }

    @RequestMapping("/zk/toAddFunctionSwitch")
    public String toAdd(){
        return "addFunctionSwitch";
    }

    @RequestMapping("/zk/toAddVarParam")
    public String toAddVarParam(){
        return "addVarParam";
    }

    @RequestMapping("/zk/addVarParam")
    public String addVarParam(@Json VarParamSwitch varParamSwitch){
        System.out.println(varParamSwitch);
        return "list";
    }

}
