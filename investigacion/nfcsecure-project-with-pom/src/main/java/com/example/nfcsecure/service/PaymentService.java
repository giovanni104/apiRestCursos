package com.example.nfcsecure.service;

import com.example.nfcsecure.dto.NfcPaymentRequest;
import com.example.nfcsecure.model.Payment;
import com.example.nfcsecure.repository.PaymentRepository;
import com.example.nfcsecure.util.AesEncryptor;
import com.example.nfcsecure.util.HashUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public String processPayment(NfcPaymentRequest request) {
        log.info("Procesando pago con token: {} y monto: {}", request.getNfcToken(), request.getAmount());

        String tokenHash = HashUtil.sha256(request.getNfcToken());

        if (paymentRepository.findByTokenHash(tokenHash).isPresent()) {
            log.warn("Token NFC ya fue usado previamente");
            return "Error: Token ya ha sido utilizado";
        }

        String encryptedToken = AesEncryptor.encrypt(request.getNfcToken());

        Payment payment = new Payment();
        payment.setTokenHash(tokenHash);
        payment.setEncryptedToken(encryptedToken);
        payment.setAmount(request.getAmount());
        payment.setTimestamp(LocalDateTime.now());
        payment.setAuditInfo("Creado por API REST a las " + LocalDateTime.now());
        paymentRepository.save(payment);

        log.debug("Pago guardado con token cifrado, hash y auditoría");
        return "Transacción aprobada";
    }

    public List<Payment> getAllPayments() {
        List<Payment> payments = paymentRepository.findAll();
        String role = org.springframework.security.core.context.SecurityContextHolder.getContext()
                        .getAuthentication().getAuthorities().toString();

        boolean showDecrypted = role.contains("ADMIN") || role.contains("AUDITOR");

        for (Payment p : payments) {
            if (showDecrypted) {
                try {
                    String decrypted = AesEncryptor.decrypt(p.getEncryptedToken());
                    p.setDecryptedToken(decrypted);
                } catch (Exception e) {
                    log.error("Error descifrando token con ID {}: {}", p.getId(), e.getMessage());
                    p.setDecryptedToken("[Error al descifrar]");
                }
            } else {
                p.setDecryptedToken("[RESTRINGIDO]");
            }
        }
        return payments;
    }
}