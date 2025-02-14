package com.yinrj.drawingboardserver.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * Name: TimeUtil
 * Author: yinrongjie
 * Date: 2025/1/22
 */
@Slf4j
public final class TimeUtil {

    private TimeUtil() {
    }

    public static Long now() {
        return LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
    }

}
