package biblioteca.entity;

import lombok.Builder;
import lombok.Data;

import java.util.*;

@Data
@Builder
public class Editora {
    private UUID id;
    private String nome;
    private String cnpj;
    private String endereco;
    private String telefone;
    private String email;

}
