package biblioteca.entity;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

@Data
public class Biblioteca {
    private static Biblioteca INSTANCIA = new Biblioteca();

    private final UUID id = UUID.randomUUID();
    private final String nome = "Biblioteca Nacional";
    private final LocalDate anoCriacao = LocalDate.of(2025, 01, 01);
    private final List<Livro> livros = new ArrayList<Livro>();
    private final List<Cliente> clientes = new ArrayList<Cliente>();

    private Biblioteca() {
    }

    public static Biblioteca getInstancia() {
        return INSTANCIA;
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void removerLivro(Livro livro) {
        if (!livros.removeIf(l -> id.equals(l.getIsbn())))
            System.out.println("Livro não encontrado");
    }


}
