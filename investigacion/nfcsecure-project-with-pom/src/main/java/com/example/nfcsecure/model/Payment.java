package com.example.nfcsecure.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String encryptedToken;

    @Column(nullable = false)
    private Double amount;

    private LocalDateTime timestamp;

    private String auditInfo;
    
    @Column(nullable = false, unique = true)
    private String tokenHash;
    
    @Transient
    @JsonProperty     
    private String decryptedToken;
}
