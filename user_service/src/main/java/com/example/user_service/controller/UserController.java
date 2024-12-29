package com.example.user_service.controller;

import com.example.user_service.dto.request.UserRequestDTO;
import com.example.user_service.dto.response.UserResponseDTO;
import com.example.user_service.exception.UserFieldNotUniqueException;
import com.example.user_service.exception.UserNotFoundException;
import com.example.user_service.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/")
    public String hello() {
        return "hello from users-service!!";
    }

    @PostMapping(value = "/")
    public ResponseEntity<UserResponseDTO> register(@RequestBody @Valid UserRequestDTO dto) {
        UserResponseDTO createdUser = userService.createUser(dto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable int id) {
        UserResponseDTO userInfo = userService.getUserById(id);
        return new ResponseEntity<>(userInfo, HttpStatus.OK);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> userNotFoundException(UserNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserFieldNotUniqueException.class)
    public ResponseEntity<String> userFieldNotUniqueException(UserFieldNotUniqueException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
