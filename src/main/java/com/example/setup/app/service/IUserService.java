package com.example.setup.app.service;

import com.example.setup.app.dtos.UpdateUserDto;
import com.example.setup.app.models.UserModel;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IUserService {
    public UserModel save(UserModel userModel);
    public List<UserModel> getAll();
    public Optional<UserModel> getUserById(UUID userId);
    public void deleteUserById(UUID userId);
    public UserModel updateUserById(UUID userId, UpdateUserDto updateUserDto) throws UserPrincipalNotFoundException;
}
