package biblioteca.entity;

import java.time.LocalDate;
import java.util.UUID;

public class Emprestimo {
    private UUID id;
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolucao;
    private boolean emprestado;

}
