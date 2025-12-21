package biblioteca.entity;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Emprestimo {
    private int id;
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolucao;
    private boolean emprestado;
}
