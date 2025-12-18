package biblioteca.service;

import biblioteca.entity.Biblioteca;
import biblioteca.entity.Livro;

import java.util.UUID;

public class BibliotecaService {
    private final Biblioteca biblioteca = Biblioteca.getInstancia();


    public void adicionarLivro(Livro livro) {
        biblioteca.adicionarLivro(livro);
    }

    public void removerLivro(UUID id) {
        biblioteca.removerLivro(Livro.builder().isbn(id).build());
    }

    public void listarLivros() {
        System.out.println(biblioteca.getLivros().toString());
    }

    public void listarAutores() {
    }

    public void listarClientes() {
    }

    public void listarEditoras() {
    }

    public void listarEmprestimos() {
    }
}
