package com.matheus.paymentplatform.customer.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CpfValidator implements ConstraintValidator<ValidCpf, String>{

    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext context) {

        if (cpf == null){
            return false;
        }

        if(cpf.length() != 11){
            return false;
        }

        if (!cpf.matches("\\d{11}")) {
            return false;
        }

        if (cpf.chars().distinct().count() == 1) {
            return false;
        }

        int firstDigit = calculateFirstDigit(cpf);
        int informedFirstDigit = Character.getNumericValue(cpf.charAt(9));

        int secondDigit = calculateSecondDigit(cpf);
        int informedSecondDigit = Character.getNumericValue(cpf.charAt(10));



        return firstDigit == informedFirstDigit && secondDigit == informedSecondDigit;
    }

    private int calculateFirstDigit(String cpf){
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int digit = Character.digit(cpf.charAt(i),10);
            int weight = 10 - i;

            sum += digit * weight;
        }
        int remainder = sum % 11;
        return remainder < 2 ? 0 : 11 - remainder;
    }

    private int calculateSecondDigit(String cpf){
        int sum = 0;

        for (int i = 0; i < 10; i++) {
            int digit = Character.digit(cpf.charAt(i),10);
            int weight = 11 - i;

            sum += digit * weight;
        }

        int remainder = sum % 11;

        return remainder < 2 ? 0 : 11 - remainder;
    }

}
