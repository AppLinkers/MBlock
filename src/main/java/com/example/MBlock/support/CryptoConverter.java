package com.example.MBlock.support;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Base64;
import java.util.Optional;

@Converter
public class CryptoConverter implements AttributeConverter<Optional<String>, String> {

    public static String alg = "AES/CBC/PKCS5Padding";

    //@Value("${encryption.key}")
    private String key = "WnZr4u7x!A%D*G-KaPdSgVkYp2s5v8y/";

    private final String iv = key.substring(0, 16); // 16byte

    private String encrypt(String text) throws Exception {
        Cipher cipher = Cipher.getInstance(alg);
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
        IvParameterSpec ivParamSpec = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParamSpec);

        byte[] encrypted = cipher.doFinal(text.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encrypted);
    }

    private String decrypt(String cipherText) throws Exception {
        Cipher cipher = Cipher.getInstance(alg);
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
        IvParameterSpec ivParamSpec = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivParamSpec);

        byte[] decodedBytes = Base64.getDecoder().decode(cipherText);
        byte[] decrypted = cipher.doFinal(decodedBytes);
        return new String(decrypted, "UTF-8");
    }

    @SneakyThrows
    @Override
    public String convertToDatabaseColumn(Optional<String> plainText) {
        if (plainText != null) {
            return encrypt(plainText.get());
        } else {
            return "";
        }

    }

    @SneakyThrows
    @Override
    public Optional<String> convertToEntityAttribute(String encrypted) {
        if (encrypted.equals("")) {
            return null;
        } else {
            return Optional.of(decrypt(encrypted));
        }
    }
}