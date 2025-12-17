package biblioteca.entity;

import java.time.LocalDate;
import java.util.UUID;

public class Biblioteca {
    private static Biblioteca INSTANCIA = new Biblioteca();

    private UUID id = UUID.randomUUID();
    private String nome = "Biblioteca Nacional";
    private LocalDate anoCriacao = LocalDate.of(2025, 01, 01);

    private Biblioteca() {
    }

    public static Biblioteca getInstancia() {
        return INSTANCIA;
    }

    /**TODO :
     * Criar os Promps para cada cadastro
     * */
    public static void cadastrarAutor() {
    }

    public static void cadastrarCliente() {
    }

    public static void cadastrarEditora() {
    }

    public static void cadastrarEmprestimo() {
    }

    public static void cadastrarLivro() {
    }

    public static void cadastrarBiblioteca() {
    }

}
