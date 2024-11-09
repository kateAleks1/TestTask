package com.example.TestTask.spring_boot.service;


import com.example.TestTask.spring_boot.entity.User;

import java.util.Optional;

public interface UserService {
Optional<User> registerUser(User user);
    Optional<User> findByUsername(String userName);
}
