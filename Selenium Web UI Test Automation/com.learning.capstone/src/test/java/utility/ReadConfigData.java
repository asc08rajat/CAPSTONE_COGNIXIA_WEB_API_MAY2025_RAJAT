package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigData {
    private static Properties prop;

    static {
        try {
            FileInputStream fis = new FileInputStream("./test_Data/config.properties");
            prop = new Properties();
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }

    public static boolean getBoolean(String key) {
        return Boolean.parseBoolean(prop.getProperty(key));
    }
}

	
	
