package com.example.user_service.mapper;

import com.example.user_service.dto.request.UserRequestDTO;
import com.example.user_service.dto.response.UserResponseDTO;
import com.example.user_service.entity.UserInfo;
import com.example.user_service.util.Gender;
import com.example.user_service.util.User_Role;

public class UserMapper {
    public static UserResponseDTO from(UserInfo userInfo) {
        return UserResponseDTO.builder()
                .id(userInfo.getId())
                .username(userInfo.getUsername())
                .emailId(userInfo.getEmailId())
                .firstName(userInfo.getFirstName())
                .lastName(userInfo.getLastName())
                .age(userInfo.getAge())
                .gender(userInfo.getGender().toString())
                .role(userInfo.getRole().toString())
                .build();
    }

    public static UserInfo from(UserRequestDTO dto) {
        return UserInfo.builder()
                .username(dto.getUsername())
                .emailId(dto.getEmailId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .age(dto.getAge())
                .gender(Gender.valueOf(dto.getGender()))
                .password(dto.getPassword())
                .role(User_Role.valueOf(dto.getRole()))
                .build();
    }
}
