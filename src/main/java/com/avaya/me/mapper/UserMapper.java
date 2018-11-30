package com.avaya.me.mapper;

import com.avaya.me.entity.UserEntity;
import com.avaya.me.enums.UserSexEnum;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

public interface UserMapper {

    @Select("SELECT * FROM user_entity")
    @Results({
            @Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nick_name")
    })
    List<UserEntity> getAll();

    @Select("SELECT * FROM user_entity WHERE id = #{id}")
    @Results({
            @Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nick_name")
    })
    UserEntity getOne(Long id);

    @Insert("INSERT INTO user_entity(userName,passWord,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
    void insert(UserEntity user);

    @Update("UPDATE user_entity SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
    void update(UserEntity user);

    @Delete("DELETE FROM user_entity WHERE id =#{id}")
    void delete(Long id);

}
