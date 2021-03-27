package com.sene.info.service.console;

import com.sene.info.domain.Post;
import com.sene.info.domain.User;
import com.sene.info.repository.DataSource;
import com.sene.info.repository.PostRepository;
import com.sene.info.repository.UserRepository;
import com.sene.info.repository.jdbc.JdbcUserRepository;
import com.sene.info.service.DisplayPost;
import com.sene.info.service.DisplayUser;
import com.sene.info.service.MenuPost;

import java.util.Scanner;

public class ScannerMenuPost implements MenuPost {
    private  final Scanner sc;
    private final PostRepository postRepository;
    private final DisplayPost displayPost;
    private final UserRepository userRepository;
    private final DataSource dataSource;
    private final DisplayUser displayUser;

    public ScannerMenuPost(PostRepository postRepository, DisplayPost displayPost, DataSource dataSource) {
        this.displayPost = displayPost;
        this.dataSource = dataSource;
        this.sc = new Scanner(System.in);
        this.postRepository = postRepository;
        displayUser = new ConsoleDisplayUser();
        this.userRepository=new JdbcUserRepository(this.dataSource);
    }

    @Override
    public void menuPricipal() {

        Post[] posts= postRepository.getAll();

        int choix=sc.nextInt();
        switch (choix){
            case 1:
                displayPost.listPublication(posts);
                System.out.println("----------lire la suite------------");
                System.out.println("Tapper \"0\" pour retouner ");
                int id=sc.nextInt();

                if(id != 0){
                    displayPost.affciherPost(id);
                }

                break;
            case 2:
                displayUser.connexion();
                break;
            case 3:



        }
    }
}
