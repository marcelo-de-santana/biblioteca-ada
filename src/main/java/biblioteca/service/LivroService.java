package biblioteca.service;

import java.util.List;
import java.util.Optional;

import biblioteca.entity.Livro;
import biblioteca.repository.LivroRepository;

public class LivroService {
    private LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public Livro salvar(Livro livro) {
        if (livro.getTitulo() == null || livro.getTitulo().isEmpty()) {
            throw new IllegalArgumentException("O título do livro é obrigatório.");
        }
        return repository.salvar(livro);
    }

    public Optional<Livro> buscarPorIsbn(int isbn) {
        return repository.buscarPorIsbn(isbn);
    }

    public boolean excluir(int isbn) {
        return repository.excluir(isbn);
    }

    public List<Livro> listarTodos() {
        return repository.listarTodos();
    }
}