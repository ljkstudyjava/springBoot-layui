package com.example.springbootlayui.controller;

import com.example.springbootlayui.entity.CommonResult;
import com.example.springbootlayui.info.LoginInfo;
import com.example.springbootlayui.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 登录方法
     *
     * @param request
     * @param loginInfo
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public CommonResult<?> Login(HttpServletRequest request, @RequestBody LoginInfo loginInfo) {
        //System.out.println("loginInfo = " + loginInfo);

        //拿到数据后交由业务层处理
        return userService.doLogin(loginInfo, request);
    }

    /**
     * 退出登录
     *
     * @return
     */
    @GetMapping("/logout")
    public String Logout(HttpServletRequest request) {

        logger.info("退出登录");
        //销毁session
        HttpSession session = request.getSession();


        session.removeAttribute("loginInfo");
        //重定向到登陆页面
        return "redirect:/";
    }
}
