package com.example.unicap.model;


import java.io.Serializable;

public class Paciente implements Serializable {

    private int id;

    private String nome;

    private String descricao;

    private String sexo;

    private String dataNascimento;

    public Paciente() {
        super();
    }

    public Paciente(int id, String nome, String descricao, String sexo, String dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
        result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
        result = prime * result + id;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Paciente other = (Paciente) obj;
        if (dataNascimento == null) {
            if (other.dataNascimento != null)
                return false;
        } else if (!dataNascimento.equals(other.dataNascimento))
            return false;
        if (descricao == null) {
            if (other.descricao != null)
                return false;
        } else if (!descricao.equals(other.descricao))
            return false;
        if (id != other.id)
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (sexo == null) {
            if (other.sexo != null)
                return false;
        } else if (!sexo.equals(other.sexo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Paciente [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", sexo=" + sexo
                + ", dataNascimento=" + dataNascimento ;
    }


}
