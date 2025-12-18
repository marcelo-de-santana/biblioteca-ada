package biblioteca.service;

import biblioteca.entity.Cliente;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class ClienteService {
    List<Cliente> listarClientes() {
        return new ArrayList<>();
    }
}
