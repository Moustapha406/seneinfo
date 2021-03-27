package com.sene.info.service.console;

import com.sene.info.domain.Commentary;
import com.sene.info.domain.Post;
import com.sene.info.domain.User;
import com.sene.info.repository.CommentaryRepository;
import com.sene.info.repository.DataSource;
import com.sene.info.repository.PostRepository;
import com.sene.info.repository.jdbc.JdbcCommentaryRepository;
import com.sene.info.repository.jdbc.MysqlDataSource;
import com.sene.info.repository.jdbc.jdbcPostRepository;
import com.sene.info.service.DisplayCommentary;
import com.sene.info.service.DisplayPost;

import java.util.Date;
import java.util.Scanner;

public class ConsoleDisplayPost implements DisplayPost {
    private Scanner sc;
    private PostRepository postRepository;
    private DataSource dataSource;
    private DisplayCommentary displayCommentary;

    public ConsoleDisplayPost() {
        this.dataSource=new MysqlDataSource();
        this.postRepository = new jdbcPostRepository(dataSource);
        this.sc=new Scanner(System.in);
        this.displayCommentary=new ConsoleDisplayCommentary();
    }


    @Override
    public void menuPricipal() {
        System.out.println("------------BIENVENU DANS MON SITE---------------");
        System.out.println("1 les publication");
        System.out.println("2 se connecter");
    }

    @Override
    public void listPublication(Post[] posts) {

        for(int i=0; i< posts.length;i++){
            Post post =posts[i];
            System.out.println(String.format(".%s > %s %s ",post.getId(),post.getTitre(),post.getDatePu()));

        }

    }

    @Override
    public void affciherPost(int id) {
        Post post=postRepository.getById(id);
        System.out.println(String.format(">> %s du date :%s ",post.getContenu(),post.getDatePu()));
        System.out.println("-------Les commentaire de cet article------");
        displayCommentary.listComment(id);
        System.out.println("---------Faites un commentaire------");

        displayCommentary.menuComment(id);

    }

    @Override
    public Post postByUser(User user) {

        return null;
    }







}
