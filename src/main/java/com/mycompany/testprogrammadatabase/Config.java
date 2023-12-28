package com.mycompany.testprogrammadatabase;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static Properties properties;
    private static final String filePath = "/config.properties"; 

    static {
        properties = loadProperties();
    }

    private static Properties loadProperties() {
        Properties prop = new Properties();
        try (InputStream input = Config.class.getResourceAsStream(filePath)) {
            if (input == null) {
                throw new IOException("Impossibile trovare il file " + filePath);
            }
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Errore durante il caricamento di config.properties", e);
        }
        return prop;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
