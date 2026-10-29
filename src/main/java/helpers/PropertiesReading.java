package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReading {

    private static final String PROPERTIES_FILE_PATH = "config.properties";
    private static Properties properties = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream(PROPERTIES_FILE_PATH)) {
            properties.load(fis);
        } catch (IOException e) {
            throw new ExceptionInInitializerError("Не удалось загрузить config.properties: " + e.getMessage());
        }
    }

    public static String getProperty(String key) {
        if (key == null || key.trim().isEmpty()) {
            throw new IllegalArgumentException("Ключ не может быть null или пустым");
        }
        return properties.getProperty(key.trim());
    }
}
