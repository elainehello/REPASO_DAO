package com.elainevalles.repasodao.persistence.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    //Acceder a las propiedades del archivo application.properties
    public static String getProperty(String key) throws IOException{
        Properties prop = new Properties();
        try (InputStream input = PropertiesReader.class.getClassLoader().getResourceAsStream("application.properties")) {
            prop.load(input);
        }
        String value = prop.getProperty(key);
        return value;
    }
}
