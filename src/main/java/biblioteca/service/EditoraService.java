package biblioteca.service;

import biblioteca.entity.Editora;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class EditoraService {
    List<Editora> listarEditora() {
        return new ArrayList<>();
    }

}
