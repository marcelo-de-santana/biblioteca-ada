package biblioteca.entity;

import biblioteca.service.LivroService;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.UUID;

public class Biblioteca {
    private static Biblioteca INSTANCIA = new Biblioteca();

    private final UUID id = UUID.randomUUID();
    private final String nome = "Biblioteca Nacional";
    private final LocalDate anoCriacao = LocalDate.of(2025, 01, 01);

    private LivroService livroService = new LivroService();

    private Biblioteca() {
    }

    public static Biblioteca getInstancia() {
        return INSTANCIA;
    }

    /**
     * TODO :
     * Criar os Prompts para cada cadastro
     */
    public static void cadastrarAutor() {
    }

    public static void cadastrarCliente() {
    }

    public static void cadastrarEditora() {
    }

    public static void cadastrarEmprestimo() {
    }

    public void listarAutor() {}


    public static void cadastrarLivro(Scanner promptInput) {
        var livro = Livro.builder().isbn(UUID.randomUUID()).build();
        System.out.println("Digite o título do livro:");
        livro.setTitulo(promptInput.nextLine());
        System.out.println("Digite a quantidade de páginas:");
        livro.setNumeroDePaginas(promptInput.nextInt());
        System.out.println("Digite o ano de publicação:");
        livro.setAnoPublicacao(promptInput.nextInt());


    }

}
