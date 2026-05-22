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
        if (usuario instanceof Aluno) {
            usuario.setStrategy(new EmprestimoAlunoStrategy());
        } else if (usuario instanceof Professor) {
            usuario.setStrategy(new EmprestimoProfessorStrategy());
        }

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

        if (!usuario.getStrategy().podeEmprestar(usuario)) {
            System.out.println("Limite atingido!");
            return;
        }

        usuario.getStrategy().emprestarLivro(usuario, livro);

        System.out.println("O livro " + livro.getTitulo() + " foi emprestado!");
        System.out.println();
    }

    // realizarDevolucao()
    public void realizarDevolucao(Livro livro, Usuario usuario) {
        if (livro.isDisponivel()) {
            System.out.println("O livro ja esta na biblioteca!");
            return;
        }

        usuario.getStrategy().devolverLivro(usuario, livro);

        System.out.println("O livro " + livro.getTitulo() + " foi devolvido!");
    }

    public void listarLivrosDisponiveis() {
        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                System.out.println(livro.toString());
                System.out.println();
            } else {
                System.out.println("Nenhum livro disponivel!");
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
