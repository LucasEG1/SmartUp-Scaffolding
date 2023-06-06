package com.scaffolding.scaffolding.service;

import com.scaffolding.scaffolding.entity.Customer;
import com.scaffolding.scaffolding.entity.Password;
import com.scaffolding.scaffolding.exception.InvalidPasswordException;
import com.scaffolding.scaffolding.repository.PasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasswordManagerService {

    @Autowired
    private PasswordRepository passwordRepository;

    @Autowired
    private CustomerService customerService;

    public String changePassword(String dni, String oldPasswordValue, String newPasswordValue) {
        Customer owner = customerService.getOneByDni(dni);
        Password oldPassword = passwordRepository.findByCustomerId(owner.getId());
        if (!oldPasswordValue.equals(oldPassword.getValue())) {
            throw new InvalidPasswordException("Incorrect old password");
        }
        validatePassword(newPasswordValue);
        oldPassword.setValue(newPasswordValue);
        passwordRepository.save(oldPassword);
        return "Password updated";
    }


    private void validatePassword(String value) {
        if (value.length() < 8) {
            throw new InvalidPasswordException("Password length must have 8 characters or more");
        }
    }

    //checkIfPasswordBelongs
}
