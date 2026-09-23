package com.matheus.paymentplatform.customer.dto;

import com.matheus.paymentplatform.customer.validation.ValidCpf;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CustomerRequest (
        @NotBlank
        String name,

        @NotBlank
        @ValidCpf
        String cpf,

        @NotBlank
        @Email
        String email
){
}
