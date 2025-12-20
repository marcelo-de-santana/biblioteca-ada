package biblioteca.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Cliente extends Pessoa {
    private String email;
    private Integer telefone;
    private Integer cpf;

    public String mostrar() {
        return getCpf() + " - " + getNome();
    }
}
