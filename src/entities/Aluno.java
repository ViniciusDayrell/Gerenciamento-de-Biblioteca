package entities;

/*O Aluno pode emprestar apenas uma vez
 * Implementar um metodo para atualizar o atributo livrosEmprestados
 */
public class Aluno extends Usuario {
    private int livrosEmprestados;

    public Aluno(String nome) {
        super(nome);
        this.livrosEmprestados = 1;
    }

    public int getLivrosEmprestados() {
        return livrosEmprestados;
    }

}
