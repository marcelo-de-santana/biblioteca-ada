package biblioteca.entity;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
public class Biblioteca {
    private static Biblioteca INSTANCIA = new Biblioteca();

    private final String nome = "Biblioteca Nacional";
    private final LocalDate anoCriacao = LocalDate.of(2025, 01, 01);

    private final List<Livro> livros = new ArrayList<Livro>();
    private final List<Emprestimo> emprestimos = new ArrayList<>();
    private List<Editora> editoras = new ArrayList<>();
    private final List<Cliente> clientes = new ArrayList<Cliente>();
    private final List<Autor> autores = new ArrayList<>();


    private Biblioteca() {
    }

    public static Biblioteca getInstancia() {
        return INSTANCIA;
    }

    // CADASTROS
    public void cadastrarCliente(Cliente novoCliente) {
        var clienteJaCadastrado = clientes.stream().anyMatch(clienteCadastrado ->
                clienteCadastrado.getCpf().equals(novoCliente.getCpf()));

        if (clienteJaCadastrado)
            System.out.println("Cliente já cadastrado");
        else
            clientes.add(novoCliente);
    }

    public void cadastrar(Autor novoAutor) {
        int id = autores.isEmpty() ? 0 : autores.stream()
                .mapToInt(Pessoa::getId).max().getAsInt() + 1;

        novoAutor.setId(id);
        autores.add(novoAutor);
    }

    public void cadastrar(Editora editora) {
        int maiorIsbn = editoras.isEmpty() ? 0 : editoras.stream()
                .mapToInt(Editora::getId)
                .max()
                .getAsInt() + 1;

        editora.setId(maiorIsbn);
        editoras.add(editora);
    }

    public void cadastrarEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public void cadastrar(Livro livro) {
        int maiorIsbn = livros.stream()
                .mapToInt(Livro::getIsbn)
                .max()
                .orElse(0);

        livro.setIsbn(maiorIsbn == 0 ? maiorIsbn : maiorIsbn + 1);
        livros.add(livro);
    }

    public Optional<Autor> getAutor(int autorId) {
        return this.autores.stream()
                .filter(autor -> autor.getId() == autorId).findFirst();
    }
}


