package com.example.unicap.model;

public enum Status {


    NAO_REALIZADO("Não Realizado"),
    NAO_AVALIADO("Não Avaliado"),
    VOCE_PODE_MELHORAR("Você Pode Melhorar"),
    APROVADO("Aprovado");

    private final String descricao;

    private Status(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }



}
