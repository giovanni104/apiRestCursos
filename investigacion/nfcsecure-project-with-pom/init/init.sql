
CREATE DATABASE IF NOT EXISTS nfc_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE nfc_db;

CREATE TABLE IF NOT EXISTS payment (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    encrypted_token VARCHAR(255) NOT NULL UNIQUE,
    amount DOUBLE NOT NULL,
    timestamp DATETIME,
    audit_info VARCHAR(255)
);
