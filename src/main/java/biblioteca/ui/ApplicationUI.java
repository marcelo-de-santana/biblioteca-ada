package biblioteca.ui;

import static biblioteca.ui.ComponentUI.*;

import java.util.Scanner;

import biblioteca.service.BibliotecaService;

public class ApplicationUI {
    private static final Scanner promptInput = new Scanner(System.in);
    private static final BibliotecaService bibliotecaService = new BibliotecaService();

    public static void iniciarUi() {
        mostrarMenu("SISTEMA DE BIBLIOTECA");
        while (true) {
            try {
                menuPrincipal();
            } catch (RuntimeException runtimeException) {
                System.out.println("Opção inválida" + runtimeException.getCause());
                promptInput.nextLine();
            }
        }
    }

    /*
     * Menu Consultar
     * Responsável por chamar os tipos de consulta (autores, clientes, editoras,
     * livros)
     */
    static void menuPrincipal() {
        mostrarTitulo("CONSULTAR");
        mostrarMenu("1 - AUTORES | 2 - CLIENTES | 3 - EDITORAS | 4 - LIVROS | 5 - EMPRÉSTIMOS");
        mensagemSelecioneUmaOpcao();

        switch (promptInput.nextLine()) {
            case "1" -> new AutorUI(bibliotecaService, promptInput).iniciarUi();
            case "2" -> new ClienteUI(bibliotecaService, promptInput).iniciarUi();
            case "3" -> new EditoraUI(bibliotecaService, promptInput).iniciarUi();
            case "4" -> new LivroUI(bibliotecaService, promptInput).iniciarUi();
            case "5" -> new EmprestimoUI(bibliotecaService, promptInput).iniciarUi();
        }
    }
}
