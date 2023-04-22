package com.example.demo.dao;

import com.example.demo.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    UserDao userDao;

    @BeforeEach
    public void setUp() {
        userDao = new UserDaoImpl();
    }

    @Test
    void findAllUsers_Should_Return_All_Users() throws Exception {

        List<User> expectedUsers = Arrays.asList(
                new User("olesy@gmail.com", "GUEST"),
                new User("kirill@gmail.com", "USER"),
                new User("remy@gmail.com", "ADMIN")
        );
        List<User> actualUsers = userDao.findAllUsers();
        assertEquals(expectedUsers.size(), actualUsers.size());

        // Проверяем, что каждый элемент списка actualUsers содержится в списке expectedUsers
        assertTrue(expectedUsers.stream().map(User::getUsername).allMatch(username ->
                actualUsers.stream().map(User::getUsername).anyMatch(username::equals)));

    }

    @Test
    void getUserByName_Should_Return_User() throws Exception {
        assertEquals("olesy@gmail.com", userDao.getUserByName("olesy@gmail.com").getUsername());
    }

    @Test
    void getUserByName_Should_Return_Null_When_User_Not_Found() throws Exception {
        assertNull(userDao.getUserByName("NULL@gmail.com"));
    }

    @Test
    void getUserByName_Should_Return_Null_When_Username_Is_Null() throws Exception {
        assertNull(userDao.getUserByName(null));
    }

    @Test
    void getUserByName_Should_Return_Not_Null_When_Username() throws Exception {
        assertNotNull(userDao.getUserByName("olesy@gmail.com"));
    }

    @Test
    void findAllUsers() {
    }
}