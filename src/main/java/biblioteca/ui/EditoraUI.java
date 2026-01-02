package biblioteca.ui;

import static biblioteca.ui.ComponentUI.*;

import java.util.Scanner;

import biblioteca.entity.Editora;
import biblioteca.service.BibliotecaService;
import biblioteca.utils.FormatadorUtils;
import lombok.Data;

@Data
public class EditoraUI {
    private final BibliotecaService bibliotecaService;
    private final Scanner promptInput;

    public EditoraUI(BibliotecaService bibliotecaService, Scanner promptInput) {
        this.bibliotecaService = bibliotecaService;
        this.promptInput = promptInput;
    }

    public void iniciarUi() {
        while (true) {
            consultarEditoras(bibliotecaService);
            mostrarMenuCrud();

            switch (promptInput.nextLine()) {
                case "1" -> cadastrarEditora(bibliotecaService, promptInput);
                case "2" -> alterarEditora();
                case "3" -> excluirEditora();
                case "0" -> { return; }
                default -> System.out.println("Opção inválida");
            }
        }
    }

    public static void consultarEditoras(BibliotecaService bibliotecaService) {
        mostrarTitulo("EDITORAS");
        if (bibliotecaService.getEditoras().isEmpty()) {
            mostrarMenu("Nenhuma editora cadastrada");
        } else {
            System.out.println("ID - NOME - CNPJ - ENDEREÇO - TELEFONE - EMAIL");
            for (Editora editora : bibliotecaService.getEditoras()) {
                System.out.println(editora.mostrar());
            }
        }
    }

    public static void cadastrarEditora(BibliotecaService bibliotecaService, Scanner promptInput) {
        var novaEditora = new Editora();

        mostrarTitulo("CADASTRANDO UMA EDITORA");

        System.out.println("Nome:");
        novaEditora.setNome(promptInput.nextLine());

        System.out.println("CNPJ:");
        novaEditora.setCnpj(FormatadorUtils.formatarCnpj(validarTamanhoCnpj(promptInput.nextLine(), promptInput)));

        System.out.println("Endereço:");
        novaEditora.setEndereco(promptInput.nextLine());

        System.out.println("Telefone:");
        var tel = validarTamanhoTelefone(promptInput.nextLine(), promptInput);
        novaEditora.setTelefone(FormatadorUtils.formatarTelefone(tel));

        System.out.println("E-mail");
        novaEditora.setEmail(promptInput.nextLine());

        if (bibliotecaService.cadastrar(novaEditora)) {
            System.out.println("Editora cadastrada com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar editora");
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
            editora.get().setCnpj(FormatadorUtils.formatarCnpj(validarTamanhoCnpj(novoCnpj, promptInput)));
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

    private static String validarTamanhoCnpj(String cnpj, Scanner promptInput) {
        while (cnpj.length() != 14) {
            String motivo = cnpj.length() < 14 ? "menor" : "maior";
            System.out.println("Quantidade de dígitos " + motivo
                    + " que o necessário. Digite exatamente 14 dígitos. Tente novamente:");
            cnpj = promptInput.nextLine();
        }
        return cnpj;
    }

    private static String validarTamanhoTelefone(String telefone, Scanner promptInput) {
        while (telefone.length() != 11) {
            String motivo = telefone.length() < 11 ? "menor" : "maior";
            System.out.println("Quantidade de dígitos " + motivo
                    + " que o necessário. Digite exatamente 11 dígitos. Tente novamente:");
            telefone = promptInput.nextLine();
        }
        return telefone;
    }
}