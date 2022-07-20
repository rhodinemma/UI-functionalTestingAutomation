package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FrameworkProperties {
    private String result = "";
    private InputStream inputStream;

    public String getProperty(String key) {
        try {
            Properties properties = new Properties();
            String propFileName = Constants.PROP_FILE_NAME;

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if(inputStream != null) {
                properties.load(inputStream);
            }else{
                System.out.println(Constants.EXCEPTION_MESSAGE);
            }

            String propertyValue = properties.getProperty(key);

            this.result = propertyValue;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
