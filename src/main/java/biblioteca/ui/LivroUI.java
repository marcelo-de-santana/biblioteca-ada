package biblioteca.ui;

import static biblioteca.ui.ComponentUI.*;

import java.time.LocalDate;
import java.util.Scanner;

import biblioteca.entity.Autor;
import biblioteca.entity.Categoria;
import biblioteca.entity.Editora;
import biblioteca.entity.Livro;
import biblioteca.service.BibliotecaService;

public class LivroUI {
    private final BibliotecaService bibliotecaService;
    private final Scanner promptInput;

    public LivroUI(BibliotecaService bibliotecaService, Scanner promptInput) {
        this.bibliotecaService = bibliotecaService;
        this.promptInput = promptInput;
    }

    public void iniciarUi() {
        while (true) {
            mostrarCatalogo(bibliotecaService);
            mostrarMenuCrud();

            switch (promptInput.nextLine()) {
                case "1" -> cadastrarLivro();
                case "2" -> alterarLivro();
                case "3" -> excluirLivro();
                case "0" -> { return; }
                default -> System.out.println("Opção inválida");
            }
        }
    }

    public static void mostrarCatalogo(BibliotecaService bibliotecaService) {
        if (bibliotecaService.getLivros().isEmpty())
            System.out.println("Biblioteca Vazia");
        else {
            mostrarTitulo("CATÁLOGO");
            System.out.println("ISBN - TÍTULO - AUTOR - EDITORA - ANO - CATEGORIA - NÚMERO DE PÁGINAS");
            for (Livro livro : bibliotecaService.getLivros()) {
                System.out.println(livro.mostrar());
            }
        }
    }

    public static void mostrarCatalogoDisponivel(BibliotecaService bibliotecaService) {
        if (bibliotecaService.getLivros().isEmpty()) {
            System.out.println("Nenhum livro cadastrado");
            return;
        }

        mostrarTitulo("LIVROS DISPONÍVEIS");
        System.out.println("ISBN - TÍTULO - AUTOR - EDITORA - ANO - CATEGORIA - NÚMERO DE PÁGINAS");
        var livrosDisponiveis = bibliotecaService.getLivros().stream()
                .filter(livro -> bibliotecaService.livroEstaDisponivel(livro)).toList();

        if (livrosDisponiveis.isEmpty()) {
            System.out.println("Nenhum livro disponível no momento.");
            return;
        }

        for (Livro livro : livrosDisponiveis) {
            System.out.println(livro.mostrar());
        }

    }

    private void cadastrarLivro() {
        var novoLivro = new Livro();

        mostrarTitulo("CADASTRANDO UM LIVRO");

        System.out.println("Nome:");
        var tituloLivro = promptInput.nextLine();

        if (tituloLivro.isBlank()) {
            System.out.println("Título inválido.");
            return;
        }
        novoLivro.setTitulo(tituloLivro);

        System.out.println("Número de páginas:");
        novoLivro.setNumeroDePaginas(Integer.parseInt(promptInput.nextLine()));

        System.out.println("Ano de publicação:");
        var anoDePublicacao = promptInput.nextLine();

        if (anoDePublicacao.isBlank() || Integer.parseInt(anoDePublicacao) > LocalDate.now().getYear()) {
            System.out.println("Ano de publicação inválido.");
            anoDePublicacao = String.valueOf(LocalDate.now().getYear());
        } else {
            novoLivro.setAnoPublicacao(Integer.parseInt(anoDePublicacao));
        }

        novoLivro.setAutor(escolherAutor());
        novoLivro.setCategoria(escolherCategoria());
        novoLivro.setEditora(atribuirEditora());

        if (bibliotecaService.cadastrar(novoLivro)) {
            System.out.println("Livro cadastrado com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar livro");
        }
    }

