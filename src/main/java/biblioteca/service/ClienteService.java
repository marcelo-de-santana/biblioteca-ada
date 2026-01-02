package biblioteca.service;

import java.util.List;
import java.util.Optional;

import biblioteca.entity.Cliente;
import biblioteca.repository.ClienteRepository;

public class ClienteService {
    private ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente salvar(Cliente cliente) {
        // Validação de CPF duplicado (para novos cadastros ou atualizações)
        boolean cpfExiste = repository.listarTodos().stream()
                .anyMatch(c -> c.getCpf().equals(cliente.getCpf()) && c.getId() != cliente.getId());

        if (cpfExiste) {
            throw new IllegalArgumentException("Cliente já cadastrado com este CPF");
        }
        return repository.salvar(cliente);
    }

    public Optional<Cliente> buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

    public boolean excluir(int id) {
        return repository.excluir(id);
    }

    public List<Cliente> listarTodos() {
        return repository.listarTodos();
    }
}