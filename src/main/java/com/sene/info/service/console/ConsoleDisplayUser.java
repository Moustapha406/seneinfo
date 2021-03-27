package com.sene.info.service.console;

import com.sene.info.domain.Post;
import com.sene.info.domain.User;
import com.sene.info.repository.DataSource;
import com.sene.info.repository.PostRepository;
import com.sene.info.repository.UserRepository;
import com.sene.info.repository.jdbc.JdbcUserRepository;
import com.sene.info.repository.jdbc.MysqlDataSource;
import com.sene.info.repository.jdbc.jdbcPostRepository;
import com.sene.info.service.DisplayPost;
import com.sene.info.service.DisplayUser;

import java.util.Date;
import java.util.Scanner;

public class ConsoleDisplayUser implements DisplayUser {
    Scanner sc;
    private UserRepository userRepository;
    private DataSource dataSource;
    private DisplayPost displayPost;
    private PostRepository postRepository;
    int choix;


    public ConsoleDisplayUser() {
        sc=new Scanner(System.in);
        dataSource=new MysqlDataSource();
        userRepository=new JdbcUserRepository(dataSource);
        displayPost=new ConsoleDisplayPost();
        postRepository=new jdbcPostRepository(dataSource);
    }

    @Override
    public boolean connexion() {
        System.out.println("------IDENTIFICATION-------");
        System.out.println("\tUsername");
        String username=sc.nextLine();
        System.out.println("\tPassword");
        String password=sc.nextLine();
        User user=userRepository.getUser(username,password);
        if(user.getId() != 0){
            System.out.println("Vous etes connecter");

            menuUser(user);
            return true;
        }
        System.out.println("IDENTIFICATION FAILLED");
        return false;
    }

    @Override
    public void listPublication(User user) {
        System.out.println("----Liste de mes posts-----------");
        Post[] posts=postRepository.getByUser(user.getId());
        for (int i=0;i<posts.length;i++){
            Post post =posts[i];
            System.out.println(String.format(".%s > %s %s ",post.getId(),post.getTitre(),post.getDatePu()));
        }

    }

    @Override
    public void menuUser(User user) {
        do{

            System.out.println("-------COMPTER UTILISATEUR-------------");
            System.out.println("1 > Profile");
            System.out.println("2 > Liste de mes publications ");
            System.out.println("3 > Ajouter une publication");
            System.out.println("4 > Retour");
            menuAffichage(user);
        }while(choix != 4);

    }

    @Override
    public void profileUser(User user) {
        System.out.println("------PROFILES------");
        System.out.println("Username : "+user.getUsername()+"\nNom : "+user.getNom()+"\nPrénom : "
                +user.getPrenom()+"\nEmail : "+user.getEmail()+"\nTelephone : "+user.getTelephone());

    }

    @Override
    public Post addPost() {
        Post post=new Post();
        sc.nextLine();
        System.out.println("Donner le titre de publication");
        post.setTitre(sc.nextLine());
        System.out.println("Donner le contenu de la publication");
        post.setContenu(sc.nextLine());
        post.setDatePu(new Date());
        return post;
    }

    @Override
    public void menuAffichage(User user) {
        choix=sc.nextInt();
        switch (choix){
            case 1:
                profileUser(user);
                break;
            case 2:
                listPublication(user);
                break;
            case 3 :

                postRepository.addPost(addPost(),user.getId());
                break;
            case 4:
                displayPost.menuPricipal();
                break;
        }
    }


}
