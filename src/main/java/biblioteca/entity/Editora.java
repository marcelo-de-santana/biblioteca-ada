package biblioteca.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Editora {
    private int id;
    private String nome;
    private String cnpj;
    private String endereco;
    private String telefone;
    private String email;

    public String mostrarEditora() {
        return id + " - " + nome;
    }

    public String mostrar() {
        return id + " - " + nome + " - " + cnpj + " - " + endereco + " - "
                + telefone + " - " + email;
    }
}
