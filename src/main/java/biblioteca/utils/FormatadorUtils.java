package biblioteca.utils;

public class FormatadorUtils {
    public static String formatarCpf(String cpf) {
        cpf = removerCaracteresCpf(cpf);
        return cpf.substring(0, 3) + "." +
                cpf.substring(3, 6) + "." +
                cpf.substring(6, 9) + "-" +
                cpf.substring(9, 11);
    }

    public static String formatarCnpj(String cnpj){
        cnpj = removerCaracteresCnpj(cnpj);
        return cnpj.substring(0, 2) + "." +
                cnpj.substring(2, 5) + "." +
                cnpj.substring(5, 8) + "/" +
                cnpj.substring(8, 12) + "-" +
                cnpj.substring(12, 14);
    }

    private static String removerCaracteresCnpj(String cnpj) {
        return cnpj.replace(".", "")
                .replace("-", "");
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
