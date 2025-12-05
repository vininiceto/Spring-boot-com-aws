package model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Biblioteca {


    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public List<Livro> getLivros() {
        return livros;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public boolean cadastrarLivro(Integer id, String titulo, String autor, Boolean disponivel, LocalDate dataCadastro, LocalDate dataAtualizacao) {
        for (Livro l : livros) {
            if (id.equals(l.getId())) {
                System.out.println("❌ Já existe um livro com esse ID!");
                return false;
            }
        }

        Livro lv = new Livro(id, titulo, autor, LocalDate.now(), true, LocalDate.now());
        livros.add(lv);
        System.out.println("✅ Livro cadastrado com sucesso!");
        return true;
    }

    public boolean cadastrarAutor(Integer id, String nomeAutor, LocalDate dataNascimento) {
        for (Autor at : autores) {
            if (id.equals(at.getId())) {
                System.out.println("Já existe um autor com esse ID!");
                return false;
            }
        }
        Autor autor = new Autor(id, nomeAutor, dataNascimento);
        autores.add(autor);
        return true;
    }

    public boolean removerLivro(Integer id) {
        Iterator<Livro> it = livros.iterator();
        while (it.hasNext()) {
            Livro x = it.next();
            if (id.equals(x.getId())) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public boolean removerAutor(Integer id) {
        Iterator<Autor> it = autores.iterator();
        while (it.hasNext()) {
            Autor x = it.next();
            if (id.equals(x.getId())) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public void livroDisponivel(Integer idLivro) {
        boolean disponivel = true;
        for (Livro e : livros) {
            if (idLivro.equals(e.getId())) {
                if (!e.getDisponivel()) {
                    disponivel = false;
                    break;
                }
            }
        }
        if (disponivel) {
            System.out.println("✅ Livro disponível para empréstimo!");
        } else {
            System.out.println("❌ Livro não está disponível para empréstimo.");
        }

    }

    public boolean realizarEmprestimo(Integer id, String nomeCliente, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        for (Livro x : livros) {
            if (id.equals(x.getId()) && x.getDisponivel()) {
                emprestimos.add(new Emprestimo(id, nomeCliente, dataEmprestimo, dataDevolucao));
                x.setDisponivel(false);
                return true;
            }
        }
        System.out.println("Não foi possível realizar o empréstimo!");
        return false;
    }

    public boolean devolverEmprestimo(Integer idLivro, LocalDate dataDevolucao) {
        for (Emprestimo e : emprestimos) {
            if (idLivro.equals(e.getLivro().getId())) {
                e.getLivro().setDisponivel(true);
                e.setDataDevolucao(dataDevolucao);
                System.out.println("✅ Livro devolvido com sucesso!");
                return true;
            }
        }
        System.out.println("❌ Livro informado não encontrado!");
        return false;
    }
}


