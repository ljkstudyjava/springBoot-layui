package com.example.springbootlayui.info;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 数据传入封装类
 */
@Data
public class SaleChanceInfo extends BaseQuery {


    private Integer id;

    private String chanceSource;

    private String customerName;

    private Integer cgjl;

    private String overview;

    private String linkMan;

    private String linkPhone;

    private String description;

    private String createMan;

    private String assignMan;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date assignTime;

    private Integer state;

    private Integer devResult;

    private Integer isValid;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;
}
