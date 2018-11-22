package main.java.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Controller
@RequestMapping("/mvc")
@PropertySource("classpath:param.properties")  // 导入属性配置文件(方式二)
public class HelloWorldController {

    // 获取配置文件*.properties（方式一）
    @Value("${user.loginName}")
    String loginName;

    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("loginName", loginName);
        String errorInfo = getErrorInfo(0);
        model.addAttribute("errorInfo", errorInfo);
        return "hello";
    }

    // 获取配置文件*.properties（方式二）
    private String getErrorInfo(int errorCode) {
        Properties properties=new Properties();
        InputStream stream=this.getClass().getResourceAsStream("/errorcode.properties");
        try {
            properties.load(stream);
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return properties.getProperty(errorCode+"","null");
    }
}
