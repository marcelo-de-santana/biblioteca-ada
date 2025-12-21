package biblioteca.gui;

public class ComponentUI {

    public static void mostrarTitulo(String texto) {
        System.out.println(centralizarTitulo(texto));
    }

    public static void mostrarMenu(String texto) {
        System.out.println(centralizarMenu(texto));
    }

    public static void mostrarMenuCrud() {
        mostrarMenu("1 - CADASTRAR | 2 - ALTERAR | 3 - EXCLUIR | 0 - VOLTAR");
        mensagemSelecioneUmaOpcao();
    }

    public static void mensagemSelecioneUmaOpcao() {
        System.out.println("\nSelecione uma opção:");
    }

    public static String centralizarTitulo(String texto) {
        var espacamento = "------------------------------------------------------------";
        var fimTexto = espacamento.length() / 2 + texto.length() / 2 + 1;

        if (texto.length() % 2 == 0) {
            return (espacamento.substring(0, espacamento.length() / 2 - texto.length() / 2 - 1)
                    + " " + texto + " " + espacamento.substring(fimTexto)).toUpperCase();
        }
        return (espacamento.substring(0, espacamento.length() / 2 - texto.length() / 2 - 2)
                + " " + texto + " " + espacamento.substring(fimTexto)).toUpperCase();
    }

    public static String centralizarMenu(String texto) {
        var espacamento = "                                                            ";
        var fimTexto = espacamento.length() / 2 + texto.length() / 2 + 1;

        if (texto.length() % 2 == 0) {
            return (espacamento.substring(0, espacamento.length() / 2 - texto.length() / 2 - 1)
                    + " " + texto + " " + espacamento.substring(fimTexto)).toUpperCase();
        }
        return (espacamento.substring(0, espacamento.length() / 2 - texto.length() / 2 - 2)
                + " " + texto + " " + espacamento.substring(fimTexto)).toUpperCase();
    }

}
