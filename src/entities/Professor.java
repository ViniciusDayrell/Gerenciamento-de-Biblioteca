package entities;

import java.util.List;

public class Professor extends Usuario {
    private List<Livro> livros;

    public Professor(String nome) {
        super(nome);
    }

    public void setLivros(Livro livro) {
        livros.add(livro);
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void removeLivroEmprestado(Livro livro) {
        livros.remove(livro);
    }

}
