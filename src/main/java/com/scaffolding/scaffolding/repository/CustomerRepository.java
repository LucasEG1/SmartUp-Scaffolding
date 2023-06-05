package com.scaffolding.scaffolding.repository;

import com.scaffolding.scaffolding.entity.Customer;
import com.scaffolding.scaffolding.entity.LoginBean;
import com.scaffolding.scaffolding.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    Customer findByDni(String dni);
}
