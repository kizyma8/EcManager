package com.springproject.dao;

import com.springproject.model.User;

import java.util.List;

/**
 * Created by Женя on 20.02.2017.
 */
public interface UserDao {
    List<User> getUserList();

    User getUserByUsername(String username);

    void addUser(User user);

    void editUser(User user);

    void deleteUser(User user);

    User getUserById(int id);
}
