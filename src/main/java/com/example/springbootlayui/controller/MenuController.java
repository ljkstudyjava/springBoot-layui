package com.example.springbootlayui.controller;


import com.example.springbootlayui.info.LoginInfo;
import com.example.springbootlayui.service.MenuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;


@RestController
public class MenuController {

    @Resource
    private MenuService menuService;

    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("menu")
    public Map<?, ?> Menu(HttpServletRequest request) {

        LoginInfo loginInfo = (LoginInfo) request.getSession().getAttribute("loginInfo");
        Integer id = loginInfo.getRoleId();
        logger.info("获取对象");
        return menuService.findMenu(id);
    }
}
