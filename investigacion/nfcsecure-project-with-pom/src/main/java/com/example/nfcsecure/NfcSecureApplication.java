package com.example.nfcsecure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ConfigurationPropertiesScan
@PropertySource(value = "file:.env", ignoreResourceNotFound = true)
public class NfcSecureApplication {
    public static void main(String[] args) {
        SpringApplication.run(NfcSecureApplication.class, args);
    }
}
