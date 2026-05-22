package entities;

import interfaces.EmprestimoStrategy;

public class EmprestimoAlunoStrategy implements EmprestimoStrategy {

    @Override
    public boolean podeEmprestar(Usuario usuario) {
        Aluno aluno = (Aluno) usuario;
        return aluno.getLivrosEmprestados() == null;
    }

    @Override
    public void emprestarLivro(Usuario usuario, Livro livro) {
        Aluno aluno = (Aluno) usuario;
        aluno.setLivrosEmprestados(livro);
        livro.emprestar();
    }

    @Override
    public void devolverLivro(Usuario usuario, Livro livro) {
        Aluno aluno = (Aluno) usuario;
        aluno.setLivrosEmprestados(null);
        livro.devolver();

    }

}
