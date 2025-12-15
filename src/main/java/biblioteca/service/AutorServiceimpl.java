package biblioteca.service;

import biblioteca.entity.Autor;
import biblioteca.repository.AutorRepository;

import java.util.List;
import java.util.Optional;

public class AutorServiceimpl {

    private final AutorRepository autorRepository;

    public AutorServiceimpl(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public void cadastrarAutor(Autor autor) {
        autorRepository.save(autor);
    }

    public Optional<Autor> pesquisarAutor(String nome) {
        return null;
    }

    public List<Autor> listarAutores() {
        return null;
    }
}
