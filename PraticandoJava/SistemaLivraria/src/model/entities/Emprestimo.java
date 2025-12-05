package model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Emprestimo {

    private static Integer currentId = 1;

    private Integer id;
    private String nomeCliente;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;



    public Emprestimo(String nomeCliente, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        this.id = currentId++;
        this.nomeCliente = nomeCliente;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public Integer getId() {
        return id;
    }



    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}
