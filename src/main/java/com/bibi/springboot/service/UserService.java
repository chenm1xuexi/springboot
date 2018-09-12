package com.bibi.springboot.service;

import com.bibi.springboot.model.User;

public interface UserService {

    User getById(Long userId);

    User create(User user);

}
