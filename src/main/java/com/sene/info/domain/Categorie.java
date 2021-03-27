package com.sene.info.domain;

public class Categorie {
    private int id;
    private String libelle;

    public Categorie(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public Categorie() {
        this.id=0;
        this.libelle="";
    }

    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
