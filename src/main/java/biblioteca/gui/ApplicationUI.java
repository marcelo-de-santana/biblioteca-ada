package biblioteca.gui;

import static biblioteca.gui.ComponentUI.*;

import java.util.Scanner;

import biblioteca.entity.Livro;
import biblioteca.service.BibliotecaService;

public class ApplicationUI {
    private static final Scanner promptInput = new Scanner(System.in);
    private static final BibliotecaService bibliotecaService = new BibliotecaService();

    public static void iniciarUi() {
        mostrarTitulo("SISTEMA DE BIBLIOTECA");
        while (true) {
            try {
                mostrarCatalogo(bibliotecaService);
                menuConsultar();
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
    static void menuConsultar() {
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

    static void listarLivros() {
        mostrarTitulo("CONSULTAR LIVROS");
        if (bibliotecaService.getLivros().isEmpty()) {
            System.out.println("Nenhum livro cadastrado");
        }
        for (Livro livro : bibliotecaService.getLivros()) {
            System.out.println(livro.mostrar());
        }
    }
}
