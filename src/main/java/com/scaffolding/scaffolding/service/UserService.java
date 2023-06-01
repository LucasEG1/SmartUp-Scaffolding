package com.scaffolding.scaffolding.service;

import com.scaffolding.scaffolding.entity.User;
import com.scaffolding.scaffolding.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public String getOne(Long id) {
        //return repository.findById(id);
        return "Found user with id " + id;
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
