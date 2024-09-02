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

    public Usuario buscarUsuario(String nome) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nome)) {
                return usuario;
            }
        }
        return null;
    }

    public Livro buscarLivro(String nome) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equals(nome)) {
                return livro;
            }
        }
        return null;
    }

    public void realizarEmprestimo(Livro livro, Usuario usuario) {
        if (!livro.isDisponivel()) {
            System.out.println("O livro ja esta emprestado!");
            return;
        }

        if (usuario instanceof Aluno) {
            Aluno aluno = (Aluno) usuario;
            if (aluno.getLivrosEmprestados() != null) {
                System.out.println("O aluno ja possui um livro emprestado!");
                return;
            }
            aluno.setLivrosEmprestados(livro);
        } else if (usuario instanceof Professor) {
            Professor professor = (Professor) usuario;
            if (professor.getLivros().size() >= 3) {
                System.out.println("O professor chegou ao limite de livros emprestados!");
                return;
            }
            professor.setLivros(livro);
        }
        livro.emprestar();
        System.out.println("O livro " + livro.getTitulo() + " foi emprestado!");

    }

    // realizarDevolucao()
    public void realizarDevolucao(Livro livro, Usuario usuario) {
        if (livro.isDisponivel()) {
            System.out.println("O livro ja esta na biblioteca!");
            return;
        }

        if (usuario instanceof Aluno) {
            Aluno aluno = (Aluno) usuario;
            if (aluno.getLivrosEmprestados() == null) {
                System.out.println("O aluno nao possui livros emprestados!");
                return;
            }
            aluno.setLivrosEmprestados(null);
        } else if (usuario instanceof Professor) {
            Professor professor = (Professor) usuario;
            if (professor.getLivros().size() == 0) {
                System.out.println("O professor nao tem livros emprestados!");
                return;
            }
            professor.removeLivroEmprestado(livro);
        }
        livro.devolver();
        System.out.println("O livro " + livro.getTitulo() + " foi devolvido!");
    }

    public void listarLivrosDisponiveis() {
        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                System.out.println(livro.getTitulo());
                System.out.println();
            }
        }
    }

    public void listarLivrosEmprestados() {
        for (Livro livro : livros) {
            if (!livro.isDisponivel()) {
                System.out.println(livro.getTitulo());
                System.out.println();
            }
        }
    }
}
