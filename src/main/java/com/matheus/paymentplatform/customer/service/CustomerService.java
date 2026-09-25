package com.matheus.paymentplatform.customer.service;

import com.matheus.paymentplatform.customer.domain.Customer;
import com.matheus.paymentplatform.customer.dto.CustomerRequest;
import com.matheus.paymentplatform.customer.dto.CustomerResponse;
import com.matheus.paymentplatform.customer.dto.CustomerUpdateRequest;
import com.matheus.paymentplatform.customer.exception.CustomerNotFoundException;
import com.matheus.paymentplatform.customer.exception.ResourceAlreadyExistsException;
import com.matheus.paymentplatform.customer.mapper.CustomerMapper;
import com.matheus.paymentplatform.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public CustomerService(CustomerRepository repository, CustomerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public CustomerResponse create(CustomerRequest request){
        if(repository.existsByCpf(request.cpf())){
            throw new ResourceAlreadyExistsException("CPF already exists.");
        }
        if (repository.existsByEmail(request.email())){
            throw new ResourceAlreadyExistsException("Email already exists.");
        }
        Customer customer = mapper.toEntity(request);
        Customer savedCustomer = repository.save(customer);

        return mapper.toResponse(savedCustomer);
    }

    public CustomerResponse findById(Long id){
        Customer customer = repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
        return mapper.toResponse(customer);
    }

    public List<CustomerResponse> findAll(){
        List<Customer> customers = repository.findAll();
        return customers.stream()
                .map(mapper::toResponse)
                .toList();
    }

    public CustomerResponse update(Long id, CustomerUpdateRequest request) {
        Customer customer = repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));

        if (!customer.getEmail().equals(request.email()) && repository.existsByEmail(request.email())) {
            throw new ResourceAlreadyExistsException("Email already exists.");
        }

        customer.setName(request.name());
        customer.setEmail(request.email());

        Customer updatedCustomer = repository.save(customer);
        return mapper.toResponse(updatedCustomer);
    }


}
