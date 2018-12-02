package com.dao;

import com.entity.User;

public interface UserDAO {

    User findByUserName(String username);

}
