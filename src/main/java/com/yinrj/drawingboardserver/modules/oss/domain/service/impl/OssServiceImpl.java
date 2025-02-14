package com.yinrj.drawingboardserver.modules.oss.domain.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.model.PutObjectRequest;
import com.yinrj.drawingboardserver.common.properties.OssConfigProp;
import com.yinrj.drawingboardserver.modules.oss.domain.service.OssService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.InputStream;

/**
 * Name: OssServiceImpl
 * Author: yinrongjie
 * Date: 2025/1/23
 */
@Service
@Slf4j
public class OssServiceImpl implements OssService {

    @Resource(name = "ossClient")
    private OSS ossConfig;

    @Resource
    private OssConfigProp ossConfigProp;

    /**
     * 上传文件
     *
     * @param inputStream 文件流
     * @param fileName    文件名
     */
    @Override
    public String upload(InputStream inputStream, String fileName) {
        try {
            // 检查文件名是否有有效后缀
            if (!fileName.matches(".+\\.[a-zA-Z0-9]+$")) {
                fileName += ".png";
            }
            String path = ossConfigProp.getObjectName() + fileName;
            var request = new PutObjectRequest(ossConfigProp.getBucketName(), path, inputStream);
            var response = ossConfig.putObject(request);
            String url = ossConfigProp.getFilePrefixPath() + fileName;
            log.info("上传文件[{}]成功，url:{}", fileName, url);
            return url;
        } catch (Exception e) {
            log.error("上传文件[{}]失败", fileName, e);
        }
        return null;
    }
}
