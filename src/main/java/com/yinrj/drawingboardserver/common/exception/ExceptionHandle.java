package com.yinrj.drawingboardserver.common.exception;

import com.yinrj.drawingboardserver.common.enums.StatusCodeEnum;
import com.yinrj.drawingboardserver.common.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Name: ExceptionHandlle
 * Author: yinrongjie
 * Date: 2024/6/4
 */
@RestControllerAdvice
@Slf4j
public class ExceptionHandle {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R<Void> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("param error", e);
        return R.fail(StatusCodeEnum.PARAM_ERROR);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public R<Void> handleIllegalArgumentException(IllegalArgumentException e) {
        log.error("param error", e);
        return R.fail(StatusCodeEnum.PARAM_ERROR.getStatusCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public R<Void> handleException(Exception e) {
        log.error("error", e);
        return R.fail();
    }

    @ExceptionHandler(CommonException.class)
    public R<Void> handleCommonException(CommonException e) {
        log.error("error", e);
        return R.fail(e.getStatusCodeEnum());
    }

}
