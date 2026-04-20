package com.euroTech.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties;

    static {
        String path = "config.properties";
        try{
            FileInputStream fis=new FileInputStream(path);
            properties=new Properties();
            properties.load(fis);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String get(String key){
        return properties.getProperty(key);
    }
}
