package biblioteca.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Cliente extends Pessoa {
    private String cpf;
    private String email;
    private String telefone;

    public String mostrar() {
        return getId() + " - " + getNome() + " - " + getCpf() + " - "
                + getEmail() + " - " + getTelefone();
    }
}
