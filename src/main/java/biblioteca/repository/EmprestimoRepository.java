package biblioteca.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import biblioteca.entity.Emprestimo;

public class EmprestimoRepository {
    private List<Emprestimo> emprestimos = new ArrayList<>();
    private int proximoId = 1;

    public Emprestimo salvar(Emprestimo emprestimo) {
        if (emprestimo.getId() == 0) {
            emprestimo.setId(proximoId++);
            emprestimos.add(emprestimo);
        } else {
            emprestimos.stream()
                .filter(e -> e.getId() == emprestimo.getId())
                .findFirst()
                .ifPresent(e -> {
                    e.setLivro(emprestimo.getLivro());
                    e.setDataEmprestimo(emprestimo.getDataEmprestimo());
                    e.setDataPrevistaDevolucao(emprestimo.getDataPrevistaDevolucao());
                    e.setDevolvido(emprestimo.isDevolvido());
                });
        }
        return emprestimo;
    }

    public Optional<Emprestimo> buscarPorId(int id) {
        return emprestimos.stream().filter(e -> e.getId() == id).findFirst();
    }

    public boolean excluir(int id) {
        return emprestimos.removeIf(e -> e.getId() == id);
    }

    public List<Emprestimo> listarTodos() {
        return new ArrayList<>(emprestimos);
    }
}
