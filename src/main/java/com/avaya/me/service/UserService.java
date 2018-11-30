package com.avaya.me.service;

import com.avaya.me.entity.UserEntity;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public interface UserService {

    UserEntity insert(UserEntity userEntity);
    void deleteById(Long id);
    UserEntity getUserById(long id);
    UserEntity update(UserEntity userEntity);
    List<UserEntity> findall();
}

