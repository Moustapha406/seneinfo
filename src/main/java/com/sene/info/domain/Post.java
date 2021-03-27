package com.sene.info.domain;

import java.util.Date;

public class Post {
    private int id;
    private String titre;
    private String contenu;
    private Date datePu;
    private User user;
    private Categorie categorie;

    public Post(int id, String titre, String contenu, User user, Categorie categorie, Date datePu) {
        this.id = id;
        this.titre = titre;
        this.contenu = contenu;
        this.user = user;
        this.categorie = categorie;
        this.datePu = datePu;
    }

    public Post() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDatePu() {
        return datePu;
    }

    public void setDatePu(Date datePu) {
        this.datePu = datePu;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
