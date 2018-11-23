package com.yzh.ssm.controller;

import com.yzh.ssm.model.MotorHome;
import com.yzh.ssm.service.IMotorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/motor")
@Api(value = "MotorHome",tags = {"Motor相关接口"})   // swagger控制器说明注解
public class MotorHomeController {

    @Resource
    private IMotorService motorService;

    @RequestMapping("/get")
    public String getModel(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        MotorHome motorHome = this.motorService.getModelById(id);
        model.addAttribute("motor", motorHome);
        return "motor/index";
    }

    @RequestMapping("/index_api")
    @ResponseBody
    @ApiOperation(value = "获取MotorHome实例",notes = "传入一个id，获取该id对应的实例.",httpMethod = "GET") // swagger方法注解
    public MotorHome getModelApi(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        return this.motorService.getModelById(id);
    }
}
