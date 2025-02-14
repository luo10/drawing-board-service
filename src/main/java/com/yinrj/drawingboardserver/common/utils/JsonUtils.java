package com.yinrj.drawingboardserver.common.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * Name: JsonUtils
 * Author: yinrongjie
 * Date: 2025/1/24
 */
@Slf4j
public final class JsonUtils {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    private JsonUtils() {
    }


    public static <T> T parseObject(String json, Class<T> clazz) {
        try {
            return OBJECT_MAPPER.readValue(json, clazz);
        } catch (Exception e) {
            log.error("parseObject error. json: {}, clazz: {}", json, clazz, e);
        }
        return null;
    }

    public static <T> T parseObject(Map<String, String> map, Class<T> clazz) {
        try {
            return OBJECT_MAPPER.convertValue(map, clazz);
        } catch (Exception e) {
            log.error("parseObject error. map: {}, clazz: {}", map, clazz, e);
        }
        return null;
    }

}
