package entities;

import interfaces.EmprestimoStrategy;

public class Usuario {
    private String nome;
    private EmprestimoStrategy strategy;

    public EmprestimoStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(EmprestimoStrategy strategy) {
        this.strategy = strategy;
    }

    public Usuario(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}
