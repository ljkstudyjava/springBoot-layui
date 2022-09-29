package com.example.springbootlayui.controller;

import com.example.springbootlayui.dto.SaleChanceDto;
import com.example.springbootlayui.service.SaleChanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("saleChance")
public class SaleChanceController {

    Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private SaleChanceService saleChanceService;


}