package application;

import java.util.Scanner;

import entities.Aluno;
import entities.Biblioteca;
import entities.Livro;
import entities.Professor;
import entities.Usuario;

/*
 * O sistema deve incluir classes Biblioteca, Livro, Usuario, Professor e Aluno
 * Classe professor e Aluno herda da classe Usuario
 * Professor pode emprestar ate 3 livros
 * Aluno pode emprestar 1 livro
 * O sistema deve conter um menu que permita: Adicionar livros, Registrar usuario,
 * realizar emprestimos e devolucoes e listar livros disponiveis e emprestados
 */
public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        int opcao;

        do {
            System.out.println("-------MENU-------");
            System.out.println("1 - Adicionar livros");
            System.out.println("2 - Registrar usuário");
            System.out.println("3 - Realizar emprestimos");
            System.out.println("4 - Realizar devolucoes");
            System.out.println("5 - Listar livros");
            System.out.println("6 - Sair");
            System.out.printf("Escolha uma opcao: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Informe os dados do livro");
                    System.out.printf("Titulo: ");
                    String titulo = sc.nextLine();
                    System.out.printf("Autor: ");
                    String autor = sc.nextLine();
                    System.out.printf("Ano de publicacao: ");
                    int ano = sc.nextInt();
                    Livro livro = new Livro(titulo, autor, ano);
                    biblioteca.adicionarLivro(livro);

                    break;

                case 2:
                    System.out.println("------Cadastro de Usuario------");
                    System.out.println("1 - Cadastrar aluno");
                    System.out.println("2 - Cadastrar professor");
                    System.out.printf("Escolha uma opcao: ");
                    int tipo = sc.nextInt();
                    sc.nextLine();
                    switch (tipo) {
                        case 1:
                            System.out.println("------Cadastro de Aluno------");
                            System.out.printf("Nome: ");
                            String nome = sc.nextLine();
                            Aluno aluno = new Aluno(nome);
                            biblioteca.regitrarUsuario(aluno);
                            break;

                        case 2:
                            System.out.println("------Cadastro de Professor------");
                            System.out.printf("Nome:");
                            String nomeProf = sc.nextLine();
                            Professor professor = new Professor(nomeProf);
                            biblioteca.regitrarUsuario(professor);
                            break;

                        default:
                            System.out.println("Opcao invalida! Retornando ao menu principal.");
                            break;
                    }
                    break;

                case 3:
                    System.out.println("------Emprestimo------");
                    System.out.printf("Usuario: ");
                    String nomeUsu1 = sc.nextLine();
                    Usuario usuario = biblioteca.buscarUsuario(nomeUsu1);
                    if (usuario == null) {
                        System.out.println("Usuario inxistente!");
                        break;
                    }
                    System.out.printf("Titulo: ");
                    String tituloLivroEmprestado = sc.nextLine();
                    Livro livroEmprestado = biblioteca.buscarLivro(tituloLivroEmprestado);
                    if (livroEmprestado == null) {
                        System.out.println("Livro nao cadastrado!");
                        break;
                    }
                    biblioteca.realizarEmprestimo(livroEmprestado, usuario);
                    break;

                case 4:
                    System.out.println("------Devolucao------");
                    System.out.printf("Usuario: ");
                    String nomeUsu2 = sc.nextLine();
                    Usuario usuarioDev = biblioteca.buscarUsuario(nomeUsu2);
                    if (usuarioDev == null) {
                        System.out.println("Usuario inxistente!");
                        break;
                    }
                    System.out.printf("Titulo: ");
                    String tituloLivroDevolvido = sc.nextLine();
                    Livro livroDevolvido = biblioteca.buscarLivro(tituloLivroDevolvido);
                    if (livroDevolvido == null) {
                        System.out.println("Livro nao cadastrado!");
                        break;
                    }
                    biblioteca.realizarDevolucao(livroDevolvido, usuarioDev);
                    break;

                case 5:
                    // Listar livros. Fazer um menu de opcoes para listar livros disponiveis e
                    // livros emprestados
                    System.out.println("------Listagem------");
                    System.out.println("1 - Listar livros disponiveis");
                    System.err.println("2 - Listar livros emprestados");
                    System.out.printf("Escolha uma opcao: ");
                    int lista = sc.nextInt();
                    switch (lista) {
                        case 1:
                            System.out.println("------Livros disponiveis------");
                            biblioteca.listarLivrosDisponiveis();
                            break;

                        case 2:
                            System.out.println("------Livros emprestados------");
                            biblioteca.listarLivrosEmprestados();
                            break;

                        default:
                            System.out.println("Opcao invalida! Retornando ao menu principal.");
                            break;
                    }

                    break;
            }
        } while (opcao != 6);

        sc.close();
    }
}
