package com.example.springbootlayui.service.Impl;

import com.example.springbootlayui.dao.UserMapper;
import com.example.springbootlayui.entity.CommonResult;
import com.example.springbootlayui.entity.LoginInfo;
import com.example.springbootlayui.service.UserService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.example.springbootlayui.entity.ResultCode.*;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public CommonResult<?> doLogin(LoginInfo loginInfo, HttpServletRequest request) {
        if (loginInfo.getUserName() == null && "".equals(loginInfo.getUserName().trim())) {
            return new CommonResult<>(ERROR_CODE, USERNAME_EMPTY, null);
        }
        if (loginInfo.getPassword() == null && "".equals(loginInfo.getPassword().trim())) {
            return new CommonResult<>(ERROR_CODE, PASSWORD_EMPTY, null);
        }
        if (loginInfo.getRoleId() == null) {
            return new CommonResult<>(ERROR_CODE, ROLE_ID_EMPTY, null);
        }
        LoginInfo loginResult = userMapper.doLogin(loginInfo);

        //校验查询数据是否为空
        if (loginResult == null) {
            return new CommonResult<>(ERROR_CODE, USER_NOT_FOUND, null);
        }

        //登录成功
        //将用户数据存储在前端
        HttpSession session = request.getSession();
        session.setAttribute("loginInfo", loginInfo);

        return new CommonResult<>(SUCCESS_CODE, SUCCESS_MSG, loginResult);
    }
}
