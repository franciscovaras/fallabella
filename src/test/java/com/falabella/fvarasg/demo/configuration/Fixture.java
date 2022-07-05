package com.falabella.fvarasg.demo.configuration;

import com.falabella.fvarasg.demo.IOUtils;

import java.io.FileInputStream;

import static java.nio.charset.StandardCharsets.UTF_8;

public final class Fixture {

    // BASE PATH
    private static final String PATH = "src/test/resources/json/";


    //INDEX

    public static String readFileFromResources(String fileName) {
        try {
            FileInputStream fis = new FileInputStream(PATH + fileName);

            return IOUtils.toString(fis, UTF_8.name());

        } catch (Exception e) {
            return null;
        }
    }


}