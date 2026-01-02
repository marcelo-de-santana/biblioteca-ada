package biblioteca.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import biblioteca.entity.Autor;

public class AutorRepository {
    private List<Autor> autores = new ArrayList<>();
    private int proximoId = 1;

    public Autor salvar(Autor autor) {
        if (autor.getId() == 0) {
            autor.setId(proximoId++);
            autores.add(autor);
        } else {
            // Lógica de atualização: encontrar e substituir se necessário
            // Como é em memória e passamos a referência, muitas vezes não precisa fazer nada
            // mas em um banco real, aqui haveria um UPDATE.
            autores.stream()
                .filter(a -> a.getId() == autor.getId())
                .findFirst()
                .ifPresent(a -> {
                    a.setNome(autor.getNome());
                    a.setNacionalidade(autor.getNacionalidade());
                });
        }
        return autor;
    }

    public Optional<Autor> buscarPorId(int id) {
        return autores.stream()
                .filter(a -> a.getId() == id)
                .findFirst();
    }

    public boolean excluir(int id) {
        // Removemos pelo ID sem reindexar os outros, mantendo a integridade
        return autores.removeIf(a -> a.getId() == id);
    }

    public List<Autor> listarTodos() {
        return new ArrayList<>(autores);
    }
}
