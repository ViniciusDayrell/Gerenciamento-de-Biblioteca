package entities;

import java.util.ArrayList;
import java.util.List;

/*
 * Metodos:
 * adicionarLivro(), regitrarUsuario(), realizarEmprestimo(), 
 * realizarDevolucao(), listarLivrosDisponiveis(), listarLivrosEmprestados(),
 */
public class Biblioteca {
    private List<Livro> livros;
    private List<Usuario> usuarios;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public Biblioteca(List<Livro> livros, List<Usuario> usuarios) {
        this.livros = livros;
        this.usuarios = usuarios;
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("O livro " + livro.getTitulo() + " foi adicionado!");
    }

    public void regitrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuario " + usuario.getNome() + " cadastrado!");
    }

    // Criacao dos metodos relizarEmprestimo(), realizarDevolucao(),
    // listarLivrosDisponiveis(), listarLivrosEmprestados()
    public void realizarEmprestimo(Livro livro) {
        livro.emprestar();
        System.out.println("O livro foi emprestado com sucesso!");
    }

    public void realizarDevolucao(Livro livro) {
        livro.devolver();
        System.out.println("Livro devolvido com sucesso!");
    }

    public void listarLivrosDisponiveis() {
        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                System.out.println(livro.getTitulo());
            }
        }
    }

    public void listarLivrosEmprestados() {
        for (Livro livro : livros) {
            if (!livro.isDisponivel()) {
                System.out.println(livro.getTitulo());
            }
        }
    }
    // Metodo para buscar livro escolhido pelo usuario
}
