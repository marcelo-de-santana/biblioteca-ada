package biblioteca.repository;

import java.util.List;
import java.util.Optional;

public class LivroRepository implements GenericRepository {
    @Override
    public Object save(Object entity) {
        return null;
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
