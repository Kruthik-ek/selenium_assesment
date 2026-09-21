package Assessment012OrangeHRMData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {

    public static String getData(String key) throws IOException {

        FileInputStream fis =new FileInputStream("./src/test/resources/Day12_assses_tc2/Config2.properties");

        Properties prop = new Properties();

        prop.load(fis);

        return prop.getProperty(key);
    }
}