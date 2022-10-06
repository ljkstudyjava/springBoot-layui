package com.example.springbootlayui.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    //客户ID
    private Integer id;

    //客户编号
    private String khno;

    //客户姓名
    private String name;

    //客户所属地区
    private String area;

    //客户经理
    private String cusManager;

    //客户级别
    private String level;

    //客户满意度
    private String myd;

    //客户信用度
    private String xyd;

    //客户地址
    private String address;

    //邮编
    private String postCode;

    //联系电话
    private String phone;

    //传真
    private String fax;

    //网址
    private String webSite;

    //营业执照注册号
    private String yyzzzch;

    //法人代表
    private String fr;

    //注册资金
    private String zczj;

    //年营业额
    private String nyye;

    //开户银行
    private String khyh;

    //开户账号
    private String khzh;

    //地税登记号
    private String dsdjh;

    //国税登记号
    private String gsdjh;

    //流失状态
    private String state;

    //有效状态
    private String isValid;

    //创建时间
    private Date createDate;

    // 跟新时间
    private Date updateDate;


}
