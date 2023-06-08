package com.example.setup.app.service;

import com.example.setup.app.dtos.UpdateUserDto;
import com.example.setup.app.models.UserModel;
import com.example.setup.app.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.beans.FeatureDescriptor;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class UserService implements  IUserService {
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

    @Transactional
    public UserModel updateUserById(UUID userId, UpdateUserDto updateUserDto) throws UserPrincipalNotFoundException {
        var optionalUserModel = userRepository.findById(userId);
        if(optionalUserModel.isPresent()) {
            var userModel = optionalUserModel.get();
            if(updateUserDto.getName() != null) {
                userModel.setName(updateUserDto.getName());
            }
            if(updateUserDto.getEmail() != null) {
                userModel.setEmail(updateUserDto.getEmail());
            }
            if(updateUserDto.getPassword() != null) {
                userModel.setPassword(updateUserDto.getPassword());
            }
            return userRepository.save(userModel);
        } else {
            throw new UserPrincipalNotFoundException("");
        }

    }
}
