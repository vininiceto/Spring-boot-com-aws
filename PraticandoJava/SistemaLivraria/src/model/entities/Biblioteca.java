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

    public boolean cadastrarLivro(String titulo, String autor, Boolean disponivel, LocalDate dataCadastro, LocalDate dataAtualizacao) {
        for (Livro l : livros) {
            if (titulo.equals(l.getTitulo()) && autor.equals(l.getAutor())) {
                System.out.println("❌ O livro informado já se encontra cadastrado!");
                return false;
            }
        }

        Livro lv = new Livro(titulo,autor, LocalDate.now(), true, LocalDate.now());
        livros.add(lv);
        System.out.println("✅ Livro cadastrado com sucesso!");
        return true;
    }

    public boolean cadastrarAutor(String nomeAutor, LocalDate dataNascimento) {
        for (Autor at : autores) {
            if (nomeAutor.equals(at.getNome()) && dataNascimento.equals(at.getDataNascimento())) {
                System.out.println("O autor informado já se encontra cadastrado!");
                return false;
            }
        }
        Autor autor = new Autor(nomeAutor, dataNascimento);
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
        Livro livroEncontrado = null;
        for (Livro e : livros) {
            if (idLivro.equals(e.getId())) {
                livroEncontrado = e;
                if (!e.getDisponivel()) {
                    disponivel = false;
                    break;
                }
            }
        }
        if(livroEncontrado != null) {
                if (disponivel) {
                    System.out.printf("✅ O Livro '%s' está disponível para empréstimo!%n", livroEncontrado.getTitulo());
                } else {
                    System.out.printf("❌ O Livro '%s' não está disponível para empréstimo.%n", livroEncontrado.getTitulo());
                }
            } else {
                System.out.println("⚠️ Livro informado não encontrado!");
            }

        }


    public boolean realizarEmprestimo(Integer id, String nomeCliente, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        for (Livro x : livros) {
            if (id.equals(x.getId()) && x.getDisponivel()) {
                Emprestimo e = new Emprestimo(nomeCliente, dataEmprestimo, dataDevolucao);

                emprestimos.add(e);
                x.setDisponivel(false);
                return true;
            }
        }
        System.out.println("Não foi possível realizar o empréstimo!");
        return false;
    }

    public boolean devolverEmprestimo(Integer idLivro, LocalDate dataDevolucao) {
        for (Emprestimo e : emprestimos) {
            for(Livro l : livros){
            if (idLivro.equals(l.getId())) {
                l.setDisponivel(true);}
                e.setDataDevolucao(dataDevolucao);
                System.out.println("✅ Livro devolvido com sucesso!");
                return true;
            }
        }
        System.out.println("❌ Livro informado não encontrado!");
        return false;
    }

    public void listarLivros() {
        for (Livro x : livros) {
            System.out.println(x.getId()+ "- " + "Titulo: " + x.getTitulo() + "| Autor:" + x.getAutor() + "| Livro Disponivel: " + x.getDisponivel());
        }

    }


}


