package biblioteca.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

public class Autor extends Pessoa {
    private String nacionalidade;
    private LocalDate dataNascimento;

}