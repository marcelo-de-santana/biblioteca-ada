package biblioteca.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cliente extends Pessoa{
    private String email;
    private Integer telefone;
}
