package com.yinrj.drawingboardserver.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Name: StatusCodeEnum
 * Author: yinrongjie
 * Date: 2025/1/23
 */
@AllArgsConstructor
@Getter
public enum StatusCodeEnum {

    SUCCESS(0, "success"),

    SYSTEM_ERROR(500, "system_error"),

    PARAM_ERROR(-1, "param_error"),

    ;


    private final Integer statusCode;

    private final String statusMsg;
}
