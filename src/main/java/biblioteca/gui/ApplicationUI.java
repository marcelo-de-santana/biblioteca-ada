package biblioteca.gui;

import static biblioteca.gui.ComponentUI.*;

import java.util.Scanner;

import biblioteca.entity.Editora;
import biblioteca.entity.Livro;
import biblioteca.service.BibliotecaService;
import biblioteca.utils.FormatadorUtils;

public class ApplicationUI {
    private static final Scanner promptInput = new Scanner(System.in);
    private static final BibliotecaService bibliotecaService = new BibliotecaService(promptInput);

    public static void iniciarUi() {
        mostrarTitulo("SISTEMA DE BIBLIOTECA");
        mostrarCatalogo();
        while (true) {
            try {
                menuConsultar();
            } catch (Exception exception) {
                System.out.println("Opção inválida" + exception.getCause());
                promptInput.nextLine();
            }
        }
    }

    static void mostrarCatalogo() {
        if (bibliotecaService.getCatalogo().isEmpty())
            System.out.println("Biblioteca Vazia");
        else {
            mostrarTitulo("CATÁLOGO");
            bibliotecaService.getCatalogo().forEach(livro -> System.out.println(livro.toString()));
        }
    }

    static void cadastrarEmprestimo() {
    }

    static void cadastraEmprestimo() {
    }

    static void cadastrarEditora() {
        var novaEditora = Editora.builder().build();

        System.out.println("==== NOVA EDITORA ====");
        System.out.println("Informe o nome: ");
        novaEditora.setNome(promptInput.nextLine());

        System.out.println("Informe o CNPJ: ");
        novaEditora.setCnpj(promptInput.nextLine());

        System.out.println("Informe o endereço: ");
        novaEditora.setEndereco(promptInput.nextLine());

        System.out.println("Informe o telefone");
        novaEditora.setTelefone(FormatadorUtils.formatarTelefone(promptInput.nextLine()));

        System.out.println("Informe o e-mail");
        novaEditora.setEmail(promptInput.nextLine());

        bibliotecaService.cadastrar(novaEditora);
    }

    static void cadastrarLivro() {
    }

    static void cadastrarCliente() {

    }

    /*
     * Menu Consultar
     * Responsável por chamar os tipos de consulta (autores, clientes, editoras,
     * livros)
     */
    static void menuConsultar() {
        mostrarTitulo("CONSULTAR");
        mostrarMenu("1 - AUTORES | 2 - CLIENTES | 3 - EDITORAS | 4 - LIVROS");
        mensagemSelecioneUmaOpcao();

        switch (promptInput.nextLine()) {
            case "1":
                new AutorUI(bibliotecaService, promptInput).iniciarUi();
            case "2":
                new ClienteUI(bibliotecaService, promptInput).iniciarUi();
            case "3":
                listarEditoras();
            case "4":
                listarLivros();
        }
    }

    static void listarEditoras() {
        mostrarTitulo("CONSULTAR EDITORAS");
        if (bibliotecaService.getEditoras().isEmpty()) {
            System.out.println("Nenhuma editora cadastrada");
        }
        for (Editora editora : bibliotecaService.getEditoras()) {
            System.out.println(editora.mostrar());
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
