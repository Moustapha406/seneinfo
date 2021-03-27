package com.sene.info.repository.jdbc;

import com.sene.info.domain.User;
import com.sene.info.repository.DataSource;
import com.sene.info.repository.UserRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcUserRepository implements UserRepository {
    private final DataSource dataSource;

    public JdbcUserRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public User[] getAll() {

        String query="SELECT * FROM user ";
        List<User> users=new ArrayList<User>();

        try{
            Connection connection=dataSource.createConnexion();
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(query);

            while(rs.next()){
                System.out.println("user2");
                int id=rs.getInt("idUser");
                String nom=rs.getString("nom");
                String prenom=rs.getString("prenom");
                String username=rs.getString("username");
                String email =rs.getString("email");
                String password= rs.getString("passworsd");
                String telephone= rs.getString("telephone");
                String role=rs.getString("role");

                User user=new User(id,nom,prenom,username,email,password,telephone,role);

                users.add(user);
            }
            return users.toArray(new User[0]);
        }catch (SQLException ex){
            return new User[0];
        }catch (Exception e){
            System.out.println(e.fillInStackTrace());
            return new User[0];
        }

    }

    @Override
    public User getById() {
        return null;
    }

    @Override
    public User getUser(String username1, String password1) {
        String query="SELECT * FROM user WHERE username='"+username1+"' AND password='"+password1+"'";

        User user=new User();
        try{

            Connection connection=dataSource.createConnexion();
            Statement statement=connection.createStatement();

            ResultSet rs=statement.executeQuery(query);

            while(rs.next()){

                int id=rs.getInt("idUser");

                String nom=rs.getString("nom");
                String prenom=rs.getString("prenom");
                String username=rs.getString("username");
                String email =rs.getString("email");

                String password= rs.getString("password");
                String telephone= rs.getString("telephone");

                String role=rs.getString("role");

                 user=new User(id,nom,prenom,username,email,password,telephone,role);


            }
            return user;
        }catch (SQLException ex){
            return new User();
        }catch (Exception e){
            System.out.println(e.fillInStackTrace());
            return new User();
        }

    }
}
