package com.example.demo.services;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // поулчаем  расширение от Mockito.
public class UserServiceTest {


    private static final User TEST_USER1 = new User("testUser1", "password");
    private static final User TEST_USER2 = new User("testUser2", "password");
    @Mock
    private UserDao dao;
    @InjectMocks
    private UserService userService;


    @Test
    public void testCheckUserExistTrue() throws Exception {
        when(dao.getUserByName("testUser1")).thenReturn(TEST_USER1);
        // передаем имя пользователя, который должен существовать в dao
        assertTrue(userService.checkUserExist(new User("testUser1", "password")));
    }

    @Test
    public void testCheckUserExistFalse() throws Exception {
        when(dao.getUserByName("testUser1")).thenReturn(TEST_USER1);
        // передаем имя пользователя, который не должен существовать в dao
        assertFalse(userService.checkUserExist(new User("testUser2", "password")));
    }
}
