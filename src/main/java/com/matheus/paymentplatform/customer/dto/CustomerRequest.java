package com.matheus.paymentplatform.customer.dto;

public record CustomerRequest (
        String name,
        String cpf,
        String email
){
}
