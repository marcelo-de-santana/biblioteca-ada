package biblioteca.gui;

import static biblioteca.gui.ComponentUI.*;

import java.util.Scanner;

import biblioteca.entity.Autor;
import biblioteca.entity.Categoria;
import biblioteca.entity.Editora;
import biblioteca.entity.Livro;
import biblioteca.service.BibliotecaService;
import biblioteca.utils.FormatadorUtils;

public class LivroUI {
    private final BibliotecaService bibliotecaService;
    private final Scanner promptInput;

    public LivroUI(BibliotecaService bibliotecaService, Scanner promptInput) {
        this.bibliotecaService = bibliotecaService;
        this.promptInput = promptInput;
    }

    public void iniciarUi() {
        consultarLivros();
        mostrarMenuCrud();

        switch (promptInput.nextLine()) {
            case "1" -> cadastrarLivro();
//            case "2" -> alterarLivro();
//            case "3" -> excluirLivro();
        }
    }

    void consultarLivros() {
        mostrarTitulo("CONSULTAR LIVROS");
        if (bibliotecaService.getLivros().isEmpty()) {
            System.out.println("Nenhum livro cadastrado");
        }
        for (Livro livro : bibliotecaService.getLivros()) {
            System.out.println(livro.mostrar());
        }
    }

    private void cadastrarLivro() {
        var novoLivro = new Livro();

        mostrarTitulo("CADASTRANDO UM LIVRO");

        System.out.println("Nome:");
        novoLivro.setNome(promptInput.nextLine());

        System.out.println("Número de páginas:");
        novoLivro.setNumeroDePaginas(Integer.parseInt(promptInput.nextLine()));

        System.out.println("Ano de publicação:");
        novoLivro.setAnoPublicacao(Integer.parseInt(promptInput.nextLine()));

        //listar os autores e receber o ID, verificar se está vazio ou não
        var autor = atribuirAutor();
        if (autor == null) {
            System.out.println("Cadastro de livro cancelado: autor não selecionado.");
            return;
        }
        novoLivro.setAutor(autor);


        //listar as categorias e receber o ID, verificar se está vazio ou não
        var categoria = atribuirCategoria();
        if (autor == null) {
            System.out.println("Cadastro de livro cancelado: categoria não selecionada.");
            return;
        }
        novoLivro.setAutor(autor);

        //listar as editoras e receber o ID, verificar se está vazio ou não
        var editora = atribuirEditora();
        if (editora == null) {
            System.out.println("Cadastro de livro cancelado: editora não selecionada.");
            return;
        }
        novoLivro.setEditora(editora);
        //chamar o bibliotecaService com a função de listar as editoras .getEditoras().forEach(editora -> editora.mostrarEditora());


        System.out.println("Se encontra emprestado no momento (S/N)?");
        String simOuNao = promptInput.nextLine();
        if (simOuNao.equalsIgnoreCase("s")) {
            novoLivro.setEmprestado(true);
        } else {
            novoLivro.setEmprestado(false);
        }


        if (bibliotecaService.cadastrar(novoLivro)) {
            System.out.println("Livro cadastrado com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar livro");
        }
    }

