package com.matheus.paymentplatform.customer.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CpfValidatorTest {

    private final CpfValidator validator = new CpfValidator();

    @Test
    void shouldReturnTrueForValidCpf(){
        String cpf = "01127476041";
        boolean result = validator.isValid(cpf, null);

        assertTrue(result);
    }

    @Test
    void shouldReturnFalseForInvalidCpf() {
        String cpf = "94105810010";
        boolean result = validator.isValid(cpf, null);

        assertFalse(result);
    }

    @Test
    void shouldReturnFalseForCpfWithLessThan11Digits() {
        String cpf = "123456789";
        boolean result = validator.isValid(cpf, null);

        assertFalse(result);
    }

    @Test
    void shouldReturnFalseForCpfWithMoreThan11Digits() {
        String cpf = "123456789012";
        boolean result = validator.isValid(cpf, null);

        assertFalse(result);
    }



}
