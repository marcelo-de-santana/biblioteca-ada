package biblioteca.ui;

import static biblioteca.ui.ComponentUI.*;
import static biblioteca.utils.FormatadorUtils.*;

import java.util.Scanner;

import biblioteca.entity.Cliente;
import biblioteca.service.BibliotecaService;
import biblioteca.utils.FormatadorUtils;

public class ClienteUI {
    private final BibliotecaService bibliotecaService;
    private final Scanner promptInput;

    public ClienteUI(BibliotecaService bibliotecaService, Scanner promptInput) {
        this.bibliotecaService = bibliotecaService;
        this.promptInput = promptInput;

    }

    public void iniciarUi() {
        while (true) {
            consultarClientes(bibliotecaService);
            mostrarMenuCrud();

            switch (promptInput.nextLine()) {
                case "1" -> cadastrarCliente();
                case "2" -> alterarCliente();
                case "3" -> excluirCliente();
                case "0" -> { return; }
                default -> System.out.println("Opção inválida");
            }
        }
    }

    public static void consultarClientes(BibliotecaService bibliotecaService) {
        mostrarTitulo("CLIENTES");
        if (bibliotecaService.getClientes().isEmpty()) {
            mostrarMenu("Nenhum cliente cadastrado");
        } else {
            System.out.println("ID - NOME - CPF - EMAIL - TELEFONE");
            for (Cliente cliente : bibliotecaService.getClientes()) {
                System.out.println(cliente.mostrar());
            }
        }
    }

    private void cadastrarCliente() {
        mostrarTitulo("CADASTRANDO UM CLIENTE");
        var novoCliente = new Cliente();

        System.out.println("Nome:");
        novoCliente.setNome(promptInput.nextLine());

        System.out.println("CPF:");
        novoCliente.setCpf(formatarCpf(validarTamanhoCpf(promptInput.nextLine())));

        System.out.println("E-mail:");
        novoCliente.setEmail(promptInput.nextLine());

        System.out.println("Telefone(DDD 99999-9999):");
        novoCliente.setTelefone(formatarTelefone(validarTamanhoTelefone(promptInput.nextLine())));

        if (bibliotecaService.cadastrar((Cliente) novoCliente)) {
            System.out.println("Cliente cadastrado com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar cliente");
        }
    }

    private void alterarCliente() {
        System.out.println("\nQual cliente deseja alterar(ID)?");
        var clienteId = promptInput.nextLine();

        if (clienteId.isBlank()) {
            System.out.println("ID inválido");
            return;
        }

        var cliente = bibliotecaService.getCliente(Integer.parseInt(clienteId));

        if (cliente.isEmpty()) {
            System.out.println("Cliente não encontrado");
            return;
        }

        System.out.println("Nome atual: " + cliente.get().getNome());
        System.out.println("Digite o novo nome (ou ENTER para manter):");
        var novoNome = promptInput.nextLine();

        if (!novoNome.isBlank()) {
            cliente.get().setNome(novoNome);
        }

        System.out.println("CPF atual: " + cliente.get().getCpf());
        System.out.println("Novo CPF (ou ENTER para manter):");
        var novoCpf = promptInput.nextLine();

        if (!novoCpf.isBlank()) {
            cliente.get().setCpf(FormatadorUtils.formatarCpf(validarTamanhoCpf(novoCpf)));
        }

        System.out.println("E-mail atual: " + cliente.get().getEmail());
        System.out.println("Novo e-mail (ou ENTER para manter):");
        var novoEmail = promptInput.nextLine();

        if (!novoEmail.isBlank()) {
            cliente.get().setEmail(novoEmail);
        }

        System.out.println("Telefone atual: " + cliente.get().getTelefone());
        System.out.println("Novo telefone (ou ENTER para manter):");
        var novoTelefone = promptInput.nextLine();

        if (!novoTelefone.isBlank()) {
            cliente.get().setTelefone(formatarTelefone(validarTamanhoTelefone(novoTelefone)));
        }

        if (bibliotecaService.atualizar(cliente.get())) {
            System.out.println("Cliente alterado com sucesso!");
        } else {
            System.out.println("Erro ao alterar os dados");
        }
    }

    private void excluirCliente() {
        consultarClientes(bibliotecaService);

        System.out.println("\nQual cliente deseja excluir(ID)?");
        var clienteId = promptInput.nextLine();

        if (clienteId.isBlank()) {
            System.out.println("ID inválido");
            return;
        }

        var cliente = bibliotecaService.getCliente(Integer.parseInt(clienteId));

        if (bibliotecaService.excluir(cliente.get())) {
            System.out.println("Cliente excluído com sucesso!");
        } else {
            System.out.println("Erro ao excluir cliente");
        }
    }

    private String validarTamanhoCpf(String cpf) {
        while (cpf.length() != 11) {
            String motivo = cpf.length() < 11 ? "menor" : "maior";
            System.out.println("Quantidade de dígitos " + motivo
                    + " que o necessário. Digite exatamente 11 dígitos. Tente novamente:");
            cpf = promptInput.nextLine();
        }
        return cpf;
    }

    private String validarTamanhoTelefone(String telefone) {
        while (telefone.length() != 11) {
            String motivo = telefone.length() < 11 ? "menor" : "maior";
            System.out.println("Quantidade de dígitos " + motivo
                    + " que o necessário. Digite exatamente 11 dígitos. Tente novamente:");
            telefone = promptInput.nextLine();
        }
        return telefone;
    }
}
