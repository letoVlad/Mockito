package com.example.demo.services;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;


public class UserService {
    private UserDao dao;

    public boolean checkUserExist(User user) throws Exception {
        User u = dao.getUserByName(user.getUsername());
        return u != null;
    }
}

