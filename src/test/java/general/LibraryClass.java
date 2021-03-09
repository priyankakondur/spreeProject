package general;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LibraryClass {
    public static String getConfigProperties(String CONFIG_PATH, String key) throws IOException {
        String property = "";
        Properties prop = new Properties();
        try {
            FileInputStream configPath = new FileInputStream(CONFIG_PATH);
            prop.load(configPath);
            property = prop.getProperty(key);
        } catch (Exception e) {
            System.out.println(e);
        }
        return property;
    }
}
