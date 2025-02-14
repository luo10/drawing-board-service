package com.yinrj.drawingboardserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class DrawingBoardServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DrawingBoardServerApplication.class, args);
    }

}
