package biblioteca.repository;

import biblioteca.entity.Editora;
import biblioteca.entity.Emprestimo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmprestimoRepository implements GenericRepository{
    private List<Emprestimo> emprestimos = new ArrayList<>();

    @Override
    public void save(Object entity) {
        emprestimos.add((Emprestimo) entity);
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
