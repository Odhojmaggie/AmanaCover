package com.AmanaCover.entity;

import com.AmanaCover.enums.PolicyStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "policies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String policyNumber;

    @Column(nullable = false)
    private String insuredName;

    @Column(nullable = false)
    private BigDecimal premium;

    @Enumerated(EnumType.STRING)
    private PolicyStatus status;

    private LocalDateTime createdAt;
}
