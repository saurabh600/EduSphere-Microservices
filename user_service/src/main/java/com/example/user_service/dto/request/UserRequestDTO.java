package com.example.user_service.dto.request;

import com.example.user_service.util.Gender;
import com.example.user_service.util.User_Role;
import com.example.user_service.validation.EnumValidator;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {
    @NotBlank(message = "this field is required")
    private String username;

    @NotBlank(message = "this field is required")
    @Email(message = "please provide valid email address")
    private String emailId;

    @NotBlank(message = "this field is required")
    private String firstName;

    @NotBlank(message = "this field is required")
    private String lastName;

    @NotNull(message = "this field is required")
    @Min(value = 12, message = "you must be of 12 yo")
    @Max(value = 120, message = "you can not be more than 120 yo")
    private Integer age;

    @EnumValidator(enumClazz = User_Role.class, message = "invalid role")
    private String role;

    @EnumValidator(enumClazz = Gender.class, message = "invalid gender")
    private String gender;

    @Size(min = 7, max = 15, message = "password must be of 7-15 characters")
    private String password;
}
