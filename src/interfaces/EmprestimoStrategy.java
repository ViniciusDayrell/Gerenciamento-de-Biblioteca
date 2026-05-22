package interfaces;

import entities.Livro;
import entities.Usuario;

public interface EmprestimoStrategy {
    boolean podeEmprestar(Usuario usuario);

    void emprestarLivro(Usuario usuario, Livro livro);

    void devolverLivro(Usuario usuario, Livro livro);
}
