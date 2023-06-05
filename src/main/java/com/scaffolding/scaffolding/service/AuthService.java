package com.scaffolding.scaffolding.service;

import com.scaffolding.scaffolding.entity.Customer;
import com.scaffolding.scaffolding.entity.LoginBean;
import com.scaffolding.scaffolding.entity.Password;
import com.scaffolding.scaffolding.repository.CustomerRepository;
import com.scaffolding.scaffolding.repository.PasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthService {


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordRepository passwordRepository;

    public String login(LoginBean loginBean) {
        Customer repoCustomer = customerRepository.findByDni(loginBean.getDni());
        Password repoPassword = passwordRepository.findByValue(loginBean.getPassword());
        if(!loginBean.getDni().equals(repoPassword.getCustomer().getDni())) {
            throw new RuntimeException("Customer with dni: " + loginBean.getDni() +" does not exist.");
        }
        return "Welcome!";
    }
}
