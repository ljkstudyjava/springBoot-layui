package com.example.springbootlayui.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMenu {
    private Integer id;//id
    private String menuName;//菜单名称
    //private String icon;//图标
    private String menuUrl;//链接地址
    private Integer pid;
    private Boolean isValid;//状态
    private List<UserMenu> titleNode;//子节点

}
