package com.matheus.paymentplatform.customer.mapper;

import com.matheus.paymentplatform.customer.domain.Customer;
import com.matheus.paymentplatform.customer.dto.CustomerRequest;
import com.matheus.paymentplatform.customer.dto.CustomerResponse;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer toEntity(CustomerRequest request){
        return new Customer(
                request.name(),
                request.cpf(),
                request.email()
        );
    }

    public CustomerResponse toResponse(Customer customer){
        return new CustomerResponse(
                customer.getId(),
                customer.getName(),
                customer.getCpf(),
                customer.getEmail(),
                customer.getStatus(),
                customer.getCreatedAt()
        );
    }

}
