package com.akshay.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final Logger log = LoggerFactory.getLogger(Config.class);
    private static final String DEFAULT_PROPERTIES = "config/default.properties";
    private static Properties properties;


    public static void initialize(){
        //loading default properties
        properties = loadProperties();

        //checking for an override
        for(String key: properties.stringPropertyNames()){
            if(System.getProperties().containsKey(key)){
                properties.setProperty(key, System.getProperty(key));
            }
        }

        //printing for logging purpose
        log.info("Test Properties");
        for(String key: properties.stringPropertyNames()){
            log.info("{}={}", key,properties.getProperty(key));
        }
    }

    public static String get(String key){
        return properties.getProperty(key);
    }

    private static Properties loadProperties(){
        Properties properties = new Properties();
        try(InputStream stream = ResourceLoader.getResource(DEFAULT_PROPERTIES)){
            properties.load(stream);
        }catch (Exception e){
            log.error("Unable to read the property file {}", DEFAULT_PROPERTIES, e);
        }
        return properties;
    }


}
