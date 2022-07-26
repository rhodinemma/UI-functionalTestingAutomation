package utils;

import drivers.DriverSingleton;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.util.Base64;
import java.util.Random;

public class Utils {
    public static int testCount = 0;
    public static String decode64(String encodeStr){
        Base64.Decoder decoder = Base64.getDecoder();
        return new String(decoder.decode(encodeStr.getBytes()));
    }

    public static void takeScreenshot(){
        File file = ((TakesScreenshot) DriverSingleton.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileCopyUtils.copy(file, new File(Constants.FOLDER_NAME + generateRandomString() + Constants.EXTENSION));
        } catch (Exception ignored) {
        }
    }

    private static String generateRandomString(){
        String seedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        int i = 0;
        Random random = new Random();
        while(i < Constants.MAGIC_NUMBER){
            sb.append(seedChars.charAt(random.nextInt(seedChars.length())));
            i++;
        }
        return  sb.toString();
    }
}