    private Autor atribuirAutor() {
        consultarAutores();
        if (bibliotecaService.getAutores().isEmpty()) {
            System.out.println("Nenhum autor cadastrado. Cadastre um autor antes de continuar.");
            return null;
        }

        System.out.println("Selecione um autor (ID):");

        while (true) {
            var entrada = promptInput.nextLine();

            if (entrada == null || entrada.isBlank()) {
                System.out.println("ID vazio. Informe um número válido:");
                continue;
            }
            try {
                int id = Integer.parseInt(entrada.trim());
                var autorOpc = bibliotecaService.getAutor(id);

                if (autorOpc.isPresent()) {
                    var autor = autorOpc.get();
                    System.out.printf("Autor selecionado: %s (%s)%n", autor.getNome(), autor.getNacionalidade());
                    return autor;
                } else {
                    System.out.println("Autor não localizado. Tente novamente:");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Informe um número inteiro:");
            }
        }

    }

    private Categoria atribuirCategoria() {
        mostrarTitulo("CATEGORIAS");

        // Lista todas as categorias com ID e descrição
        for (var c : Categoria.values()) {
            System.out.printf("ID: %d | %s%n", c.getId(), c.getDescricao());
        }

        System.out.println("-------------------------");
        System.out.println("Selecione a categoria (ID ou nome).:");

        while (true) {
            var entrada = promptInput.nextLine();

            if (entrada == null || entrada.isBlank()) {
                System.out.println("Entrada vazia. Informe um ID ou nome válido (ou 0 para cancelar):");
                continue;
            }

            // Tenta por ID
            try {
                var id = Integer.parseInt(entrada.trim());
                var cat = Categoria.porId(id);
                if (cat != null) {
                    System.out.printf("Categoria selecionada: %s (ID: %d)%n", cat.getDescricao(), cat.getId());
                    return cat;
                } else {
                    System.out.println("ID inválido. Tente novamente!");
                    continue;
                }
            } catch (NumberFormatException ignore) {
                // Não é número; tenta por texto
            }

            var catTexto = Categoria.porTexto(entrada);
            if (catTexto != null) {
                System.out.printf("Categoria selecionada: %s (ID: %d)%n", catTexto.getDescricao(), catTexto.getId());
                return catTexto;
            } else {
                System.out.println("Categoria não localizada. Tente novamente!");
            }

        }
    }

    private Editora atribuirEditora(){
        EditoraUI.consultarEditoras();
        if (bibliotecaService.getAutores().isEmpty()) {
            System.out.println("Nenhum autor cadastrado. Cadastre um autor antes de continuar.");
            return null;
        }

        System.out.println("Selecione um autor (ID):");

        while (true) {
            var entrada = promptInput.nextLine();

            if (entrada == null || entrada.isBlank()) {
                System.out.println("ID vazio. Informe um número válido:");
                continue;
            }
            try {
                int id = Integer.parseInt(entrada.trim());
                var autorOpc = bibliotecaService.getAutor(id);

                if (autorOpc.isPresent()) {
                    var autor = autorOpc.get();
                    System.out.printf("Autor selecionado: %s (%s)%n", autor.getNome(), autor.getNacionalidade());
                    return autor;
                } else {
                    System.out.println("Autor não localizado. Tente novamente:");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Informe um número inteiro:");
            }
        }
    }

    private void alterarEditora() {
        System.out.println("\nQual editora deseja alterar(ID)?");
        var editoraId = promptInput.nextLine();

        if (editoraId.isBlank()) {
            System.out.println("ID inválido");
            return;
        }

        var editora = bibliotecaService.getEditora(Integer.parseInt(editoraId));
        if (editora.isEmpty()) {
            System.out.println("Editora não localizada");
            return;
        }

        System.out.println("Nome atual: " + editora.get().getNome());
        System.out.println("Digite o novo nome (ou ENTER para manter):");
        var novoNome = promptInput.nextLine();

        if (!novoNome.isBlank()) {
            editora.get().setNome(novoNome);
        }

        System.out.println("CNPJ atual: " + editora.get().getCnpj());
        System.out.println("Digite o novo CNPJ (ou ENTER para manter):");
        var novoCnpj = promptInput.nextLine();

        if (!novoCnpj.isBlank()) {
            editora.get().setCnpj(novoCnpj);
        }

        System.out.println("Endereço atual: " + editora.get().getEndereco());
        System.out.println("Digite o novo endereço (ou ENTER para manter):");
        var novoEndereco = promptInput.nextLine();

        if (!novoEndereco.isBlank()) {
            editora.get().setEndereco(novoEndereco);
        }

        System.out.println("Telefone atual: " + editora.get().getTelefone());
        System.out.println("Digite o novo telefone (ou ENTER para manter):");
        var novoTelefone = promptInput.nextLine();

        if (!novoTelefone.isBlank()) {
            editora.get().setTelefone(FormatadorUtils.formatarTelefone(novoTelefone));
        }

        System.out.println("E-mail atual: " + editora.get().getEmail());
        System.out.println("Digite o novo e-mail (ou ENTER para manter):");
        var novoEmail = promptInput.nextLine();

        if (!novoEmail.isBlank()) {
            editora.get().setEmail(novoEmail);
        }

        if (bibliotecaService.atualizar(editora.get())) {
            System.out.println("Dados atualizado com sucesso!");
        } else {
            System.out.println("Erro ao alterar os dados");
        }
    }

    private void excluirEditora() {
        System.out.println("\nQual editora deseja excluir(ID)?");
        var editoraId = promptInput.nextLine();

        if (editoraId.isBlank()) {
            System.out.println("ID inválido");
            return;
        }

        var editora = bibliotecaService.getEditora(Integer.parseInt(editoraId));

        if (bibliotecaService.excluir(editora.get())) {
            System.out.println("Editora excluída com sucesso!");
        } else {
            System.out.println("Erro ao excluir editora");
        }
    }

    private void consultarAutores() {
        mostrarTitulo("AUTORES");
        if (bibliotecaService.getAutores().isEmpty()) {
            System.out.println("Nenhum autor cadastrado");
        } else {
            System.out.println("ID - NOME - NACIONALIDADE");
            for (Autor autor : bibliotecaService.getAutores()) {
                System.out.println(autor.mostrar());
            }
        }
    }

    private void consultarEditoras() {
        mostrarTitulo("CONSULTAR EDITORAS");
        if (bibliotecaService.getEditoras().isEmpty()) {
            System.out.println("Nenhuma editora cadastrada");
        }
        for (Editora editora : bibliotecaService.getEditoras()) {
            System.out.println(editora.mostrar());
        }
    }

}
