package model.entities;

import java.time.LocalDate;

public class Autor {

    private Integer id;
    private String nome;
    private LocalDate dataNascimento;

    public Autor(Integer id, String nome, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
