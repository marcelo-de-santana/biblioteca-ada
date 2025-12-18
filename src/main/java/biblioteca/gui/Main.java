package biblioteca.gui;

import biblioteca.entity.*;

import java.util.Scanner;

import static biblioteca.entity.Biblioteca.*;
import static biblioteca.gui.ListagemGUI.tiposDeListagem;

public class Main {
    private static int opcaoSelecionada = 10;
    private static final Scanner promptInput = new Scanner(System.in);
    private static final Biblioteca biblioteca = Biblioteca.getInstancia();

    public static void main(String[] args) {
        while (opcaoSelecionada != 0) {
            mostrarMenu();
            opcaoSelecionada = promptInput.nextInt();
            mostraOpcaoDoMenu(opcaoSelecionada);
        }
    }

    static void mostraMensagemDeOpcaoInvalida() {
        System.out.println("Opção inválida");
    }

    static void mostrarMenu() {
        System.out.print("""
                ==== MENU ====
                1 - Ver lista
                2 - Cadastrar
                3 - Editar
                4 - Excluir
                0 - Sair
                
                Selecione uma opção:""");
    }

    static void mostraOpcaoDoMenu(int opcaoSelecionada) {
        switch (opcaoSelecionada) {
            case 0:
                tiposDeListagem(promptInput);
                break;
            case 1:
                break;
            case 2:
                tiposDeCadastro();
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                mostraMensagemDeOpcaoInvalida();
        }
    }


    static void tiposDeCadastro() {
        System.out.println("""
                O que deseja cadastrar?
                1 - Autor
                2 - Cliente
                3 - Editora
                4 - Empréstimo
                5 - Livro
                0 - Retornar ao Menu Anterior""");
        var opcaoSelecionada = promptInput.nextInt();

        switch (opcaoSelecionada) {
            case 1 -> cadastrarAutor();
            case 2 -> cadastrarCliente();
            case 3 -> cadastrarEditora();
            case 4 -> cadastrarEmprestimo();
            case 5 -> cadastrarLivro(promptInput);
            default -> mostraMensagemDeOpcaoInvalida();
        }


    }
}


