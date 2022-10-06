package com.example.springbootlayui.service;

import com.example.springbootlayui.entity.CommonResult;
import com.example.springbootlayui.info.LoginInfo;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    CommonResult<?> doLogin(LoginInfo loginInfo, HttpServletRequest request);
}
