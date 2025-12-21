package biblioteca.gui;

import static biblioteca.gui.ComponentUI.*;

import java.util.Scanner;

import biblioteca.entity.Autor;
import biblioteca.service.BibliotecaService;

public class AutorUI {
    private BibliotecaService bibliotecaService;
    private Scanner promptInput;

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

    public void consultarAutores() {
        mostrarTitulo("CONSULTAR AUTORES");
        if (bibliotecaService.getAutores().isEmpty()) {
            System.out.println("Nenhum autor cadastrado");
        }
        for (Autor autor : bibliotecaService.getAutores()) {
            System.out.println(autor.mostrar());
        }
    }

    public void cadastrarAutor() {
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

    public void alterarAutor() {
        System.out.println("\nQual autor deseja alterar(ID)?");
        var autorId = promptInput.nextLine();

        var autor = bibliotecaService.getAutor(Integer.parseInt(autorId));

        if (autor.isEmpty()) {
            System.out.println("Autor não localizado");
        } else {
            var autorEncontrado = autor.get();
            System.out.println("Nome atual: " + autorEncontrado.getNome());
            System.out.println("Digite o novo nome (ou ENTER para manter):");
            var novoNome = promptInput.nextLine();

            System.out.println("Nacionalidade atual: " + autorEncontrado.getNacionalidade());
            System.out.println("Digite a nova nacionalidade (ou ENTER para manter):");
            var novaNacionalidade = promptInput.nextLine();

            if (!novoNome.isBlank()) {
                autorEncontrado.setNome(novoNome);
            }
            if (!novaNacionalidade.isBlank()) {
                autorEncontrado.setNacionalidade(novaNacionalidade);
            }

            if (!(novoNome.isBlank() || novaNacionalidade.isBlank())) {
                if (bibliotecaService.atualizar(autorEncontrado)) {
                    System.out.println("Dados atualizado com sucesso!");
                } else {
                    System.out.println("Erro ao alterar os dados");
                }
            }
        }
    }

    public void excluirAutor() {
        System.out.println("\nQual autor deseja excluir(ID)?");
        var autorId = promptInput.nextLine();

        var autor = bibliotecaService.getAutor(Integer.parseInt(autorId));

        if (autor.isEmpty()) {
            System.out.println("Autor não localizado");
        } else if (bibliotecaService.excluir(autor.get())) {
            System.out.println("Autor excluído com sucesso!");
        }
    }

}
