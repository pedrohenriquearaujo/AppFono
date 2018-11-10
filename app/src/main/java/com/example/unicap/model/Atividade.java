    package com.example.unicap.model;

    import android.os.Parcel;
    import android.os.Parcelable;

    import java.io.Serializable;
    import java.util.ArrayList;
    import java.util.List;

    public class Atividade implements Serializable {


            private int id;

            private String dataCriacao;

            private Licao licao;

            private Paciente paciente;

            private List<Exercicio> exercicios = new ArrayList<>();

            public Atividade() {
                super();
            }

            public Atividade(int id, String dataCriacao, Licao licao, Paciente paciente) {
                this.id = id;
                this.dataCriacao = dataCriacao;
                this.licao = licao;
                this.paciente = paciente;
            }


        protected Atividade(Parcel in) {
            id = in.readInt();
            dataCriacao = in.readString();
        }



        public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getDataCriacao() {
                return dataCriacao;
            }

            public void setDataCriacao(String dataCriacao) {
                this.dataCriacao = dataCriacao;
            }

            public Licao getLicao() {
                return licao;
            }

            public void setLicao(Licao licao) {
                this.licao = licao;
            }

            public Paciente getPaciente() {
                return paciente;
            }

            public void setPaciente(Paciente paciente) {
                this.paciente = paciente;
            }



            public List<Exercicio> getExercicios() {
                return exercicios;
            }

            public void setExercicios(List<Exercicio> exercicios) {
                this.exercicios = exercicios;
            }

            @Override
            public int hashCode() {
                final int prime = 31;
                int result = 1;
                result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
                result = prime * result + id;
                result = prime * result + ((licao == null) ? 0 : licao.hashCode());
                result = prime * result + ((paciente == null) ? 0 : paciente.hashCode());
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
                Atividade other = (Atividade) obj;
                if (dataCriacao == null) {
                    if (other.dataCriacao != null)
                        return false;
                } else if (!dataCriacao.equals(other.dataCriacao))
                    return false;
                if (id != other.id)
                    return false;
                if (licao == null) {
                    if (other.licao != null)
                        return false;
                } else if (!licao.equals(other.licao))
                    return false;
                if (paciente == null) {
                    if (other.paciente != null)
                        return false;
                } else if (!paciente.equals(other.paciente))
                    return false;
                return true;
            }

            @Override
            public String toString() {
                return "Atividade [id=" + id + ", dataCriacao=" + dataCriacao + ", licao=" + licao + ", paciente=" + paciente
                        + "]";
            }



    }
