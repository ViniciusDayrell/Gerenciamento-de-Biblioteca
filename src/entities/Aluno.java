package entities;

/*O Aluno pode emprestar apenas uma vez
 * Implementar um metodo para atualizar o atributo livrosEmprestados
 */
public class Aluno extends Usuario {
    private Livro livro;

    public Aluno(String nome) {
        super(nome);
    }

    public Livro getLivrosEmprestados() {
        return livro;
    }

    public void setLivrosEmprestados(Livro livro) {
        this.livro = livro;
    }

}
