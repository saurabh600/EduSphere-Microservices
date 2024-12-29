package com.example.user_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {
    private Integer id;
    private String username;
    private String emailId;
    private String firstName;
    private String lastName;
    private Integer age;
    private String role;
    private String gender;
}
