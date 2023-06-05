package com.scaffolding.scaffolding.service;

import com.scaffolding.scaffolding.entity.User;
import com.scaffolding.scaffolding.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User getOne(Long id) {
        Optional<User> user = repository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new RuntimeException("USER SERVICE: Could not get User with id " + id);
        }
    }

    public String create(User user) {
        //return repository.save(user);
        return "Created user " + user.getName() + " " + user.getSurname();
    }

    public String update(User user) {
        //return repository.save(user);
        return "Updated user with id " + user.getId();
    }

    public Long delete(Long id) {
        //repository.deleteById(id);
        return id;
    }

}
