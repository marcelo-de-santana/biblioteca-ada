package biblioteca.gui;

import biblioteca.service.BibliotecaService;

import java.util.Scanner;


public class ApplicationConfigUI {
    private static final Scanner promptInput = new Scanner(System.in);
    private static final BibliotecaService bibliotecaService = new BibliotecaService(promptInput);

    private static int opcaoMenuPrincipal = 10;

    public static void iniciarUi() {
        while (opcaoMenuPrincipal != 0) {
            opcaoMenuPrincipal = mostrarMenu();
            mostraOpcaoDoMenu(opcaoMenuPrincipal);
        }
    }

    static void mostraMensagemDeOpcaoInvalida() {
        System.out.println("Opção inválida");
    }

    static int mostrarMenu() {
        System.out.print("""
                ==== MENU ====
                1 - Ver lista
                2 - Cadastrar
                3 - Editar
                4 - Excluir
                0 - Sair
                
                Selecione uma opção:""");

        return promptInput.nextInt();
    }

    static void mostraOpcaoDoMenu(int opcaoSelecionada) {
        if (opcaoSelecionada != 0)
            switch (opcaoSelecionada) {
                case 1 -> tiposDeListagem();
//            case 1->
//            case 2->
//                tiposDeCadastro();
//            case 3->
//            case 4->
                default -> mostraMensagemDeOpcaoInvalida();
            }
    }


    public static void tiposDeListagem() {
        System.out.println("""
                O que deseja listar?
                1 - Autores
                2 - Clientes
                3 - Editoras
                4 - Empréstimos
                5 - Livros
                0 - Retornar ao Menu Anterior""");

        var opcaoSelecionada = promptInput.nextInt();


        switch (opcaoSelecionada) {
            case 1 -> bibliotecaService.listarAutores();
//            case 2 -> bibliotecaService.listarClientes();
//            case 3 -> bibliotecaService.listarEditoras();
//            case 4 -> bibliotecaService.listarEmprestimos();
//            case 5 -> bibliotecaService.listarLivros();
            default -> mostraMensagemDeOpcaoInvalida();
        }

//
//        static void tiposDeCadastro () {
//            System.out.println("""
//                    O que deseja cadastrar?
//                    1 - Autor
//                    2 - Cliente
//                    3 - Editora
//                    4 - Empréstimo
//                    5 - Livro
//                    0 - Retornar ao Menu Anterior""");
//            var opcaoSelecionada = promptInput.nextInt();
//
//            switch (opcaoSelecionada) {
//                case 1 -> cadastrarAutor();
//                case 2 -> cadastrarCliente();
//                case 3 -> cadastrarEditora();
//                case 4 -> cadastrarEmprestimo();
//                case 5 -> cadastrarLivro(promptInput);
//                default -> mostraMensagemDeOpcaoInvalida();
//            }
//
//
//        }
    }

}
