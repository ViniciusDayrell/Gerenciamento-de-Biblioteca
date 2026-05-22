package entities;

import interfaces.EmprestimoStrategy;

public class EmprestimoProfessorStrategy implements EmprestimoStrategy {

    @Override
    public boolean podeEmprestar(Usuario usuario) {
        Professor professor = (Professor) usuario;
        return professor.getLivros().size() < 3;
    }

    @Override
    public void emprestarLivro(Usuario usuario, Livro livro) {
        Professor professor = (Professor) usuario;
        professor.setLivros(livro);
        livro.emprestar();
    }

    @Override
    public void devolverLivro(Usuario usuario, Livro livro) {
        Professor professor = (Professor) usuario;
        professor.removeLivroEmprestado(livro);
        livro.devolver();
    }
}
