package com.example.setup.app.service;

import com.example.setup.app.models.UserModel;
import com.example.setup.app.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserModel save(UserModel userModel) {
        return userRepository.save(userModel);
    }

    public List<UserModel> getAll() {
        return userRepository.findAll();
    }

    public Optional<UserModel> getUserById(UUID userId) {
        return userRepository.findById(userId);
    }

    public void deleteUserById(UUID userId) {
        userRepository.deleteById(userId);
    }
}
