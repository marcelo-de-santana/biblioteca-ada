package biblioteca.repository;

import biblioteca.entity.Autor;

import java.util.List;
import java.util.Optional;

public interface AutorRepository {
    void save(Autor autor);

    Optional<Autor> findByName(String nome);

    List<Autor> findAll();
}
