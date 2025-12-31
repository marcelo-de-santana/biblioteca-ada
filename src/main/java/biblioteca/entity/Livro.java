package biblioteca.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Livro {
    private int isbn;
    private String titulo;
    private int numeroDePaginas;
    private int anoPublicacao;
    private Categoria categoria;
    private Editora editora;
    private Autor autor;

    public String mostrar() {
        return isbn + " - " + titulo + " - " + autor.getNome() + " - " + editora.getNome() + " - " + anoPublicacao + " - " + categoria.getDescricao() + " - " + numeroDePaginas;
    }
}
