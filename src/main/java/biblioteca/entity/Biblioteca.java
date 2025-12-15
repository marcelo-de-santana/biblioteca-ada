package biblioteca.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

public class Biblioteca {
    private UUID id = UUID.randomUUID();
    private String nome = "Biblioteca Nacional";
    private LocalDate anoCriacao = LocalDate.of(2025, 01, 01);
}
