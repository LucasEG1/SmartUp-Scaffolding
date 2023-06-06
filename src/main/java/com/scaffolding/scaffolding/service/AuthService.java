package com.scaffolding.scaffolding.service;

import com.scaffolding.scaffolding.entity.Customer;
import com.scaffolding.scaffolding.entity.LoginBean;
import com.scaffolding.scaffolding.entity.Password;
import com.scaffolding.scaffolding.exception.InvalidPasswordException;
import com.scaffolding.scaffolding.exception.UnexistingCustomerException;
import com.scaffolding.scaffolding.repository.CustomerRepository;
import com.scaffolding.scaffolding.repository.PasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordRepository passwordRepository;

    @Autowired
    private PasswordManagerService passwordManagerService;

    public String login(LoginBean loginBean) {
        Customer repoCustomer = customerRepository.findByDni(loginBean.getDni());
        Password repoPassword = passwordRepository.findByValueAndCustomerId(loginBean.getPassword(), repoCustomer.getId());
        if(repoPassword == null) {
            throw new InvalidPasswordException("Incorrect password for given customer");
        }
        if(!loginBean.getDni().equals(repoPassword.getCustomer().getDni())) {
            throw new UnexistingCustomerException("Customer with dni: " + loginBean.getDni() +" does not exist.");
        }
        return "Welcome!";
    }
}
