package biblioteca.service;

import java.util.List;
import java.util.Optional;

import biblioteca.entity.Autor;
import biblioteca.repository.AutorRepository;

public class AutorService {
    private AutorRepository repository;

    public AutorService(AutorRepository repository) {
        this.repository = repository;
    }

    public Autor salvar(Autor autor) {
        // Regra de negócio: O nome do autor é obrigatório
        if (autor.getNome() == null || autor.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do autor é obrigatório.");
        }
        return repository.salvar(autor);
    }

    public Optional<Autor> buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

    public boolean excluir(int id) {
        // Futuramente: Poderíamos verificar se o autor tem livros antes de excluir
        return repository.excluir(id);
    }

    public List<Autor> listarTodos() {
        return repository.listarTodos();
    }
}
