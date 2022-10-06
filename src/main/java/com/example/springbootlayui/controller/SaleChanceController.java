package com.example.springbootlayui.controller;

import com.example.springbootlayui.entity.CommonResult;
import com.example.springbootlayui.info.SaleChanceInfo;
import com.example.springbootlayui.service.SaleChanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.util.Arrays;


import static com.example.springbootlayui.entity.ResultCode.*;

@Controller
@RequestMapping("saleChance")
public class SaleChanceController {

    Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private SaleChanceService saleChanceService;


    /**
     * 做删除操作可批量
     *
     * @param ids
     * @return
     */
    @PostMapping("delete")
    @ResponseBody
    public CommonResult<?> delete(@RequestBody Integer[] ids) {

        logger.info("删除" + Arrays.toString(ids));


        saleChanceService.delete(ids);

        return new CommonResult<>(SUCCESS_CODE, SUCCESS_MSG, ids);

    }

    @GetMapping("getUpdateDate")
    @ResponseBody
    public CommonResult<?> getUpdateDate(SaleChanceInfo saleChanceInfo) {
        System.out.println("id = " + saleChanceInfo.toString());
        return new CommonResult<>(saleChanceService.getAllList(saleChanceInfo));
    }

    @PostMapping("insert")
    @ResponseBody
    public CommonResult<?> insert(@RequestBody SaleChanceInfo saleChanceInfo){


        System.out.println("saleChanceInfo = " + saleChanceInfo);
        return new CommonResult<>(SUCCESS_CODE,SUCCESS_MSG,saleChanceInfo);
    }

}
