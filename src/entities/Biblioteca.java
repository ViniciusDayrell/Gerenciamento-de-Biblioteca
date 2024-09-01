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

    public void realizarEmprestimo(){
        livros.
    }
}
