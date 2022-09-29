package com.example.springbootlayui.dao;

import com.example.springbootlayui.entity.SaleChance;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SaleChanceMapper {

    List<SaleChance> getAll();

    Integer getCount();

}
