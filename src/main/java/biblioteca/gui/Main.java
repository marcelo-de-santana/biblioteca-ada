package biblioteca.gui;

import biblioteca.entity.*;
import biblioteca.service.JsonLoader;

import java.util.Scanner;

public class Main {
    private static final int[] opcoesDePrompt = {0, 1, 2, 3, 4};
    private static int opcaoSelecionada = 0;
    private static final Scanner promptInput = new Scanner(System.in);
    private static final Biblioteca biblioteca = new Biblioteca();

    public static void main(String[] args) {
        while (opcaoSelecionada != 4) {
            mostrarMenu();
            opcaoSelecionada = promptInput.nextInt();
        }
    }

    static void mostrarMenu() {
        var texto = """
                ==== MENU ====
                0 - Ver lista
                1 - Cadastrar
                2 - Editar
                3 - Excluir
                4 - Sair
                
                Selecione uma opção: """;

        System.out.print(texto);
    }
}


