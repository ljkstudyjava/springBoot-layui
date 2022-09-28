package com.example.springbootlayui.controller;

import com.example.springbootlayui.entity.LoginInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController {

    @RequestMapping("/")
    public String test() {
        return "login";
    }

    @GetMapping("user")
    public String test2() {
        return "userList";
    }

    @ResponseBody
    @RequestMapping("/login")
    public LoginInfo Login(@RequestBody LoginInfo loginInfo) {
        System.out.println("---------------------");
        System.out.println("loginInfo = " + loginInfo);
        return loginInfo;
    }
}
