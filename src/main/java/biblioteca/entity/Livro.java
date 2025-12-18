package biblioteca.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.UUID;

@Data
@Builder
public class Livro {

    private UUID isbn;
    private String titulo;
    private int numeroDePaginas;
    private int anoPublicacao;
    private Categoria categoria;
    private Editora editora;
    private Boolean emprestado;
}
