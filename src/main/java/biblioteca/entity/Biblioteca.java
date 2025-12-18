package biblioteca.entity;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class Biblioteca {
    private static Biblioteca INSTANCIA = new Biblioteca();

    private final UUID id = UUID.randomUUID();
    private final String nome = "Biblioteca Nacional";
    private final LocalDate anoCriacao = LocalDate.of(2025, 01, 01);

    private final List<Livro> livros = new ArrayList<Livro>();
    private final List<Emprestimo> emprestimos = new ArrayList<>();
    private final List<Editora> editoras = new ArrayList<>();
    private final List<Cliente> clientes = new ArrayList<Cliente>();
    private final List<Autor> autores = new ArrayList<>();


    private Biblioteca() {
    }

    public static Biblioteca getInstancia() {
        return INSTANCIA;
    }


    // LISTAGENS
    public void listarEditoras() {
        editoras.toString();
    }

    public void listarEmprestimos() {
        emprestimos.toString();
    }

    public void listarLivros() {
        livros.toString();
    }

    public void listarClientes() {
        clientes.toString();
    }

    public void listarAutores() {
        autores.toString();
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

    public void cadastrarAutor(Autor autor) {
    }

    public void cadastrarEditora(Editora editora) {
    }

    public void cadastrarEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

}


