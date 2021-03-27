package com.sene.info.service;

import com.sene.info.domain.Post;
import com.sene.info.domain.User;

public interface DisplayUser {
    boolean connexion();
    void listPublication(User user);
    void menuAffichage(User user);
    void menuUser(User user);
    void profileUser(User user);
    Post addPost();
}
