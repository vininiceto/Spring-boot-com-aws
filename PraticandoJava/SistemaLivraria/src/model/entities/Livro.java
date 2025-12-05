package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Livro {

    private static Integer currentId = 1;

    private Integer id;
    private String titulo;
    private String autor;
    private Boolean disponivel;
    private LocalDate dataCadastro;
    private LocalDate dataAtualizacao;

    private Autor at = new Autor();

    private final DateTimeFormatter dtm = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Livro( String titulo, String autor, LocalDate dataCadastro, Boolean disponivel, LocalDate dataAtualizacao) {
        this.id = currentId++;
        this.titulo = titulo;
        this.autor = autor;
        this.dataCadastro = dataCadastro;
        this.disponivel = disponivel;
        this.dataAtualizacao = dataAtualizacao;
    }

    public Integer getId() {
        return id;
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

    public String getDataCadastro() {
        return dataCadastro != null ? dataCadastro.format(dtm) : "";
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getDataAtualizacao() {
        return dataAtualizacao != null ? dataAtualizacao.format(dtm) : "";
    }

    public void setDataAtualizacao(LocalDate dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
