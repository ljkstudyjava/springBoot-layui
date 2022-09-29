package com.example.springbootlayui.dao;

import com.example.springbootlayui.entity.UserMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMenuMapper {

    //获取父菜单
    List<UserMenu> getUserMenu(int id);

    List<UserMenu> getMenu(int pid);

}
