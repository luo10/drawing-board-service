package com.yinrj.drawingboardserver.common.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yinrj.drawingboardserver.common.enums.StatusCodeEnum;
import lombok.Data;

/**
 * Name: R
 * Author: yinrongjie
 * Date: 2025/1/22
 */
@Data
public final class R<T> {

    @JsonProperty("status_code")
    private Integer statusCode;

    @JsonProperty("status_msg")
    private String statusMsg;

    private T data;

    private R() {
    }

    private R(StatusCodeEnum statusCodeEnum) {
        this.statusCode = statusCodeEnum.getStatusCode();
        this.statusMsg = statusCodeEnum.getStatusMsg();
    }

    private R(int statusCode, String statusMsg) {
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
    }

    public static <T> R<T> success(T data) {
        var res = new R<T>(StatusCodeEnum.SUCCESS);
        res.setData(data);
        return res;
    }

    public static <T> R<T> success() {
        return new R<T>(StatusCodeEnum.SUCCESS);
    }

    public static R<Void> fail() {
        return new R<>(StatusCodeEnum.SYSTEM_ERROR);
    }

    public static R<Void> fail(StatusCodeEnum responseStatusEnum) {
        return new R<>(responseStatusEnum);
    }

    public static R<Void> fail(int statusCode, String statusMsg) {
        return new R<>(statusCode, statusMsg);
    }

}
