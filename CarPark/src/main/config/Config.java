package main.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private static final Properties properties;
    static {
        Properties props = new Properties();
        try {
            InputStream in = Config.class.getClassLoader().getResourceAsStream("main/config/park.properties");
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        properties = props;
    }

    public static Properties getProperties() {
        return properties;
    }

    public static String getProperty(String name) {
        return properties.getProperty(name);
    }
}
