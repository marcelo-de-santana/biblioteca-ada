package biblioteca.repository;

import biblioteca.entity.Autor;

import java.util.List;
import java.util.Optional;

public interface GenericRepository<T, ID> {
    T save(T entity);

    Optional<T> listarPeloId(ID id);

    default boolean existePorId(ID id) {
        return listarPeloId(id).isPresent();
    }

    List<T> listarTodos();

    void excluirPeloId(ID id);

    default long contar() {
        return listarTodos().size();
    }

}
