package com.example.user_service.repository;

import com.example.user_service.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Integer> {
    UserInfo findByEmailId(String emailId);

    UserInfo findByUsername(String username);

    boolean existsByEmailIdOrUsername(String emailId, String username);

    boolean existsByUsername(String username);

    boolean existsByEmailId(String emailId);
}
