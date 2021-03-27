package com.sene.info.controller;

import com.sene.info.repository.DataSource;
import com.sene.info.repository.PostRepository;
import com.sene.info.repository.jdbc.MysqlDataSource;
import com.sene.info.repository.jdbc.jdbcPostRepository;
import com.sene.info.service.DisplayPost;
import com.sene.info.service.console.ConsoleDisplayPost;
import com.sene.info.service.console.ScannerMenuPost;

public class ClientController {
    private final DisplayPost displayPost;
    private final ScannerMenuPost scannerMenuPost;


    public ClientController() {
        this.displayPost=new ConsoleDisplayPost();
        DataSource dataSource=new MysqlDataSource();
        PostRepository postRepository=new jdbcPostRepository(dataSource);
        this.scannerMenuPost=new ScannerMenuPost(postRepository,displayPost, dataSource);
    }

    public void proccess(){
        displayPost.menuPricipal();
        scannerMenuPost.menuPricipal();
    }
}
