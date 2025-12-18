package biblioteca.repository;

import biblioteca.entity.Autor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class AutorRepository implements GenericRepository {
        private List<Autor> autores = new ArrayList<>();

        @Override
        public void save(Object entity) {
            autores.add((Autor) entity);
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