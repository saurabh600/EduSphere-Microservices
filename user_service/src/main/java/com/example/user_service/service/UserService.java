package com.example.user_service.service;

import com.example.user_service.dto.request.UserRequestDTO;
import com.example.user_service.dto.response.UserResponseDTO;
import com.example.user_service.entity.UserInfo;
import com.example.user_service.exception.UserFieldNotUniqueException;
import com.example.user_service.exception.UserNotFoundException;
import com.example.user_service.mapper.UserMapper;
import com.example.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserResponseDTO getUserById(int id) {
        UserInfo userInfo = userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException("user with id " + id + " not found"));

        return UserMapper.from(userInfo);
    }

    public UserResponseDTO createUser(UserRequestDTO dto) {
        if (userRepository.existsByEmailId(dto.getEmailId())) {
            throw new UserFieldNotUniqueException("user with given emailId " + dto.getEmailId() + " already exists");
        }

        if (userRepository.existsByUsername(dto.getUsername())) {
            throw new UserFieldNotUniqueException("user with given username " + dto.getUsername() + " already exits");
        }

        UserInfo userInfo = UserMapper.from(dto);

        UserInfo newUser = userRepository.save(userInfo);

        return UserMapper.from(newUser);
    }
}
