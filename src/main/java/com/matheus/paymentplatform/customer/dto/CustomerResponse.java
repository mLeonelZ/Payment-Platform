package com.matheus.paymentplatform.customer.dto;

import com.matheus.paymentplatform.customer.domain.CustomerStatus;

import java.time.Instant;

public record CustomerResponse(
        Long id,
        String name,
        String cpf,
        String email,
        CustomerStatus status,
        Instant createdAt
) {
}
