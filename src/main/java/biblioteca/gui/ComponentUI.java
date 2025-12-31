package biblioteca.gui;

import biblioteca.service.BibliotecaService;

public class ComponentUI {

    private static final int LARGURA_MAXIMA = 80;
    private static final String LINHA_SEPARADORA = "-".repeat(LARGURA_MAXIMA);
    private static final String ESPACO_VAZIO = " ".repeat(LARGURA_MAXIMA);

    public static void mostrarTitulo(String texto) {
        pularLinha();
        System.out.println(centralizarTexto(texto, LINHA_SEPARADORA));
    }

    public static void mostrarMenu(String texto) {
        pularLinha();
        System.out.println(centralizarTexto(texto, ESPACO_VAZIO));
    }

    public static void mostrarMenuCrud() {
        mostrarMenu("1 - CADASTRAR | 2 - ALTERAR | 3 - EXCLUIR | 0 - VOLTAR");
        mensagemSelecioneUmaOpcao();
    }

    public static void mensagemSelecioneUmaOpcao() {
        System.out.println("\nSelecione uma opção:");
    }

    private static void pularLinha() {
        System.out.println();
    }

    private static String centralizarTexto(String texto, String base) {
        if (texto == null || texto.length() >= LARGURA_MAXIMA) {
            return texto != null ? texto.toUpperCase() : "";
        }

        int espacoLivre = LARGURA_MAXIMA - texto.length();
        int margemEsquerda = espacoLivre / 2;
        int margemDireita = espacoLivre - margemEsquerda;

        // Garante que haja pelo menos um espaço em branco ao redor do texto se a base for traços
        if (base.contains("-")) {
            return (base.substring(0, margemEsquerda - 1) + " " + texto + " " + base.substring(0, margemDireita - 1)).toUpperCase();
        } else {
            return (base.substring(0, margemEsquerda) + texto + base.substring(0, margemDireita)).toUpperCase();
        }
    }

    public static void mostrarCatalogo(BibliotecaService bibliotecaService) {
        if (bibliotecaService.getCatalogo().isEmpty())
            System.out.println("Biblioteca Vazia");
        else {
            mostrarTitulo("CATÁLOGO");
            System.out.println("ISBN - TÍTULO - AUTOR - EDITORA - ANO - CATEGORIA - NÚMERO DE PÁGINAS");
            bibliotecaService.getCatalogo().forEach(livro -> System.out.println(livro.mostrar()));
        }
    }
}
