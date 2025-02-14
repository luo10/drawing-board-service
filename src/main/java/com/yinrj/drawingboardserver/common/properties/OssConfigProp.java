package com.yinrj.drawingboardserver.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Name: OssConfigProp
 * Author: yinrongjie
 * Date: 2025/1/23
 */
@Component
@ConfigurationProperties(prefix = "oss")
@Data
public class OssConfigProp {

    private String endpoint;

    private String accessKeyId;

    private String accessKeySecret;

    private String bucketName;

    private String region;

    private String objectName;

    private String filePrefixPath;
}
