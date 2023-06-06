package com.scaffolding.scaffolding.controller;

import com.scaffolding.scaffolding.DTO.ChangePasswordDTO;
import com.scaffolding.scaffolding.entity.LoginBean;
import com.scaffolding.scaffolding.service.AuthService;
import com.scaffolding.scaffolding.service.PasswordManagerService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@OpenAPIDefinition(
        info = @Info(
                title = "Customer API",
                description = "This API allows the customer to perform basic HTTP requests over a Customer."
        )
)
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private PasswordManagerService passwordManagerService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginBean loginBean) {
        return new ResponseEntity<>(authService.login(loginBean), HttpStatus.OK);
    }

    @PostMapping("/changePassword")
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordDTO body) {
        return new ResponseEntity<>(passwordManagerService.changePassword(body.getDni(), body.getOldPassword(), body.getNewPassword()), HttpStatus.OK);
    }
}
