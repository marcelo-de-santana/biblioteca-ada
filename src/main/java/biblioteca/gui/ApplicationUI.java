package biblioteca.gui;

import biblioteca.entity.Autor;
import biblioteca.entity.Cliente;
import biblioteca.entity.Editora;
import biblioteca.entity.Livro;
import biblioteca.service.BibliotecaService;

import java.util.Scanner;

import static biblioteca.gui.ComponentUI.*;


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
        novaEditora.setTelefone(promptInput.nextLine());

        System.out.println("Informe o e-mail");
        novaEditora.setEmail(promptInput.nextLine());

        bibliotecaService.cadastrar(novaEditora);
    }

    static void cadastrarLivro() {
    }

    static void cadastrarCliente() {

    }

    static void cadastrarAutor() {
        mostrarTitulo("CADASTRANDO UM AUTOR");
        var novoAutor = new Autor();

        System.out.println("Nome:");
        novoAutor.setNome(promptInput.nextLine());

        bibliotecaService.cadastrar((Autor) novoAutor);
    }


    static void menuConsultar() {
        mostrarTitulo("CONSULTAR");
        mostrarMenu("1 - AUTORES | 2 - CLIENTES | 3 - EDITORAS | 4 - LIVROS");
        mensagemSelecioneUmaOpcao();

        switch (promptInput.nextLine()) {
            case "1" -> {
                consultarAutores();
                mostrarMenuCrud();

                switch (promptInput.nextLine()) {
                    case "1" -> cadastrarAutor();
                    case "2" -> alterarAutor();
                    case "3" -> excluirAutor();
                }
            }
        }
    }

    static void excluirAutor() {
    }

    static void alterarAutor() {
        consultarAutores();
        System.out.println("\nQual autor deseja alterar(ID)?");
        var autorId = promptInput.nextLine();

        var autor = bibliotecaService.getAutor(Integer.parseInt(autorId));

        if (autor.isEmpty()) {
            System.out.println("Autor não localizado");
        } else {
            System.out.println("Nome:" + promptInput.nextLine() + autor.get().getNome());
        }


    }

    static void consultarAutores() {
        mostrarTitulo("CONSULTAR AUTORES");
        if (bibliotecaService.getAutores().isEmpty()) {
            System.out.println("Nenhum autor cadastrado");
        }
        for (Autor autor : bibliotecaService.getAutores()) {
            System.out.println(autor.mostrar());
        }
    }

    static void listarClientes() {
        mostrarTitulo("CONSULTAR CLIENTES");
        if (bibliotecaService.getClientes().isEmpty()) {
            System.out.println("Nenhum cliente cadastrado");
        }
        for (Cliente cliente : bibliotecaService.getClientes()) {
            System.out.println(cliente.mostrar());
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