    private void alterarLivro() {
        mostrarCatalogo(bibliotecaService);
        System.out.println("\nQual livro deseja alterar (ISBN)?");
        var isbnStr = promptInput.nextLine();

        if (isbnStr.isBlank()) {
            System.out.println("ISBN inválido.");
            return;
        }

        var livroOpt = bibliotecaService.getLivro(Integer.parseInt(isbnStr));
        if (livroOpt.isEmpty()) {
            System.out.println("Livro não localizado.");
            return;
        }
        var livro = livroOpt.get();

        System.out.println("Título atual: " + livro.getTitulo());
        System.out.println("Digite o novo título (ou ENTER para manter):");
        var novoTitulo = promptInput.nextLine();
        if (!novoTitulo.isBlank()) {
            livro.setTitulo(novoTitulo);
        }

        System.out.println("Número de páginas atual: " + livro.getNumeroDePaginas());
        System.out.println("Digite o novo número (ou ENTER para manter):");
        var novasPaginas = promptInput.nextLine();
        if (!novasPaginas.isBlank()) {
            livro.setNumeroDePaginas(Integer.parseInt(novasPaginas));
        }

        System.out.println("Ano de publicação atual: " + livro.getAnoPublicacao());
        System.out.println("Digite o novo ano (ou ENTER para manter):");
        var novoAno = promptInput.nextLine();
        if (!novoAno.isBlank()) {
            int ano = Integer.parseInt(novoAno);
            if (ano <= LocalDate.now().getYear()) {
                livro.setAnoPublicacao(ano);
            } else {
                System.out.println("Ano inválido (futuro). Mantido o anterior.");
            }
        }

        System.out.println("Autor atual: " + livro.getAutor().getNome());
        System.out.println("Deseja alterar o autor? (S/N):");
        if (promptInput.nextLine().trim().equalsIgnoreCase("S")) {
            livro.setAutor(escolherAutor());
        }

        System.out.println(String.format("Categoria atual: ", livro.getCategoria().getDescricao()));
        System.out.println("Deseja alterar a categoria? (S/N):");
        if (promptInput.nextLine().trim().equalsIgnoreCase("S")) {
            livro.setCategoria(escolherCategoria());
        }

        System.out.println("Editora atual: " + livro.getEditora().getNome());
        System.out.println("Deseja alterar a editora? (S/N):");
        if (promptInput.nextLine().trim().equalsIgnoreCase("S")) {
            livro.setEditora(atribuirEditora());
        }

        if (bibliotecaService.atualizar(livro)) {
            System.out.println("Livro atualizado com sucesso!");
        } else {
            System.out.println("Erro ao atualizar livro.");
        }
    }

    private void excluirLivro() {
        mostrarCatalogo(bibliotecaService);
        System.out.println("\nQual livro deseja excluir (ISBN)?");
        var isbnStr = promptInput.nextLine();

        if (isbnStr.isBlank()) {
            System.out.println("ISBN inválido.");
            return;
        }

        var livroOpt = bibliotecaService.getLivro(Integer.parseInt(isbnStr));
        if (livroOpt.isEmpty()) {
            System.out.println("Livro não localizado.");
            return;
        }

        if (bibliotecaService.excluir(livroOpt.get())) {
            System.out.println("Livro excluído com sucesso!");
        } else {
            System.out.println("Erro ao excluir livro.");
        }
    }

    private Autor escolherAutor() {
        while (bibliotecaService.getAutores().isEmpty()) {
            System.out.println("Nenhum autor cadastrado. Cadastre um autor antes de continuar.");
            AutorUI.cadastrarAutor(bibliotecaService, promptInput);
        }

        AutorUI.consultarAutores(bibliotecaService);
        System.out.println("Selecione um autor (ID):");

        while (true) {
            var entrada = promptInput.nextLine();

            if (entrada.isBlank()) {
                System.out.println("ID inválido. Tente novamente:");
                continue;
            }

            try {
                var id = Integer.parseInt(entrada.trim());
                var autorOpt = bibliotecaService.getAutor(id);
                if (autorOpt.isPresent()) {
                    return autorOpt.get();
                }
                System.out.println("Autor não localizado. Tente novamente:");
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite apenas números:");
            }
        }
    }

    private Categoria escolherCategoria() {
        buscarCategorias();
        System.out.println("\nSelecione a categoria (ID):");

        while (true) {
            var entrada = promptInput.nextLine();

            if (entrada.isBlank()) {
                continue;
            }

            try {
                var id = Integer.parseInt(entrada.trim());
                if (Categoria.existsById(id)) {
                    return Categoria.porId(id);

                }
                System.out.println("ID inválido. Tente novamente:");
            } catch (NumberFormatException ignore) {
                System.out.println("Entrada inválida. Digite apenas números:");
            }
        }
    }

    private Editora atribuirEditora() {
        while (bibliotecaService.getEditoras().isEmpty()) {
            System.out.println("Nenhuma editora cadastrada. Cadastre uma editora antes de continuar.");
            EditoraUI.cadastrarEditora(bibliotecaService, promptInput);
        }

        EditoraUI.consultarEditoras(bibliotecaService);
        System.out.println("Selecione uma editora (ID):");

        while (true) {
            var entrada = promptInput.nextLine();

            if (entrada.isBlank()) {
                System.out.println("ID inválido. Tente novamente:");
                continue;
            }
            try {
                int id = Integer.parseInt(entrada.trim());
                var editoraOpc = bibliotecaService.getEditora(id);

                if (editoraOpc.isPresent()) {
                    return editoraOpc.get();
                }
                System.out.println("Editora não localizada. Tente novamente:");
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite apenas números:");
            }
        }
    }

    private void buscarCategorias() {
        mostrarTitulo("CATEGORIAS");

        System.out.println("ID - DESCRIÇÃO");
        for (var categoria : Categoria.values()) {
            System.out.println(categoria.mostrar());
        }
    }
}
