package entities;

public class Professor extends Usuario {
    private int livrosEmprestados;

    public Professor(String nome) {
        super(nome);
        livrosEmprestados = 3;
    }

    public int getLivrosEmprestados() {
        return livrosEmprestados;
    }
}
