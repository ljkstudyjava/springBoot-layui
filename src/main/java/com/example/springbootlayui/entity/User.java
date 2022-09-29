package com.example.springbootlayui.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String userName;
    private String userPwd;
    private String trueName;
    private String email;
    private String phone;
    private String roleName;
    private Integer isValid;
    private Date createDate;
    private Date updateDate;
    private Integer roleId;

}
