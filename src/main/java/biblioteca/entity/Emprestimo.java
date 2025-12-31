package biblioteca.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static biblioteca.utils.FormatadorUtils.formatarDataParaPTBR;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Emprestimo {
    private int id;
    private Livro livro;
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolucao;
    private boolean devolvido;

    public String mostrar() {
        return id + " - " + livro.getTitulo() + " - " + formatarDataParaPTBR(dataEmprestimo) + " - " + formatarDataParaPTBR(dataPrevistaDevolucao) + " - " + mostraStatusEmprestimo();
    }

    public String mostraStatusEmprestimo() {
        return isDevolvido() ? "SIM" : "NÃO";
    }
}
