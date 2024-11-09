package com.example.TestTask.spring_boot.Dao;

import org.springframework.stereotype.Repository;
import com.example.TestTask.spring_boot.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
}