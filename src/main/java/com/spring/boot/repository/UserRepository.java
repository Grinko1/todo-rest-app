package com.spring.boot.repository;

import com.spring.boot.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    public UserEntity findByLogin(String name);
}
