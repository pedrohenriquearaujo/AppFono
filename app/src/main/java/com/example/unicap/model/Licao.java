package com.example.unicap.model;


import java.io.Serializable;

public class Licao implements Serializable {

    private int id;

    private String nome;

    private String descricao;

    private String video;

    public Licao() {
    }

    public Licao(int id, String nome, String descricao, String video) {
        super();
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.video = video;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}
