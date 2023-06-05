package com.scaffolding.scaffolding.controller;

import com.scaffolding.scaffolding.entity.Customer;
import com.scaffolding.scaffolding.service.CustomerService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/customer")
@OpenAPIDefinition(
        info = @Info(
                title = "Customer API",
                description = "This API allows the customer to perform basic HTTP requests over a Customer."
        )
)
public class CustomerController {

    @Autowired
    private final CustomerService service;

    public CustomerController(CustomerService service){
        this.service = service;
    }

    @Operation(
            method = "GET", description = "Shows one customer",
            parameters = @Parameter( name = "id", description = "Wanted customer's ID", required = true)
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = {@Content(mediaType = "application/json")})
    })
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getOne(@PathVariable(value = "id") UUID id) {
        return new ResponseEntity<>(service.getOne(id), HttpStatus.OK);
    }
    @Operation(
            method = "POST", description = "Creates a new customer",
            parameters = @Parameter( name = "customer", required = true)
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created", content = {@Content(mediaType = "application/json")})
    })
    @PostMapping
    public ResponseEntity<UUID> create(@Valid @RequestBody Customer customer) {
        return new ResponseEntity<>(service.create(customer), HttpStatus.CREATED);
    }



    @Operation(
            method = "PUT", description = "Overwrites the specified customer",
            parameters = @Parameter(name = "Customer", description = "whole customer object", required = true)
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = {@Content(mediaType = "application/json")})
    })
    @PutMapping
    public ResponseEntity<String> updateFull(@RequestBody Customer customer) {
        return new ResponseEntity<>("Customer updated", HttpStatus.OK);
    }



    @Operation(
            method = "PATCH", description = "Modifies a customer partially",
            parameters = @Parameter( name = "customer", required = true)
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = {@Content(mediaType = "application/json")})
    })
    @PatchMapping
    public ResponseEntity<String> update(@RequestBody Customer customer) {
        return new ResponseEntity<>("Customer successfully modified", HttpStatus.OK);
    }



    @Operation(
            method = "DELETE", description = "Deletes customer with parameter ID",
            parameters = @Parameter( name = "id", description = "Customer ID", required = true)
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = {@Content(mediaType = "application/json")})
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>("Returns customer ID", HttpStatus.OK);
    }
}
