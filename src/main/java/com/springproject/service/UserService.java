package com.springproject.service;


import com.springproject.model.User;

import java.util.List;

public interface UserService {
    List<User> getUserList();

    User getUserByUsername(String username);

    void addUser(User user);

    void editUser(User user);

    void deleteUser(User user);

    User getUserById(int id);
}
