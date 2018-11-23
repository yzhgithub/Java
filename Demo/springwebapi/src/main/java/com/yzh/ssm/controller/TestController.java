package com.yzh.ssm.controller;

import com.yzh.ssm.model.Test;
import com.yzh.ssm.service.ITestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/test")
@Api(value = "测试信息",tags = {"测试相关接口"})   // swagger控制器说明注解
public class TestController {

    @Resource
    private ITestService testService;

    // query(mvc)
    // request example：http://localhost:8080/springwebapi/test/index_page?id=2
    @RequestMapping("/index_page")
    public String showIndex(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        Test test = this.testService.getModelById(id);
        // 绑定对象到test/index.jsp
        model.addAttribute("test", test);
        return "test/index";
    }

    // query(web_api)
    // request example：http://localhost:8080/springwebapi/test/index_api?id=2
    @RequestMapping("/index_api")
    @ResponseBody
    @ApiOperation(value = "获取单个测试实例",notes = "传入一个id，获取该id对应的实例.",httpMethod = "GET") // swagger方法注解
    public Test Index(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        return this.testService.getModelById(id);
    }

    // add
    // request example：http://localhost:8080/springwebapi/test/add?cxt=hello&vc=123456
    @RequestMapping("/add")
    @ApiOperation(value = "新增单个测试实例",notes = "传入cxt和vc，新增一个实例.",httpMethod = "GET") // swagger方法注解
    public void Add(HttpServletRequest request) {
        String cxt = request.getParameter("cxt");
        int vc = Integer.parseInt(request.getParameter("vc"));
        Test test = new Test();
        test.setContext(cxt);
        test.setViewCount(vc);
        this.testService.addModel(test);
    }

    // delete
    // request example：http://localhost:8080/springwebapi/test/del?id=4
    @RequestMapping("/del")
    public void del(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        this.testService.delModel(id);
    }

    // update
    // request example：http://localhost:8080/springwebapi/test/update?id=1&cxt=hello&vc=123456
    @RequestMapping("/update")
    public void update(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String cxt = request.getParameter("cxt");
        int vc = Integer.parseInt(request.getParameter("vc"));
        Test test = new Test();
        test.setId(id);
        test.setContext(cxt);
        test.setViewCount(vc);
        this.testService.updateModel(test);
    }
}
