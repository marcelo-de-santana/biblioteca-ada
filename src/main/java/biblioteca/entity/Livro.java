package biblioteca.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Livro {
    private int isbn; //falta
    private String nome;
    private int numeroDePaginas;
    private int anoPublicacao;
    private Categoria categoria; //falta
    private Editora editora; //falta
    private Boolean emprestado;
    private Autor autor; //falta

    public String mostrar() {
        return isbn + " - " + nome;
    }
}
