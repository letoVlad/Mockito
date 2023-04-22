package com.example.demo.dao;

import com.example.demo.model.User;

import java.util.List;

public interface UserDao {
    User getUserByName(String username) throws Exception;
    List<User> findAllUsers();
}
