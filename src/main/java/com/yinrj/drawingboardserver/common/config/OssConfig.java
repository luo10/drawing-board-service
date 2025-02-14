package com.yinrj.drawingboardserver.common.config;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.auth.CredentialsProviderFactory;
import com.yinrj.drawingboardserver.common.properties.OssConfigProp;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Name: OssConfig
 * Author: yinrongjie
 * Date: 2025/1/23
 */
@Configuration
public class OssConfig {

    @Resource
    private OssConfigProp ossConfigProp;

    @Bean(name = "ossClient")
    public OSS ossClient() {
        // 设置 OSS Endpoint 和 Bucket 名称
        String endpoint = ossConfigProp.getEndpoint();
        String bucketName = ossConfigProp.getBucketName();
        // 替换为您的 Bucket 区域
        String region = ossConfigProp.getRegion();
        // 创建 OSSClient 实例
        var credentialsProvider = CredentialsProviderFactory.newDefaultCredentialProvider(
                ossConfigProp.getAccessKeyId(),
                ossConfigProp.getAccessKeySecret());
        return OSSClientBuilder.create()
                .endpoint(endpoint)
                .credentialsProvider(credentialsProvider)
                .region(region)
                .build();
    }

}
