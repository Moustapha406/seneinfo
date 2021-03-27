package com.sene.info.repository;

import com.sene.info.domain.Commentary;

public interface CommentaryRepository {
    int comment(Commentary commentary,int id);
    Commentary[] getById(int id);
}
