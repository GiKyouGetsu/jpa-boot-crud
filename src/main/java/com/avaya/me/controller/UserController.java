package com.avaya.me.controller;

import com.avaya.me.controller.response.*;
import com.avaya.me.entity.UserEntity;
import com.avaya.me.mapper.UserMapper;
import com.avaya.me.service.UserService;
import com.sun.jnlp.ApiDialog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.text.html.parser.Entity;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public ResponseEntity getUsers() {

        List<UserEntity> users = userService.findall();

        APIResult res = PageResult.PageResultBuilder.getInstance()
                .total(users.size())
                .perSize(10)
                .message("OK")
                .code(200)
                .data(users)
                .build();

        return ResponseEntity.status(200).body(res);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Long id) {

        UserEntity user = userService.getUserById(id);

        APIResult res = APIResult.APIResultBuilder.getInstance()
                .code(200)
                .message("User got")
                .data(user)
                .build();
        System.out.println(res);
        return ResponseEntity.status(200).body(res);

    }

    @PostMapping("/users")
    public ResponseEntity<Object> save(@RequestBody  UserEntity user) {
        try {
            System.out.println(user);
            UserEntity saveduser = userService.insert(user);

            if (saveduser == null) {
                return ResponseEntity.status(500).body("User has existed");
            }

            System.out.println("Add user successed");

            APIResult res = APIResult.APIResultBuilder.getInstance()
                    .code(201)
                    .message("User Created")
                    .data(UserResponseDetails
                            .UserResponseDetailsBuiler
                            .getInstance()
                            .id(saveduser.getId())
                            .username(saveduser.getUserName())
                            .link(RequestMess
                                    .RequestMessBuilder
                                    .newInstance()
                                    .method("GET")
                                    .url("Http://localhost:8080/user/" + saveduser.getId())
                                    .build())
                            .build())
                    .build();

            System.out.println(saveduser);
            return ResponseEntity.status(201).body(res);

        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PutMapping(value="/users")
    public ResponseEntity<APIResult> update(@RequestBody UserEntity user) {
        userService.update(user);

        APIResult res = APIResult.APIResultBuilder.getInstance()
                .code(202)
                .message("User updated")
                .data(UserResponseDetails
                        .UserResponseDetailsBuiler
                        .getInstance()
                        .id(user.getId())
                        .username(user.getUserName())
                        .link(RequestMess
                                .RequestMessBuilder
                                .newInstance()
                                .method("GET")
                                .url("Http://localhost:8080/user/" + user.getId())
                                .build())
                        .build())
                .build();

        return ResponseEntity.status(202).body(res);

    }

    @DeleteMapping(value="/users/{id}")
    public void delete(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }
}
