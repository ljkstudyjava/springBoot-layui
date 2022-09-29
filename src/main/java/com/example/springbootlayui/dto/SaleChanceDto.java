package com.example.springbootlayui.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleChanceDto {
    private Integer code;
    private String msg;
    private Integer count;
    private Object data;
}
