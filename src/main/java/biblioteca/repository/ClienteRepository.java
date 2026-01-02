package biblioteca.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import biblioteca.entity.Cliente;

public class ClienteRepository {
    private List<Cliente> clientes = new ArrayList<>();
    private int proximoId = 1;

    public Cliente salvar(Cliente cliente) {
        if (cliente.getId() == 0) {
            cliente.setId(proximoId++);
            clientes.add(cliente);
        } else {
            clientes.stream()
                .filter(c -> c.getId() == cliente.getId())
                .findFirst()
                .ifPresent(c -> {
                    c.setNome(cliente.getNome());
                    c.setEmail(cliente.getEmail());
                    c.setTelefone(cliente.getTelefone());
                    c.setCpf(cliente.getCpf());
                });
        }
        return cliente;
    }

    public Optional<Cliente> buscarPorId(int id) {
        return clientes.stream().filter(c -> c.getId() == id).findFirst();
    }

    public boolean excluir(int id) {
        return clientes.removeIf(c -> c.getId() == id);
    }

    public List<Cliente> listarTodos() {
        return new ArrayList<>(clientes);
    }
}