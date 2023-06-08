package com.example.setup.app.controller;

import com.example.setup.app.dtos.UserDto;
import com.example.setup.app.models.UserModel;
import com.example.setup.app.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/users")
public class UserController {
    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody @Valid UserDto userDto) {
        var userModel = new UserModel();
        BeanUtils.copyProperties(userDto, userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
    }

    @GetMapping
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{userId}")
    public Optional<UserModel> getUserById(@PathVariable(value = "userId") String userId) {
        return userService.getUserById(UUID.fromString(userId));
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{userId}")
    public void updateUser(@PathVariable(value = "userId") String userId) {
        userService.deleteUserById(UUID.fromString(userId));
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{userId}")
    public void deleteUserById(@PathVariable(value = "userId") String userId) {
        userService.deleteUserById(UUID.fromString(userId));
    }
}
