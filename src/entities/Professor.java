package entities;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Usuario {
    private List<Livro> livros;

    public Professor(String nome, List<Livro> livros) {
        super(nome);
        this.livros = livros;
    }

    public Professor(String nome) {
        super(nome);
        this.livros = new ArrayList<>();
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
