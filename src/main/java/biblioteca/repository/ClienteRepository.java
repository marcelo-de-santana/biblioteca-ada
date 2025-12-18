package biblioteca.repository;

import biblioteca.entity.Autor;
import biblioteca.entity.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteRepository implements GenericRepository{
    private List<Cliente> clientes = new ArrayList<>();

    @Override
    public void save(Object entity) {
        clientes.add((Cliente) (entity));
    }

    @Override
    public Optional listarPeloId(Object o) {
        return Optional.empty();
    }

    @Override
    public List listarTodos() {
        return List.of();
    }

    @Override
    public void excluirPeloId(Object o) {

    }
}
