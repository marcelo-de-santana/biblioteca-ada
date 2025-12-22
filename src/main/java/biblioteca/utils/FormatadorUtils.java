package biblioteca.utils;

public class FormatadorUtils {
    public static String formatarCpf(String cpf) {
        cpf = removerCaracteresCpf(cpf);
        return cpf.substring(0, 3) + "." +
                cpf.substring(3, 6) + "." +
                cpf.substring(6, 9) + "-" +
                cpf.substring(9, 11);
    }

    private static String removerCaracteresCpf(String cpf) {
        return cpf.replace(".", "")
                .replace("-", "");
    }

    private static String removerCaracteresDoTelefone(String telefone) {
        return telefone
                .replace("-", "")
                .replace(" ", "")
                .replace("(", "")
                .replace(")", "");
    }

    public static String formatarTelefone(String telefone) {
        telefone = removerCaracteresDoTelefone(telefone);
        return "(" + telefone.substring(0, 2) + ") " +
                telefone.substring(2, 7) + "-" +
                telefone.substring(7, 11);
    }
}
