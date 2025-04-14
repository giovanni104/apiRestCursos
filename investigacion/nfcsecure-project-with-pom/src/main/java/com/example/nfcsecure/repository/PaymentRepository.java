package com.example.nfcsecure.repository;

import com.example.nfcsecure.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
	 Optional<Payment> findByTokenHash(String tokenHash);
}
