package com.sene.info.domain;

import java.util.Date;

public class Commentary {
    private int id;
    private String libelle;
    private Date date;
    private Post post;

    public Commentary() {
    }

    public Commentary(int id, String libelle,Date date) {
        this.id = id;
        this.libelle = libelle;
        this.date=date;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
