package com.sene.info.service.console;

import com.sene.info.domain.Commentary;
import com.sene.info.repository.CommentaryRepository;
import com.sene.info.repository.DataSource;
import com.sene.info.repository.jdbc.JdbcCommentaryRepository;
import com.sene.info.repository.jdbc.MysqlDataSource;
import com.sene.info.service.DisplayCommentary;
import com.sene.info.service.DisplayPost;

import java.util.Date;
import java.util.Scanner;

public class ConsoleDisplayCommentary implements DisplayCommentary {
    private DataSource dataSource;
    private Scanner sc;
    private CommentaryRepository commentaryRepository;


    public ConsoleDisplayCommentary() {
        this.dataSource=new MysqlDataSource();
        this.sc=new Scanner(System.in);
        this.commentaryRepository=new JdbcCommentaryRepository(dataSource);

    }

    @Override
    public void menuComment(int id) {
        System.out.println("1 commenter cet article");
        menuAffiche(id);
    }

    @Override
    public void menuAffiche(int id) {
        int choix=sc.nextInt();
        switch (choix){
            case 1:
                commentaryRepository.comment(addComment(),id);
                break;

            default:

        }
    }

    @Override
    public Commentary addComment() {
        Commentary commentary=new Commentary();
        sc.nextLine();
        System.out.println("Libellé de votre commentaire");
        commentary.setLibelle(sc.nextLine());
        commentary.setDate(new Date());

        return commentary;
    }

    @Override
    public void listComment(int id) {
        Commentary[] commentary=commentaryRepository.getById(id);
        for (int i=0; i<commentary.length;i++){
            System.out.println(commentary[i].getId()+"> \t "+commentary[i].getLibelle()+"\t"+commentary[i].getDate());
        }
    }


}
