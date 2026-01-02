package biblioteca.service;

import java.util.List;
import java.util.Optional;

import biblioteca.entity.Editora;
import biblioteca.repository.EditoraRepository;

public class EditoraService {
    private EditoraRepository repository;

    public EditoraService(EditoraRepository repository) {
        this.repository = repository;
    }

    public Editora salvar(Editora editora) {
        return repository.salvar(editora);
    }

    public Optional<Editora> buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

    public boolean excluir(int id) {
        return repository.excluir(id);
    }

    public List<Editora> listarTodos() {
        return repository.listarTodos();
    }
}