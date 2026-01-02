package biblioteca.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import biblioteca.entity.Editora;

public class EditoraRepository {
    private List<Editora> editoras = new ArrayList<>();
    private int proximoId = 1;

    public Editora salvar(Editora editora) {
        if (editora.getId() == 0) {
            editora.setId(proximoId++);
            editoras.add(editora);
        } else {
            editoras.stream()
                .filter(e -> e.getId() == editora.getId())
                .findFirst()
                .ifPresent(e -> {
                    e.setNome(editora.getNome());
                    e.setCnpj(editora.getCnpj());
                    e.setEndereco(editora.getEndereco());
                    e.setTelefone(editora.getTelefone());
                    e.setEmail(editora.getEmail());
                });
        }
        return editora;
    }

    public Optional<Editora> buscarPorId(int id) {
        return editoras.stream().filter(e -> e.getId() == id).findFirst();
    }

    public boolean excluir(int id) {
        return editoras.removeIf(e -> e.getId() == id);
    }

    public List<Editora> listarTodos() {
        return new ArrayList<>(editoras);
    }
}