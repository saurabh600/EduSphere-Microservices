package com.example.user_service.entity;

import com.example.user_service.util.Gender;
import com.example.user_service.util.User_Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user_credentials")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String emailId;

    private String password;

    private String firstName;

    private String lastName;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private User_Role role;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}
