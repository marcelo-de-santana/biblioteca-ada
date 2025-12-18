package biblioteca.repository;

import biblioteca.entity.Editora;
import biblioteca.repository.GenericRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EditoraRepository implements GenericRepository {
    private List<Editora> editoras = new ArrayList<>();

    @Override
    public void save(Object entity) {
        editoras.add((Editora) entity);
    }

    @Override
    public Optional listarPeloId(Object o) {
        return Optional.empty();
    }

    @Override
    public List listarTodos() {
        return List.of();
    }

    @Override
    public void excluirPeloId(Object o) {

    }
}
