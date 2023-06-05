package com.scaffolding.scaffolding.controller;

import com.scaffolding.scaffolding.entity.User;
import com.scaffolding.scaffolding.service.UserService;
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

@RestController
@RequestMapping("/user")
/*@OpenAPIDefinition(
        info = @Info(
                title = "User API",
                description = "This API allows the user to perform basic HTTP requests over an User."
        )
)*/
public class UserController {

    @Autowired
    private final UserService service;

    public UserController(UserService service){
        this.service = service;
    }

    @Operation(
            method = "GET", description = "Shows one user",
            parameters = @Parameter( name = "id", description = "Wanted user's ID", required = true)
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = {@Content(mediaType = "application/json")})
    })
    @GetMapping("/{id}")
    public ResponseEntity<User> getOne(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(service.getOne(id), HttpStatus.OK);
    }



    @Operation(
            method = "POST", description = "Creates a new user",
            parameters = @Parameter( name = "user", required = true)
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = {@Content(mediaType = "application/json")})
    })
    @PostMapping
    public ResponseEntity<String> create(@RequestBody User user) {
        return new ResponseEntity<>(service.create(user), HttpStatus.CREATED);
    }



    @Operation(
        method = "PUT", description = "Overwrites the specified user",
        parameters = @Parameter(name = "User", description = "whole user object", required = true)
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Success", content = {@Content(mediaType = "application/json")})
    })
    @PutMapping
    public ResponseEntity<String> updateFull(@RequestBody User user) {
        return new ResponseEntity<>("User updated", HttpStatus.OK);
    }



    @Operation(
            method = "PATCH", description = "Modifies a user partially",
            parameters = @Parameter( name = "user", required = true)
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = {@Content(mediaType = "application/json")})
    })
    @PatchMapping
    public ResponseEntity<String> update(@RequestBody User user) {
        return new ResponseEntity<>("User successfully modified", HttpStatus.OK);
    }



    @Operation(
            method = "DELETE", description = "Deletes user with parameter ID",
            parameters = @Parameter( name = "id", description = "User ID", required = true)
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = {@Content(mediaType = "application/json")})
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>("Returns user ID", HttpStatus.OK);
    }
}
