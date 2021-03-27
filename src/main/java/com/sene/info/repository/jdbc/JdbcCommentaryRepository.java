package com.sene.info.repository.jdbc;

import com.sene.info.domain.Commentary;
import com.sene.info.domain.Post;
import com.sene.info.repository.CommentaryRepository;
import com.sene.info.repository.DataSource;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class JdbcCommentaryRepository implements CommentaryRepository {
    private DataSource dataSource;

    public JdbcCommentaryRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int comment(Commentary commentary,int id) {
        int ok;
        SimpleDateFormat formater=new SimpleDateFormat("yyyy-MM-dd");

        String query="INSERT INTO commentary(libelle,date,post) VALUES (?,?,?)";
        try{
            Connection connection=dataSource.createConnexion();
            PreparedStatement statement=connection.prepareStatement(query);

            statement.setString(1,commentary.getLibelle());
            statement.setDate(2,java.sql.Date.valueOf(formater.format(commentary.getDate())) );
            statement.setInt(3,id);
            ok= statement.executeUpdate();
            if(ok>0){
                System.out.println("Vous avez commenter cet article");
            }
            return ok;

        }catch (Exception e){
            e.fillInStackTrace();
        }
        return 0;
    }

    @Override
    public Commentary[] getById(int id) {

        String query="SELECT * FROM commentary WHERE post="+id;

        List<Commentary> commentaries=new ArrayList<Commentary>();

        try{
            Connection connection=dataSource.createConnexion();
            Statement statement =connection.createStatement();
            ResultSet rs=statement.executeQuery(query);


            while(rs.next()){
                System.out.println("rentrer");
                System.out.println("rs "+rs.next());
                int idCommentary=rs.getInt("idCommentary");
                System.out.println("list 2");
                String libelle=rs.getString("libelle");
                System.out.println("list 3");
                Date date=rs.getDate("date");
                System.out.println("list 4");
                Commentary commentary=new Commentary(idCommentary,libelle,date);

                commentaries.add(commentary);
            }
            System.out.println("sotrie");
            return commentaries.toArray(new Commentary[0]);

        }catch (SQLException ex){
            return new Commentary[0];
        }catch (Exception e){
            return new Commentary[0];
        }


    }
}
