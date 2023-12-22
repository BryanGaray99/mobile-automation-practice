package com.bgaray.utils.DataProvider;

import org.apache.commons.lang3.RandomStringUtils;

public class DataProvider {
    public static String generateRandomEmail() {
        String prefix = "testuser";
        String domain = "@example.com";
        String randomPart = RandomStringUtils.randomAlphanumeric(10);

        return prefix + randomPart + domain;
    }

    public static String generateRandomPassword() {
        return RandomStringUtils.randomAlphanumeric(12);
    }
}
