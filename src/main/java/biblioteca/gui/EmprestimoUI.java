package biblioteca.gui;

import biblioteca.entity.Emprestimo;
import biblioteca.service.BibliotecaService;

import java.time.LocalDate;
import java.util.Scanner;

import static biblioteca.gui.ComponentUI.*;
import static biblioteca.utils.FormatadorUtils.formatarDataParaPTBR;
import static biblioteca.utils.FormatadorUtils.transformarEmLocalDate;

public class EmprestimoUI {
    private final BibliotecaService bibliotecaService;
    private final Scanner promptInput;

    public EmprestimoUI(BibliotecaService bibliotecaService, Scanner promptInput) {
        this.bibliotecaService = bibliotecaService;
        this.promptInput = promptInput;
    }

    public void iniciarUi() {
        consultarEmprestimos();
        mostrarMenuCrud();

        switch (promptInput.nextLine()) {
            case "1" -> cadastrarEmprestimo();
            case "2" -> alterarEmprestimo();
            case "3" -> excluirEmprestimo();
        }
    }

    private void cadastrarEmprestimo() {
        mostrarTitulo("CADASTRANDO UM EMPRÉSTIMO");
        var novoEmprestimo = new Emprestimo();

        mostrarCatalogo(bibliotecaService);
        System.out.println("Digite livro a ser emprestado (ISBN):");

        var livroId = promptInput.nextLine();

        if (livroId.isEmpty()) {
            System.out.println("ID inválido.");
            return;
        }

        var livro = bibliotecaService.getLivro(Integer.parseInt(livroId));

        if (livro.isEmpty()) {
            System.out.println("Livro não localizado");
            return;
        }

        livro.ifPresent(novoEmprestimo::setLivro);

        var dataAtual = LocalDate.now();

        System.out.println("Data de empréstimo [" + formatarDataParaPTBR(dataAtual) + "] (ENTER para manter ou digite nova data):");
        var dataEmprestimo = promptInput.nextLine();

        novoEmprestimo.setDataEmprestimo(!dataEmprestimo.isBlank()
                ? transformarEmLocalDate(dataEmprestimo) : dataAtual);

        System.out.println("Data prevista de devolução [" + formatarDataParaPTBR(dataAtual.plusDays(10)) + "] (ENTER para manter ou digite nova data):");
        var dataPrevistaDevolucao = promptInput.nextLine();

        novoEmprestimo.setDataPrevistaDevolucao(!dataPrevistaDevolucao.isBlank()
                ? transformarEmLocalDate(dataPrevistaDevolucao) : dataAtual.plusDays(10));

        System.out.println("Devolvido (S/N):");
        var devolvido = promptInput.nextLine().toUpperCase();

        // POR PADRÃO ATRIBUÍ DEVOLVIDO - FALSE
        novoEmprestimo.setDevolvido(!devolvido.isBlank() && devolvido.equals("S"));

        if (bibliotecaService.cadastrar(novoEmprestimo)) {
            System.out.println("Empréstimo cadastrado com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar empréstimo");
        }
    }

    private void consultarEmprestimos() {
        mostrarTitulo("CONSULTAR EMPRÉSTIMOS");
        if (bibliotecaService.getAutores().isEmpty()) {
            System.out.println("Nenhum empréstimo cadastrado");
        } else {
            System.out.println("ID - LIVRO - DATA EMPRÉSTIMO - DATA PREVISTA DEVOLUÇÃO - EMPRESTADO");
            for (Emprestimo emprestimo : bibliotecaService.getEmprestimos()) {
                System.out.println(emprestimo.mostrar());
            }
        }
    }

    private void alterarEmprestimo() {
        System.out.println("\nQual empréstimo deseja alterar(ID)");
        var emprestimoId = promptInput.nextLine();

        if (emprestimoId.isBlank()) {
            System.out.println("ID inválido");
            return;
        }

        var emprestimo = bibliotecaService.getEmprestimo(Integer.parseInt(emprestimoId));

        if (emprestimo.isEmpty()) {
            System.out.println("Empréstimo não localizado");
            return;
        }

        mostrarCatalogo(bibliotecaService);
        System.out.println("Livro atual: " + emprestimo.get().getLivro().getTitulo());
        System.out.println("Digite o novo livro (ou ENTER para manter):");
        var novoLivroId = promptInput.nextLine();

        if (!novoLivroId.isBlank()) {
            var novoLivro = bibliotecaService.getLivro(Integer.parseInt(novoLivroId));
            if (novoLivro.isEmpty()) {
                System.out.println("Livro não localizado");
                return;
            }
            emprestimo.get().setLivro(novoLivro.get());

            System.out.println("Novo livro atribuído : " + novoLivro.get().getTitulo());
        }

        System.out.println("Data de empréstimo atual: " + emprestimo.get().getDataEmprestimo());
        System.out.println("Digite a nova data de empréstimo dd/mm/aaaa (ou ENTER para manter):");
        var novaDataEmprestimo = promptInput.nextLine();

        if (!novaDataEmprestimo.isBlank()) {
            emprestimo.get().setDataEmprestimo(transformarEmLocalDate(novaDataEmprestimo));
        }

        System.out.println("Data prevista de devolução atual: " + emprestimo.get().getDataPrevistaDevolucao());
        System.out.println("Digite a nova data prevista de devolução dd/mm/aaaa (ou ENTER para manter):");
        var novaDataPrevistaDevolucao = promptInput.nextLine();

        if (!novaDataPrevistaDevolucao.isBlank()) {
            emprestimo.get().setDataPrevistaDevolucao(transformarEmLocalDate(novaDataPrevistaDevolucao));
        }

        System.out.println("Devolvido:" + emprestimo.get().mostraStatusEmprestimo());
        System.out.println("Digite o novo status de empréstimo (S/N) (ou ENTER para manter):");
        var novoStatusEmprestimo = promptInput.nextLine().toUpperCase();

        if (!novoStatusEmprestimo.isBlank()) {
            if (!(novoStatusEmprestimo.equals("S") || novoStatusEmprestimo.equals("N"))) {
                System.out.println("Opção inválida. Não foi possível atualizar!");
            } else {
                emprestimo.get().setDevolvido(novoStatusEmprestimo.equals("S"));
            }
        }

        if (bibliotecaService.atualizar(emprestimo.get())) {
            System.out.println("Dados autualizados com sucesso!");
        } else {
            System.out.println("Erro ao alterar os dados");
        }
    }

    private void excluirEmprestimo() {
        System.out.println("\nQual empréstimo deseja excluir(ID)?");
        var emprestimoId = promptInput.nextLine();

        if (emprestimoId.isBlank()) {
            System.out.println("ID inválido");
            return;
        }

        var emprestimo = bibliotecaService.getEmprestimo(Integer.parseInt(emprestimoId));

        if (bibliotecaService.excluir(emprestimo.get())) {
            System.out.println("Empréstimo excluído com sucesso!");
        } else {
            System.out.println("Erro ao excluir empréstimo");
        }
    }
}
