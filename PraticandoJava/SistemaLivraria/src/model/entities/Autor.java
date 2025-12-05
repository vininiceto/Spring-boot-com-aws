package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Autor {
    private static Integer currentId = 1;

    private final DateTimeFormatter dtm = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    private Integer id;
    private String nome;
    private LocalDate dataNascimento;

    public Autor(String nome, LocalDate dataNascimento) {
        this.id = currentId++;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
    public Autor(){};

    public Integer getId() {
        return id;
    }

    public String getDataNascimento() {
        return dataNascimento != null ? dataNascimento.format(dtm) : "";

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
