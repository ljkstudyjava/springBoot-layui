package com.example.springbootlayui.service;

import com.example.springbootlayui.dto.SaleChanceDto;
import com.example.springbootlayui.entity.SaleChance;

import java.util.List;

public interface SaleChanceService {

    //get layui data
    SaleChanceDto getAll();

    //get all saleChanceList
    List<SaleChance> getAllList();
}
