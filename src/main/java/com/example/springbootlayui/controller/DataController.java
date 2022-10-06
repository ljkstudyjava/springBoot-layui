package com.example.springbootlayui.controller;

import com.example.springbootlayui.dto.LayuiDto;
import com.example.springbootlayui.entity.SaleChance;
import com.example.springbootlayui.info.SaleChanceInfo;
import com.example.springbootlayui.service.SaleChanceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static com.example.springbootlayui.entity.ResultCode.*;

/**
 * 用于返回前端所需JSON数据
 */

@RestController
public class DataController {

    @Resource
    private SaleChanceService saleChanceService;

    Logger logger = LoggerFactory.getLogger(getClass());


    /**
     * 获取销售机会的数据
     *
     * @param saleChanceInfo
     * @return
     */
    @GetMapping("/getSaleChanceList")
    @ResponseBody
    public LayuiDto getAllSaleChance(SaleChanceInfo saleChanceInfo) {


        logger.info("查询列表");

        logger.info("baseQuery.getLimit()");
        logger.info("{}", saleChanceInfo);
        PageHelper.startPage(saleChanceInfo.getPage(), saleChanceInfo.getLimit());

        List<SaleChance> list = saleChanceService.getAllList(saleChanceInfo);

        PageInfo<SaleChance> pageInfo = new PageInfo<>(list);

        long total = pageInfo.getTotal();

        return new LayuiDto(LAYUI_SUCCESS_CODE, SUCCESS_MSG, (int) total, pageInfo.getList());
    }
}
