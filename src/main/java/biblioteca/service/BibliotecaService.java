package biblioteca.service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import biblioteca.entity.Autor;
import biblioteca.entity.Biblioteca;
import biblioteca.entity.Cliente;
import biblioteca.entity.Editora;
import biblioteca.entity.Livro;

public class BibliotecaService {
    private final Biblioteca biblioteca = Biblioteca.getInstancia();
    private Scanner input;

    public BibliotecaService(Scanner input) {
        this.input = new Scanner(System.in);
    }

    /**
     * TODO :
     * Criar os Prompts para cada cadastro
     */

    public boolean cadastrar(Cliente cliente) {
        System.out.println("Informe o nome do cliente: ");
        cliente.setNome(input.nextLine());
        System.out.println("Informe o email do cliente: ");
        cliente.setEmail(input.nextLine());
        System.out.println("Informe o cpf do cliente: ");
        cliente.setCpf(input.nextInt());
        return biblioteca.cadastrar(cliente);
    }

    public boolean cadastrar(Livro livro) {
        System.out.println("Digite o título do livro:");
        livro.setTitulo(input.nextLine());

        System.out.println("Digite a quantidade de páginas:");
        livro.setNumeroDePaginas(input.nextInt());

        System.out.println("Digite o ano de publicação:");
        livro.setAnoPublicacao(input.nextInt());

        livro.setEmprestado(false);

        System.out.println("Editoras");
        biblioteca.getEditoras().forEach(editora -> editora.mostrarEditora());

        System.out.println("A qual editora pertence o livro?");
        input.nextInt();
        // System.out.println(listarEditoras().toString());

        return biblioteca.cadastrar(livro);

    }

    public List<Livro> getLivros() {
        return biblioteca.getLivros();
    }

    public List<Autor> getAutores() {
        return biblioteca.getAutores();
    }

    public List<Cliente> getClientes() {
        return biblioteca.getClientes();
    }

    public List<Editora> getEditoras() {
        return biblioteca.getEditoras();
    }

    public boolean cadastrar(Editora novaEditora) {
        return biblioteca.cadastrar(novaEditora);
    }

    public boolean cadastrar(Autor autor) {
        return biblioteca.cadastrar(autor);
    }

    public List<Livro> getCatalogo() {
        return biblioteca.getLivros();
    }

    public Optional<Autor> getAutor(int autorId) {
        return biblioteca.getAutor(autorId);
    }

    public Optional<Editora> getEditora(int editoraId) {
        return biblioteca.getEditora(editoraId);
    }

    public Optional<Livro> getLivro(int livroId) {
        return biblioteca.getLivro(livroId);
    }

    public Optional<Cliente> getCliente(int clienteId) {
        return biblioteca.getCliente(clienteId);
    }

    public boolean excluir(Autor autor) {
        return biblioteca.excluir(autor);
    }

    public boolean excluir(Editora editora) {
        return biblioteca.excluir(editora);
    }

    public boolean excluir(Livro livro) {
        return biblioteca.excluir(livro);
    }

    public boolean excluir(Cliente cliente) {
        return biblioteca.excluir(cliente);
    }

    public boolean atualizar(Autor autor) {
        return biblioteca.atualizar(autor);
    }

    public boolean atualizar(Editora editora) {
        return biblioteca.atualizar(editora);
    }

    public boolean atualizar(Livro livro) {
        return biblioteca.atualizar(livro);
    }

    public boolean atualizar(Cliente cliente) {
        return biblioteca.atualizar(cliente);
    }
}
