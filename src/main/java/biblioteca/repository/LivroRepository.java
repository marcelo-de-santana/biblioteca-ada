package biblioteca.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import biblioteca.entity.Livro;

public class LivroRepository {
    private List<Livro> livros = new ArrayList<>();
    private int proximoIsbn = 1;

    public Livro salvar(Livro livro) {
        if (livro.getIsbn() == 0) {
            livro.setIsbn(proximoIsbn++);
            livros.add(livro);
        } else {
            livros.stream()
                .filter(l -> l.getIsbn() == livro.getIsbn())
                .findFirst()
                .ifPresent(l -> {
                    l.setTitulo(livro.getTitulo());
                    l.setAutor(livro.getAutor());
                    l.setEditora(livro.getEditora());
                    l.setAnoPublicacao(livro.getAnoPublicacao());
                    l.setNumeroDePaginas(livro.getNumeroDePaginas());
                });
        }
        return livro;
    }

    public Optional<Livro> buscarPorIsbn(int isbn) {
        return livros.stream().filter(l -> l.getIsbn() == isbn).findFirst();
    }

    public boolean excluir(int isbn) {
        return livros.removeIf(l -> l.getIsbn() == isbn);
    }

    public List<Livro> listarTodos() {
        return new ArrayList<>(livros);
    }
}