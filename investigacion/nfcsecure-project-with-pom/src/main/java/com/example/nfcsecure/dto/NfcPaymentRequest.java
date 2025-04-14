package com.example.nfcsecure.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class NfcPaymentRequest {
    @NotBlank(message = "El token NFC es obligatorio")
    private String nfcToken;

    @Positive(message = "El monto debe ser positivo")
    private Double amount;
}
