package application;

import model.entities.Autor;
import model.entities.Biblioteca;
import model.entities.Livro;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("-----Seja Bem Vindo a Biblioteca-----");

        Biblioteca biblioteca = new Biblioteca();
        DateTimeFormatter dtm = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (true) {
            System.out.println();
            System.out.println("Opções de atendimento: \n" +
                    "1-Verificar lista de livros\n" +
                    "2-Cadastrar Autor\n" +
                    "3-Cadastrar Livro\n" +
                    "4-Remover Livro\n" +
                    "5-Remover autor\n" +
                    "6-Verificar se o livro está disponivel para emprestimo\n" +
                    "7-Realizar emprestimo\n" +
                    "8-Devolver Livro\n");
            Integer option = sc.nextInt();

            switch (option) {
                case 1:
                    biblioteca.listarLivros();
                    break;

                case 2:
                    System.out.println("Informe o nome do Autor: ");
                    sc.nextLine();
                    String nomeAutor = sc.nextLine();
                    System.out.println("Informe a data de nascimento do autor: ");
                    LocalDate dataNascimento = LocalDate.parse(sc.nextLine(), dtm);
                    biblioteca.cadastrarAutor(nomeAutor, dataNascimento);
                    break;
                case 3:
                    System.out.println("Informe o titulo do Livro: ");
                    sc.nextLine();
                    String titulo = sc.nextLine();
                    System.out.println("Informe o autor do livro: ");
                    nomeAutor = sc.nextLine();
                    System.out.println("O livro já se encontra disponivel? (s/n)");
                    char disponivel = sc.nextLine().charAt(0);
                    if (disponivel == 's') {
                        biblioteca.cadastrarLivro(titulo, nomeAutor, true, LocalDate.now(), LocalDate.now());
                        break;
                    } else if (disponivel == 'n') {
                        biblioteca.cadastrarLivro(titulo, nomeAutor, false, LocalDate.now(), LocalDate.now());
                        break;
                    } else {
                        System.out.println("Opção inválida!");
                        break;
                    }
                case 4:
                    System.out.println("Informe o ID do livro que deseja remover: ");
                    Integer idLivro = sc.nextInt();
                    biblioteca.removerLivro(idLivro);
                    break;

                case 5:
                    System.out.println("Informe o ID do autor que deseja remover: ");
                    Integer idAutor = sc.nextInt();
                    biblioteca.removerAutor(idAutor);
                    break;

                case 6:
                    System.out.println("Informe o ID do livro que deseja verificar para emprestimo: ");
                    Integer idLivroEmp = sc.nextInt();
                    biblioteca.livroDisponivel(idLivroEmp);
                    break;

                case 7:
                    System.out.println("Informe o nome do cliente");
                    sc.nextLine();
                    String nomeCliente = sc.nextLine();
                    System.out.println("Informe a data de devolução do emprestimo: ");
                    LocalDate date = LocalDate.parse(sc.nextLine(), dtm);
                    System.out.println("Informe o id do livro que deseja realizar o emprestimo: ");
                    Integer id = sc.nextInt();

                    biblioteca.realizarEmprestimo(id, nomeCliente, LocalDate.now(), date);
                    break;
                case 8:
                    System.out.println("Informe o ID do livro que está sendo devolvido: ");
                    idLivro = sc.nextInt();
                    sc.nextLine(); // consome o ENTER

                    System.out.println("Informe a data que está sendo devolvido (dd/MM/yyyy): ");
                    String dataStr = sc.nextLine();
                    LocalDate dataDevolucao = LocalDate.parse(dataStr, dtm);

                    biblioteca.devolverEmprestimo(idLivro, dataDevolucao);
                    break;


            }


        }


    }
}