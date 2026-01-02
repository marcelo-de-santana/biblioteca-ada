package biblioteca.service;

import java.util.List;
import java.util.Optional;

import biblioteca.entity.Emprestimo;
import biblioteca.entity.Livro;
import biblioteca.repository.EmprestimoRepository;

public class EmprestimoService {
    private EmprestimoRepository repository;

    public EmprestimoService(EmprestimoRepository repository) {
        this.repository = repository;
    }

    public Emprestimo salvar(Emprestimo emprestimo) {
        return repository.salvar(emprestimo);
    }

    public Optional<Emprestimo> buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

    public boolean excluir(int id) {
        return repository.excluir(id);
    }

    public boolean livroEstaDisponivel(Livro livro) {
        return repository.listarTodos().stream()
                .noneMatch(emprestimo -> emprestimo.getLivro().equals(livro) && !emprestimo.isDevolvido());
    }

    public List<Emprestimo> listarTodos() {
        return repository.listarTodos();
    }
}