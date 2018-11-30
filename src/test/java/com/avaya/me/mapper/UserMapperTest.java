package com.avaya.me.mapper;

import com.avaya.me.entity.UserEntity;
import com.avaya.me.enums.UserSexEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() {
//        this.userMapper.insert(new UserEntity("aa", "a123456", UserSexEnum.MAN));
//        this.userMapper.insert(new UserEntity("bb", "a123456", UserSexEnum.MAN));
//        this.userMapper.insert(new UserEntity("cc", "a123456", UserSexEnum.WOMAN));

        Assert.assertEquals(3, userMapper.getAll().size());
    }


//    @Test
//    public void testGetByusername() {
//        List<UserEntity> userList = this.userMapper.getByusername(new UserEntity("cc", "a123456", UserSexEnum.WOMAN));
//
//        Assert.assertEquals(1, userList.size());
//
//    }

}
