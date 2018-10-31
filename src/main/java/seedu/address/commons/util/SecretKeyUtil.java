package seedu.address.commons.util;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;


/**
 * Creates a secret key from String and vice-versa
 */
public class SecretKeyUtil {

    /**
     * Creates a secret key
     * @param algorithm used to generate the secret key from {@code KeyGenerator}
     * @return An instance of {@code SecretKey} generated
     */
    public static SecretKey getSecretKey(String algorithm) {
        KeyGenerator keyGenerator = null;

        try {
            keyGenerator = KeyGenerator.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return keyGenerator.generateKey();
    }

    /**
     * Converts a {@code SecretKey} to a {@code String}
     */
    public static String keyToString(SecretKey secretKey) {
        byte[] encoded = secretKey.getEncoded();

        String encodeToString = Base64.getEncoder().encodeToString(encoded);

        return encodeToString;
    }
}