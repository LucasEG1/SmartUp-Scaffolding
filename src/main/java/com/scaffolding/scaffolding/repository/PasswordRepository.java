package com.scaffolding.scaffolding.repository;

import com.scaffolding.scaffolding.entity.Password;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PasswordRepository extends JpaRepository<Password, Integer> {
    Password findByValue(String value);

    Password findByCustomerId(UUID id);

    Password findByValueAndCustomerId(String password, UUID id);
}
