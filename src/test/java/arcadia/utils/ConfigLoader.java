package arcadia.utils;

import arcadia.constants.EnvType;

import java.util.Properties;

import static arcadia.constants.EnvType.PROD;
import static arcadia.constants.EnvType.STAGE;

public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader(){
        String env = System.getProperty("env", String.valueOf(EnvType.STAGE));
        switch (EnvType.valueOf(env)){
            case PROD : properties = PropertyUtils.propertyLoader(PropertyUtils.getAbsolutePathOfFile("prod_config.properties"));break;
            case STAGE : properties = PropertyUtils.propertyLoader(PropertyUtils.getAbsolutePathOfFile("stage_config.properties"));break;
            default : throw new IllegalStateException("INVALID ENV: " + env);
        }
    }

    public static ConfigLoader getInstance(){
        if(configLoader == null){
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getBaseUrl(){
        //String prop = properties.getProperty("baseUrl");
        //Added as environment variable because there is request to run automation in different environments
        String prop = "https://"+System.getProperty("url")+"/";
        if(prop != null) return prop;
        else throw new RuntimeException("property baseUrl is not specified in the stage_config.properties file");
    }
}
