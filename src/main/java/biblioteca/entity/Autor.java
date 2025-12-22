package biblioteca.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Autor extends Pessoa {
    private String nacionalidade;

    public String mostrar() {
        return getId() + " - " + getNome() + " - " + getNacionalidade();
    }

}