package biblioteca.gui;

import biblioteca.repository.AutorRepository;
import biblioteca.repository.BibliotecaRepository;
import biblioteca.repository.ClienteRepository;
import biblioteca.repository.EditoraRepository;
import biblioteca.service.BibliotecaService;

import java.util.Scanner;

public class ApplicationConfigUI {

    private final BibliotecaService bibliotecaService;

    public ApplicationConfigUI(){
        bibliotecaService = new BibliotecaService(new BibliotecaRepository(), new AutorRepository(), new ClienteRepository(), new EditoraRepository());
    }

    public static void tiposDeListagem(Scanner promptInput) {
        System.out.println("""
                O que deseja listar?
                1 - Autor
                2 - Cliente
                3 - Editora
                4 - Empréstimo
                5 - Livro
                0 - Retornar ao Menu Anterior""");

        var opcaoSelecionada = promptInput.nextInt();


//        switch (opcaoSelecionada) {
//            case 1 -> listarAutor();
//            case 2 -> listarCliente();
//            case 3 -> listarEditora();
//            case 4 -> listarEmprestimo();
//            case 5 -> listarLivro(promptInput);
//            default -> mostraMensagemDeOpcaoInvalida();
//        }
    }

}
