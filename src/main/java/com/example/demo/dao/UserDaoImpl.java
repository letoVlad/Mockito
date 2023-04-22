package com.example.demo.dao;

import com.example.demo.model.User;

import java.util.Arrays;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private List<User> users;

    public UserDaoImpl(List<User> users) {
        this.users = users;
    }

    public UserDaoImpl() {
        this(Arrays.asList(
                new User("olesy@gmail.com", "GUEST"),
                new User("kirill@gmail.com", "USER"),
                new User("remy@gmail.com", "ADMIN")
        ));
    }

    @Override
    public User getUserByName(String username) throws Exception {
        //ищем в стрими по фильтру имя, если находим, то возвращаем его, если нет возвращаем null
        return users.stream().filter(u -> u.getUsername().equals(username)).findAny().orElse(null);
    }

    @Override
    public List<User> findAllUsers() {
        return users;
    }
}
