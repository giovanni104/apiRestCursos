package com.example.nfcsecure.controller;

import com.example.nfcsecure.dto.NfcPaymentRequest;
import com.example.nfcsecure.model.Payment;
import com.example.nfcsecure.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/nfc")
    public ResponseEntity<String> pagarConNfc(@Valid @RequestBody NfcPaymentRequest request) {
        String respuesta = paymentService.processPayment(request);
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping
    public ResponseEntity<List<Payment>> obtenerPagos() {
        List<Payment> pagos = paymentService.getAllPayments();
        return ResponseEntity.ok(pagos);
    }
}
