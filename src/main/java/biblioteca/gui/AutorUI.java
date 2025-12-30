package biblioteca.gui;

import static biblioteca.gui.ComponentUI.*;

import java.util.Scanner;

import biblioteca.entity.Autor;
import biblioteca.service.BibliotecaService;

public class AutorUI {
    private final BibliotecaService bibliotecaService;
    private final Scanner promptInput;

    public AutorUI(BibliotecaService bibliotecaService, Scanner promptInput) {
        this.bibliotecaService = bibliotecaService;
        this.promptInput = promptInput;
    }

    public void iniciarUi() {
        consultarAutores();
        mostrarMenuCrud();

        switch (promptInput.nextLine()) {
            case "1" -> cadastrarAutor();
            case "2" -> alterarAutor();
            case "3" -> excluirAutor();
        }
    }

    private void consultarAutores() {
        mostrarTitulo("CONSULTAR AUTORES");
        if (bibliotecaService.getAutores().isEmpty()) {
            System.out.println("Nenhum autor cadastrado");
        } else {
            System.out.println("ID - NOME - NACIONALIDADE");
            for (Autor autor : bibliotecaService.getAutores()) {
                System.out.println(autor.mostrar());
            }
        }
    }

    private void cadastrarAutor() {
        mostrarTitulo("CADASTRANDO UM AUTOR");
        var novoAutor = new Autor();

        System.out.println("Nome:");
        novoAutor.setNome(promptInput.nextLine());

        System.out.println("Nacionalidade:");
        novoAutor.setNacionalidade(promptInput.nextLine());

        if (bibliotecaService.cadastrar((Autor) novoAutor)) {
            System.out.println("Autor cadastrado com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar autor");
        }
    }

    private void alterarAutor() {
        consultarAutores();
        System.out.println("\nQual autor deseja alterar(ID)?");
        var autorId = promptInput.nextLine();

        if (autorId.isBlank()) {
            System.out.println("ID inválido");
            return;
        }

        var autor = bibliotecaService.getAutor(Integer.parseInt(autorId));

        if (autor.isEmpty()) {
            System.out.println("Autor não localizado");
            return;
        }

        System.out.println("Nome atual: " + autor.get().getNome());
        System.out.println("Digite o novo nome (ou ENTER para manter):");
        var novoNome = promptInput.nextLine();

        if (!novoNome.isBlank()) {
            autor.get().setNome(novoNome);
        }

        System.out.println("Nacionalidade atual: " + autor.get().getNacionalidade());
        System.out.println("Digite a nova nacionalidade (ou ENTER para manter):");
        var novaNacionalidade = promptInput.nextLine();

        if (!novaNacionalidade.isBlank()) {
            autor.get().setNacionalidade(novaNacionalidade);
        }

        if (bibliotecaService.atualizar(autor.get())) {
            System.out.println("Dados atualizado com sucesso!");
        } else {
            System.out.println("Erro ao alterar os dados");
        }
    }

    private void excluirAutor() {
        System.out.println("\nQual autor deseja excluir(ID)?");
        var autorId = promptInput.nextLine();

        if (autorId.isBlank()) {
            System.out.println("ID inválido");
            return;
        }

        var autor = bibliotecaService.getAutor(Integer.parseInt(autorId));

        if (bibliotecaService.excluir(autor.get())) {
            System.out.println("Autor excluído com sucesso!");
        } else {
            System.out.println("Erro ao excluir autor");
        }
    }

}
