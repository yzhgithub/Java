package main.java.controller;

import main.java.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private static List<User> userList;

    public UserController() {
        userList = new ArrayList<User>();
    }

    @RequestMapping(value = "/registerForm", method = RequestMethod.GET)
    public String registerForm() {
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam("loginname") String loginname,
                           @RequestParam("password") String password,
                           @RequestParam("username") String username) {
        User user = new User();
        user.setLoginname(loginname);
        user.setPassword(password);
        user.setUsername(username);
        userList.add(user);

        return "loginForm";
        //return "registerSuccess";
    }

    @RequestMapping(value = "/login")
    public String login(@RequestParam("loginname") String loginname,
                        @RequestParam("password") String password,
                        Model model) {
        for(User user:userList){
            if(user.getLoginname().equals(loginname)&&user.getPassword().equals(password)){
                model.addAttribute("username",user.getUsername());   // 通过Model来传数据到页面
                model.addAttribute(user.getLoginname());   // 此处没定义变量的名字，默认用这个参数的类型名字作为变量名字,不过首字母大写变为小写
                return "loginSuccess";
            }
        }
        return "loginFailure";
    }
}
