package com.sene.info.repository;

import com.sene.info.domain.User;

public interface UserRepository {
    User[] getAll();
    User getById();
    User getUser(String username,String password);
}
