package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class PropertiesReading {

    private static final String PROPERTIES_FILE_PATH = "config.properties";
    private static Properties properties = new Properties();

    static {
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(PROPERTIES_FILE_PATH), StandardCharsets.UTF_8)) {
            properties.load(reader);
        } catch (IOException e) {
            throw new ExceptionInInitializerError("Не удалось загрузить config.properties: " + e.getMessage());
        }
    }

    public static String getProperty(String key) {
        if (key == null || key.trim().isEmpty()) {
            throw new IllegalArgumentException("Ключ не может быть null или пустым");
        }
        String value = System.getProperty(key.trim(), properties.getProperty(key.trim()));
        return value == null ? null : value.trim();
    }

    public static String getProperty(String key, String defaultValue) {
        String value = getProperty(key);
        return value == null || value.isEmpty() ? defaultValue : value;
    }

    public static boolean getBoolean(String key, boolean defaultValue) {
        return Boolean.parseBoolean(getProperty(key, String.valueOf(defaultValue)));
    }
}

