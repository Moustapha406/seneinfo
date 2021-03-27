package com.sene.info.service;

import com.sene.info.domain.Commentary;

public interface DisplayCommentary {
    void menuComment(int id);
    void menuAffiche(int id);
    Commentary addComment();
    void listComment(int id);
}
