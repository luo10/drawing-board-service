package com.yinrj.drawingboardserver.modules.oss.domain.service.impl;

import com.yinrj.drawingboardserver.modules.oss.domain.service.OssService;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OssServiceImplTest {

    @Resource
    private OssService ossService;

    @Test
    @SneakyThrows
    @Disabled
    void testUpload() {
        InputStream inputStream = new FileInputStream("/Users/yinrongjie/Desktop/drawing.png");
        ossService.upload(inputStream, "test1234.png");
    }

}