package model.entities;

import java.time.LocalDate;

public class Livro {

    private Integer id;
    private String titulo;
    private String autor;
    private Boolean disponivel;
    private LocalDate dataCadastro;
    private LocalDate dataAtualizacao;

    public Livro(Integer id, String titulo, String autor, LocalDate dataCadastro, Boolean disponivel, LocalDate dataAtualizacao) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.dataCadastro = dataCadastro;
        this.disponivel = disponivel;
        this.dataAtualizacao = dataAtualizacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDate dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
