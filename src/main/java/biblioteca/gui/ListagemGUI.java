package biblioteca.gui;

import java.util.Scanner;

import static biblioteca.gui.Main.mostraMensagemDeOpcaoInvalida;

public class ListagemGUI {

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
