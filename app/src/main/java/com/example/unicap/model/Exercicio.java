package com.example.unicap.model;


import java.io.Serializable;

public class Exercicio implements Serializable {


    private int id;

    private byte[] audio;

    private String status;

    private String dataHoraMarcada;

    private String dataHoraRealizado;

    private Atividade atividade;




    public Exercicio() {
        super();
        // TODO Auto-generated constructor stub
    }



    public Exercicio(int id, byte[] audio, String status, String dataHoraMarcada, String dataHoraRealizado, Atividade atividade) {
        this.id = id;
        this.audio = audio;
        this.status = status;
        this.dataHoraMarcada = dataHoraMarcada;
        this.dataHoraRealizado = dataHoraRealizado;
        this.atividade = atividade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getAudio() {
        return audio;
    }

    public void setAudio(byte[] audio) {
        this.audio = audio;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDataHoraMarcada() {
        return dataHoraMarcada;
    }

    public void setDataHoraMarcada(String dataHoraMarcada) {
        this.dataHoraMarcada = dataHoraMarcada;
    }

    public String getDataHoraRealizado() {
        return dataHoraRealizado;
    }

    public void setDataHoraRealizado(String dataHoraRealizado) {
        this.dataHoraRealizado = dataHoraRealizado;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }
}
