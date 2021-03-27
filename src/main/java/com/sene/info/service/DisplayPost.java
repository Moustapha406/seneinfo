package com.sene.info.service;

import com.sene.info.domain.Commentary;
import com.sene.info.domain.Post;
import com.sene.info.domain.User;

public interface DisplayPost {
    void menuPricipal();
    void listPublication(Post[] posts);
    void affciherPost(int id);
    Post postByUser(User user);

}
