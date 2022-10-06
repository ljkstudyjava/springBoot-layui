package com.example.springbootlayui.service.Impl;

import com.example.springbootlayui.dao.SaleChanceMapper;
import com.example.springbootlayui.dto.LayuiDto;
import com.example.springbootlayui.entity.CommonResult;
import com.example.springbootlayui.entity.SaleChance;
import com.example.springbootlayui.info.SaleChanceInfo;
import com.example.springbootlayui.service.SaleChanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

import static com.example.springbootlayui.entity.ResultCode.*;

@Service
public class SaleChanceServiceImpl implements SaleChanceService {

    @Resource
    private SaleChanceMapper saleChanceMapper;

    /**
     * 获取全部数据
     *
     * @return
     */
    @Override
    public List<SaleChance> getAllList(SaleChanceInfo saleChanceInfo) {
        return saleChanceMapper.getAll(saleChanceInfo);
    }

    @Override
    public CommonResult<?> delete(Integer[] ids) {
        //
        System.out.println("Service"+"ids = " + ids);
        return new CommonResult<>(SUCCESS_CODE,SUCCESS_MSG,saleChanceMapper.delete(ids));
    }
}
