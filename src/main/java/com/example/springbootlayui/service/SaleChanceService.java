package com.example.springbootlayui.service;

import com.example.springbootlayui.dto.LayuiDto;
import com.example.springbootlayui.entity.CommonResult;
import com.example.springbootlayui.entity.SaleChance;
import com.example.springbootlayui.info.SaleChanceInfo;

import java.util.List;

public interface SaleChanceService {


    //get all saleChanceList
    List<SaleChance> getAllList(SaleChanceInfo saleChanceInfo);

    CommonResult<?> delete(Integer[] ids);
}
