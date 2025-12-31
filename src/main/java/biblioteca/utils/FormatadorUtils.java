package biblioteca.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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

    public static LocalDate transformarEmLocalDate(String data) {
        data = limparData(data);
        if (data.length() == 8) {
            try {
                return LocalDate.parse(data, DateTimeFormatter.ofPattern("ddMMyyyy"));
            } catch (DateTimeParseException e) {
                return LocalDate.now();
            }
        }
        return LocalDate.now();
    }

    public static String formatarDataParaPTBR(LocalDate data) {
        return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    private static String limparData(String data) {
        return data.replaceAll("/", "").replaceAll("\\.", "");
    }

    public static boolean validarData(String data) {
        data = limparData(data);
        if (data.length() != 8) {
            return false;
        }
        try {
            LocalDate.parse(data, DateTimeFormatter.ofPattern("ddMMyyyy"));
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
