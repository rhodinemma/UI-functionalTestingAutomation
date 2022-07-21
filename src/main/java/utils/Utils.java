package utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Utils {
    public static String decode64(String encodeStr){
        Base64.Decoder decoder = Base64.getDecoder();
        return new String(decoder.decode(encodeStr.getBytes()));
    }
}
