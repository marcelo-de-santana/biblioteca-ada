package biblioteca.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class Autor extends Pessoa {
    private String nacionalidade;

}