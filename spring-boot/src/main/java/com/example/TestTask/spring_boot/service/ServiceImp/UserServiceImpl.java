package com.example.TestTask.spring_boot.service.ServiceImp;

import com.example.TestTask.spring_boot.Dao.UserRepository;
import com.example.TestTask.spring_boot.Exceptions.UsernameAlreadyExistsException;
import com.example.TestTask.spring_boot.entity.User;
import com.example.TestTask.spring_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private  PasswordEncoder passwordEncoder;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Override
    public Optional<User> registerUser(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new UsernameAlreadyExistsException("Username already exists!");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return Optional.of(userRepository.save(user));
    }

    @Override
    public Optional<User> findByUsername(String userName) {
       return Optional.of(userRepository.findByUsername(userName).get());
    }
}
