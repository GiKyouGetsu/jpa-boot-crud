package com.avaya.me.service.serviceimpl;

import com.avaya.me.dao.UserRepostory;
import com.avaya.me.entity.UserEntity;
import com.avaya.me.mapper.UserMapper;
import com.avaya.me.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

@Configuration
public class UserServicesImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepostory userRepostory;

    @Override
    public UserEntity insert(UserEntity userEntity) {

        UserEntity user = userRepostory.findByUserName(userEntity.getUserName());

        if (user != null) {
            return null;
        } else {
            Date date = new Date();
            userEntity.setCreateTime(new Timestamp(date.getTime()));
            userEntity.setChangeTime(new Timestamp(date.getTime()));
            return userRepostory.save(userEntity);
        }
    }


    @Override
    public void deleteById(Long id) {
        userRepostory.delete(id);
    }

    @Override
    public UserEntity update(UserEntity userEntity) {
        Date date = new Date();

        Timestamp nowtime = new Timestamp(date.getTime());
        UserEntity existUser = userRepostory.findByUserName(userEntity.getUserName());

        if ( existUser != null) {
            userEntity.setId(existUser.getId());
        } else {
            userEntity.setCreateTime(nowtime);
        }
        userEntity.setChangeTime(nowtime);

        return userRepostory.save(userEntity);
    }

    @Override
    public List<UserEntity> findall() {
        return userRepostory.findAll();
    }

    @Override
    public UserEntity getUserById(long id) {
        return userRepostory.findOne(id);
    }
}
