package com.avaya.me.entity;

import com.avaya.me.enums.UserSexEnum;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

//    @Column(name="user_no", unique = true, nullable = false, length = 10)
//    private long user_no;

    @Column(name = "username", length = 30, nullable = false)
    private String userName;

    @Column(name = "password", nullable = false)
    private String passWord;

    @Column(name = "user_sex", nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private UserSexEnum userSex;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "create_time", columnDefinition = "timestamp")
    private Timestamp createTime;

    @Column(name = "change_time", columnDefinition = "timestamp")
    private Timestamp changeTime;


    public UserEntity() { super(); }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Timestamp changeTime) {
        this.changeTime = changeTime;
    }

    public UserSexEnum getUserSex() {
        return userSex;
    }

    public void setUserSex(UserSexEnum userSex) {
        this.userSex = userSex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public long getUser_no() { return user_no; }
//
//    public void setUser_no(long user_no) { this.user_no = user_no; }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", userSex=" + userSex +
                ", nickName='" + nickName + '\'' +
                ", createTime=" + createTime +
                ", changeTime=" + changeTime +
                '}';
    }
}
