// Proyecto: NFC Secure Payment API con Spring Boot, MySQL, AES-256 GCM y Auditoría
// Aplicando OWASP Top 10 - Extensión con Cifrado GCM, Auditoría, Docker, Swagger y .env

// 4. Utilidad: HashUtil.java (SHA-256 para validación de tokens únicos)
package com.example.nfcsecure.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

public class HashUtil {
    public static String sha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hash);
        } catch (Exception e) {
            throw new RuntimeException("Error generando hash SHA-256", e);
        }
    }
}
