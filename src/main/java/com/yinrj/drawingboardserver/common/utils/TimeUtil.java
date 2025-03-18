package com.yinrj.drawingboardserver.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
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

    /**
     * 将日期时间字符串（ISO格式或时间戳字符串）转换为时间戳（毫秒）
     * 
     * @param timeStr 时间字符串，可以是ISO格式如"2025-03-18T15:35:47.810Z"或时间戳字符串
     * @return 转换后的时间戳（毫秒）
     */
    public static Long parseTimeString(String timeStr) {
        try {
            return Instant.parse(timeStr).toEpochMilli();
        } catch (Exception e) {
            // 如果解析失败，尝试直接将字符串转为Long
            try {
                return Long.parseLong(timeStr);
            } catch (NumberFormatException ex) {
                // 如果都无法转换，使用当前时间作为默认值
                log.warn("无法解析时间字符串: {}, 使用当前时间代替", timeStr);
                return Instant.now().toEpochMilli();
            }
        }
    }

}
