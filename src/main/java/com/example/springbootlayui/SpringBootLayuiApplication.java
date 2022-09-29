package com.example.springbootlayui;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.springBootlayui.dao")
public class SpringBootLayuiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLayuiApplication.class, args);
    }

}
