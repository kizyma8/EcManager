package com.springproject.service.impl;

import com.springproject.dao.UserDao;
import com.springproject.model.User;
import com.springproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public List<User> getUserList() {
        return userDao.getUserList();
    }

    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    public void addUser(User user) {
        userDao.addUser(user);

    }

    public void editUser(User user) {
        userDao.editUser(user);
    }

    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    public User getUserById(int id) {
        return userDao.getUserById(id);
    }
}
