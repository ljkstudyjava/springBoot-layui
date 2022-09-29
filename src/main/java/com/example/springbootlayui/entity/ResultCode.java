package com.example.springbootlayui.entity;

public interface ResultCode {
    //通用成功码
    Integer SUCCESS_CODE = 200;
    //通用失败码
    Integer ERROR_CODE = 100;

    //用户名为空
    String USERNAME_EMPTY = "用户名为空";

    //密码为空
    String PASSWORD_EMPTY = "密码为空";

    //身份id为空
    String ROLE_ID_EMPTY = "身份id为空";

    //通用成功信息
    String SUCCESS_MSG = "成功";

    //未找到该用户
    String USER_NOT_FOUND = "未找到该用户";

    //layui数据返回码
    Integer LAYUI_SUCCESS_CODE = 0;
}
