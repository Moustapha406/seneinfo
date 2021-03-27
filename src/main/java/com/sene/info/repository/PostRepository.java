package com.sene.info.repository;

import com.sene.info.domain.Post;

public interface PostRepository {
    Post[] getAll();
    Post getById(int id);
    int addPost(Post post,int id);
    Post[] getByUser(int userId);
}
