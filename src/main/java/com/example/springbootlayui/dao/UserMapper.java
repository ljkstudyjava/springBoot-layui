package com.example.springbootlayui.dao;

import com.example.springbootlayui.entity.LoginInfo;
import com.example.springbootlayui.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    LoginInfo doLogin(LoginInfo loginInfo);

    List<User> getAllUser();
}
