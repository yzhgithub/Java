package com.yzh.ssm.controller;

import com.yzh.ssm.model.MotorHome;
import com.yzh.ssm.service.IMotorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/motor")
public class MotorHomeController {

    @Resource
    private IMotorService motorService;

    @RequestMapping("/get")
    public String getModel(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        MotorHome motorHome=this.motorService.getModelById(id);
        model.addAttribute("motor",motorHome);
        return "motor/index";
    }
}
