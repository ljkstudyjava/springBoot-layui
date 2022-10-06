package com.example.springbootlayui.dao;

import com.example.springbootlayui.entity.SaleChance;
import com.example.springbootlayui.info.SaleChanceInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SaleChanceMapper {

    List<SaleChance> getAll(SaleChanceInfo saleChanceInfo);

    Integer getCount();

    Integer delete(@Param("ids") Integer[] ids);

}
