package model.entities;

import java.util.Objects;

public class Candidato {

    private String nome;
    private Integer qntVotos;


    public Candidato(){};

    public Candidato(String nome, Integer qntVotos){
        this.nome = nome;
        this.qntVotos = qntVotos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQntVotos() {
        return qntVotos;
    }

    public void setQntVotos(Integer qntVotos) {
        this.qntVotos = qntVotos;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Candidato candidato = (Candidato) o;
        return Objects.equals(nome, candidato.nome) && Objects.equals(qntVotos, candidato.qntVotos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, qntVotos);
    }


}


