package Assessment12OrangeHRMData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {

    public static String getData(String key) throws IOException {

        FileInputStream fis = new FileInputStream(
                "./src/test/resources/orangehrm_day12/Config2.properties");

        Properties prop = new Properties();

        prop.load(fis);

        String value = prop.getProperty(key);

        fis.close();

        return value;
    }
}