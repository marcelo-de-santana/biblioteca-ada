package biblioteca.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "isbn")
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
