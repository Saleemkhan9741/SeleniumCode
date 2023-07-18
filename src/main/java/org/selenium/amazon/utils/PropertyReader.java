package org.selenium.amazon.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class PropertyReader {

    private static final Logger LOGGER = LogManager.getLogger(PropertyReader.class);
    public static String environment;
    private static PropertyReader propertyReader;

    public static PropertyReader getInstance(){
        if(propertyReader==null){
            propertyReader = new PropertyReader();
        }
        return propertyReader;
    }

    public PropertyReader(){

    }

    public String getConfigPropertyForGivenKey(String key){
        FileInputStream fis;
        Properties configProperties;
        try {
            fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
            LOGGER.info("fetching value for key : {} from config file",key);
            configProperties = new Properties();
            configProperties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String value = configProperties.getProperty(key);
        if(!Objects.isNull(value)){
            return value ;
        }else{
            throw new RuntimeException("The given key does not match with any keys in config file. KEY : "+key);
        }
    }

    public String getPropertyForGivenKey(String key){
        FileInputStream fis;
        Properties properties;
        try {
            fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/"+environment+".properties");
            LOGGER.info("fetching value for key : {} from config file",key);
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String value = properties.getProperty(key);
        if(!Objects.isNull(value)){
            return value ;
        }else{
            throw new RuntimeException("The given key does not match with any keys in config file. KEY : "+key);
        }
    }

}
