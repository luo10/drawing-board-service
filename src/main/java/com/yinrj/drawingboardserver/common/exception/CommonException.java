package com.yinrj.drawingboardserver.common.exception;

import com.yinrj.drawingboardserver.common.enums.StatusCodeEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * Name: CommonException
 * Author: yinrongjie
 * Date: 2025/1/23
 */
@Getter
@Setter
public class CommonException extends RuntimeException{

    private final StatusCodeEnum statusCodeEnum;

    public CommonException(StatusCodeEnum statusCodeEnum) {
        super(statusCodeEnum.getStatusMsg());
        this.statusCodeEnum = statusCodeEnum;
    }

    public CommonException(StatusCodeEnum statusCodeEnum, String message) {
        super(message);
        this.statusCodeEnum = statusCodeEnum;
    }

    public CommonException(StatusCodeEnum statusCodeEnum, Throwable cause) {
        super(statusCodeEnum.getStatusMsg(), cause);
        this.statusCodeEnum = statusCodeEnum;
    }

    public CommonException(StatusCodeEnum statusCodeEnum, String message, Throwable cause) {
        super(message, cause);
        this.statusCodeEnum = statusCodeEnum;
    }

}
