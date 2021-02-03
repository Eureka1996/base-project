package com.wufuqiang.encryption;

import com.wufuqiang.encryption.constant.CommonConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;


@Slf4j
public class AES {

    // 加密
    public static String encrypt(String sSrc, String sKey) throws Exception {
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            throw new Exception("Key长度不是16位");
        }
        byte[] raw = sKey.getBytes(StandardCharsets.UTF_8);
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding"); // "算法/模式/补码方式"
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes(StandardCharsets.UTF_8));
        return new Base64().encodeToString(encrypted); // 此处使用BASE64做转码功能，同时能起到2次加密的作用。
    }

    // 解密
    public static String decrypt(String sSrc, String sKey) throws Exception {
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            throw new Exception("Key长度不是16位");
        }
        byte[] raw = sKey.getBytes(StandardCharsets.UTF_8);
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] encrypted1 = new Base64().decode(sSrc);//先用base64解密
        byte[] original = cipher.doFinal(encrypted1);
        return new String(original, StandardCharsets.UTF_8);
    }

    public static void main(String[] args) throws Exception {
        String str = "maoyujiao is a beautiful girl.";
        String encrypt = AES.encrypt(str, CommonConstant.AES_KEY);
        System.out.println(encrypt);
        String decrypt = AES.decrypt(encrypt, CommonConstant.AES_KEY);
        System.out.println(decrypt);
    }
}
