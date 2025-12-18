package biblioteca.entity;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class Pessoa {
    private UUID id;
    private String nome;
}
