package com.bibi.springboot.dao.impl;

import com.bibi.springboot.common.MybatisDAO;
import com.bibi.springboot.dao.UserDAO;
import com.bibi.springboot.model.User;
import org.springframework.stereotype.Repository;

@Repository(value = "userDAO")
public class UserDAOImpl extends MybatisDAO<User, Long> implements UserDAO {
}
