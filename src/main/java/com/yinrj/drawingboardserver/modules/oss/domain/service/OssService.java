package com.yinrj.drawingboardserver.modules.oss.domain.service;

import java.io.InputStream;

/**
 * Name: OssService
 * Author: yinrongjie
 * Date: 2025/1/23
 */
public interface OssService {

    /**
     * 上传文件
     *
     * @param inputStream 文件流
     * @param fileName    文件名
     * @return 文件路径
     */
    String upload(InputStream inputStream, String fileName);

}
