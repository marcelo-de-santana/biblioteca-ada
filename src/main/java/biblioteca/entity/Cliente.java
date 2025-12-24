package biblioteca.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Cliente extends Pessoa {
    private String cpf;
    private String email;
    private String telefone;

    public Cliente() {
        super();
    }

    public Cliente(int id, String nome, String email, String telefone, String cpf) {
        super();
        this.setId(id);
        this.setNome(nome);
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public String mostrar() {
        return getId() + " - " + getNome() + " - " + getCpf() + " - "
                + getEmail() + " - " + getTelefone();
    }
}
