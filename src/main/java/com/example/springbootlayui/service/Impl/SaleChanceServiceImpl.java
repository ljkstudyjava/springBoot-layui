package com.example.springbootlayui.service.Impl;

import com.example.springbootlayui.dao.SaleChanceMapper;
import com.example.springbootlayui.dto.SaleChanceDto;
import com.example.springbootlayui.entity.SaleChance;
import com.example.springbootlayui.service.SaleChanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

import static com.example.springbootlayui.entity.ResultCode.*;

@Service
public class SaleChanceServiceImpl implements SaleChanceService {

    @Resource
    private SaleChanceMapper saleChanceMapper;

    @Override
    public SaleChanceDto getAll() {
        return new SaleChanceDto(LAYUI_SUCCESS_CODE, SUCCESS_MSG, saleChanceMapper.getCount(), saleChanceMapper.getAll());
    }

    @Override
    public List<SaleChance> getAllList() {
        return saleChanceMapper.getAll();
    }
}
