package com.scaffolding.scaffolding.service;

import com.scaffolding.scaffolding.entity.Customer;
import com.scaffolding.scaffolding.entity.Password;
import com.scaffolding.scaffolding.repository.CustomerRepository;
import com.scaffolding.scaffolding.repository.PasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    private final CustomerRepository customerRepository;

    @Autowired
    private final PasswordRepository passwordRepository;

    public CustomerService(CustomerRepository customerRepository, PasswordRepository passwordRepository) {
        this.customerRepository = customerRepository;
        this.passwordRepository = passwordRepository;
    }

    public Customer getOne(UUID id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            return customer.get();
        } else {
            throw new RuntimeException("USER SERVICE: Could not get Customer with id " + id);
        }
    }

    public UUID create(Customer customer) {
        customer.setId(UUID.randomUUID());
        Password password = new Password(customer);
        customerRepository.save(customer);
        Password savedPassword = passwordRepository.save(password);
        System.err.println(password.equals(savedPassword));
        return savedPassword.getValue();
    }

    public String update(Customer customer) {
        //return repository.save(customer);
        return "Updated customer with id " + customer.getId();
    }

    public Long delete(Long id) {
        //repository.deleteById(id);
        return id;
    }

}
