package com.avaya.me.dao;

import com.avaya.me.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepostory extends CrudRepository<UserEntity, Long> {


    List<UserEntity> findAll();

    UserEntity findByUserName(String username);

    UserEntity save(UserEntity userEntity);

}
