package com.example.springbootlayui.info;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseQuery {
    //current page
    private int page;

    //each page
    private int limit;
}
