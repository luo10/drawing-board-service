package com.yinrj.drawingboardserver.common.utils;

import org.apache.commons.text.RandomStringGenerator;

/**
 * Name: CommonUtils
 * Author: yinrongjie
 * Date: 2025/1/24
 */
public final class CommonUtils {

    private final static RandomStringGenerator GENERATOR = new RandomStringGenerator.Builder()
            .withinRange('0', 'z')
            .filteredBy(Character::isLetterOrDigit)
            .get();

    private CommonUtils() {
    }

    public static String generateRandomString(int length) {
        return GENERATOR.generate(length);
    }

}
