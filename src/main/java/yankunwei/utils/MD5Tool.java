package yankunwei.utils;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Tool {
    public static String MD5Encrypt(String message) {
        byte[] oldMessageBytes = message.getBytes();
        MessageDigest messageDigest = null;
        String MD5password = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            byte[] newMessageByte = messageDigest.digest(oldMessageBytes);
            BASE64Encoder encoder = new BASE64Encoder();
            MD5password = encoder.encode(newMessageByte);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return MD5password;
    }
}
