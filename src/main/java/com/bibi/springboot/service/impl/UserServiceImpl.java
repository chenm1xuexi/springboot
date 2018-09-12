package com.bibi.springboot.service.impl;

import com.bibi.springboot.dao.UserDAO;
import com.bibi.springboot.model.User;
import com.bibi.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User getById(Long userId) {
        return userDAO.getById(userId);
    }

    @Override
    public User create(User user) {
        return userDAO.create(user);
    }
}
