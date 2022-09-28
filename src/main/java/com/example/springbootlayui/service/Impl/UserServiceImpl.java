package com.example.springbootlayui.service.service.Impl;

import com.example.springbootlayui.dao.UserMapper;
import com.example.springbootlayui.entity.CommonResult;
import com.example.springbootlayui.entity.LoginInfo;
import com.example.springbootlayui.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static com.example.springbootlayui.entity.ResultCode.*;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public CommonResult<?> doLogin(LoginInfo loginInfo) {
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
        return new CommonResult<>(SUCCESS_CODE, SUCCESS_MSG, loginResult);
    }
}
