package yankunwei.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class MD5Tool {
    public static String MD5Encrypt(String message) {
        byte[] oldMessageBytes = message.getBytes();
        MessageDigest messageDigest = null;
        String MD5password = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            byte[] newMessageByte = messageDigest.digest(oldMessageBytes);
            Base64.Encoder encoder = Base64.getEncoder();
            MD5password = encoder.encodeToString(newMessageByte);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return MD5password;
    }
}
