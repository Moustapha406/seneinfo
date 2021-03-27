package com.sene.info.repository.jdbc;

import com.sene.info.domain.Categorie;
import com.sene.info.domain.Post;
import com.sene.info.domain.User;
import com.sene.info.repository.DataSource;
import com.sene.info.repository.PostRepository;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class jdbcPostRepository implements PostRepository {
    public final DataSource dataSource;

    public jdbcPostRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Post[] getAll() {

        String query="SELECT * FROM post e,user u, categorie c WHERE e.user=u.idUser AND e.categorie=c.idCategorie";

        List<Post> posts=new ArrayList<Post>();

        try{

            Connection connection= dataSource.createConnexion();
            Statement statement =connection.createStatement();
            ResultSet rs=statement.executeQuery(query);

            while(rs.next()){

                int idPost=rs.getInt("idPost");
                String titre=rs.getString("titre");
                String texte=rs.getString("texte");
                Date datePu=rs.getDate("datePu");
                int idCategorie=rs.getInt("idCategorie");
                String libelle=rs.getString("libelle");
                int idUser=rs.getInt("idUser");
                String nom=rs.getString("nom");
                String prenom=rs.getString("prenom");
                String username=rs.getString("username");
                String email=rs.getString("email");
                String password=rs.getString("password");
                String telephone=rs.getString("telephone");
                String role=rs.getString("role");


                Categorie categorie=new Categorie(idCategorie,libelle);
                User user= new User(idUser,nom,prenom,username,email,password,telephone,role);
                Post post=new Post(idPost,titre,texte,user,categorie,datePu);

                posts.add(post);
            }

            return  posts.toArray(new Post[0]);

        }catch (SQLException ex){
            return new Post[0];
        }catch (Exception e){
            return new Post[0];
        }

    }

    @Override
    public Post getById(int id) {

        String query = "SELECT * FROM post p,user u,categorie c WHERE p.categorie=c.idCategorie AND p.user=u.idUser AND p.idPost="+id;

        try {

            Connection connection = dataSource.createConnexion();
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(query);

            Post post=new Post();

            while (rs.next()) {
                System.out.println("post2");
                int idPost = rs.getInt("idPost");
                String titre = rs.getString("titre");
                String texte = rs.getString("texte");
                Date datePu = rs.getDate("datePu");
                int idCategorie = rs.getInt("idCategorie");
                String libelle = rs.getString("libelle");
                int idUser = rs.getInt("idUser");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String telephone = rs.getString("telephone");
                String role = rs.getString("role");


                Categorie categorie = new Categorie(idCategorie, libelle);
                User user = new User(idUser, nom, prenom, username, email, password, telephone, role);
                post = new Post(idPost, titre, texte, user, categorie, datePu);


            }

            return post;

        } catch (SQLException ex) {
            return new Post();
        } catch (Exception e) {
            return new Post();
        }
    }

    @Override
    public int addPost(Post post,int id) {
        SimpleDateFormat formater=new SimpleDateFormat("yyyy-MM-dd");
        int ok;
        String query="INSERT INTO post(titre,texte,user,categorie,datePu) VALUES(?,?,?,?,?)";

        try{

            Connection connection=dataSource.createConnexion();
            PreparedStatement statement=connection.prepareStatement(query);

            statement.setString(1,post.getTitre());
            statement.setString(2,post.getContenu());
            statement.setInt(3,id);
            statement.setInt(4,1);
            statement.setDate(5, java.sql.Date.valueOf(formater.format(post.getDatePu())));
            ok=statement.executeUpdate();
            System.out.println("ok "+ok);
            if(ok >0){
                System.out.println("Vous avez ajouté une publications");
            }
            return ok;
        }catch (Exception ex){
            ex.fillInStackTrace();
        }
        return 0;
    }

    @Override
    public Post[] getByUser(int userId) {
        String query = "SELECT * FROM post p,user u,categorie c WHERE p.categorie=c.idCategorie AND p.user=u.idUser AND p.user="+userId;


        List<Post> posts=new ArrayList<Post>();

        try{

            Connection connection= dataSource.createConnexion();
            Statement statement =connection.createStatement();
            ResultSet rs=statement.executeQuery(query);

            while(rs.next()){

                int idPost=rs.getInt("idPost");
                String titre=rs.getString("titre");
                String texte=rs.getString("texte");
                Date datePu=rs.getDate("datePu");
                int idCategorie=rs.getInt("idCategorie");
                String libelle=rs.getString("libelle");
                int idUser=rs.getInt("idUser");
                String nom=rs.getString("nom");
                String prenom=rs.getString("prenom");
                String username=rs.getString("username");
                String email=rs.getString("email");
                String password=rs.getString("password");
                String telephone=rs.getString("telephone");
                String role=rs.getString("role");


                Categorie categorie=new Categorie(idCategorie,libelle);
                User user= new User(idUser,nom,prenom,username,email,password,telephone,role);
                Post post=new Post(idPost,titre,texte,user,categorie,datePu);

                posts.add(post);
            }

            return  posts.toArray(new Post[0]);

        }catch (SQLException ex){
            return new Post[0];
        }catch (Exception e){
            return new Post[0];
        }

    }
}
