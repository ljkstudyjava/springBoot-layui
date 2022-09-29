package com.example.springbootlayui.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class PageController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/")
    public String test() {
        return "login";
    }

    @RequestMapping("saleChance")
    public String test1() {
        logger.info("机会页面");
        return "saleChance";
    }

    @GetMapping("demo")
    public String test2(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        System.out.println("session = " + session);
        if (session.getAttribute("loginInfo") == null) {

            //TODO-还需要一个提示错误页面


            return "redirect:/";
        } else {
            return "demo";
        }
    }

}
