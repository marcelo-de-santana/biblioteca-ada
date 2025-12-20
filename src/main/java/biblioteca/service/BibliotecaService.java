package biblioteca.service;

import biblioteca.entity.*;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;


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


    public void cadastrarCliente(Cliente cliente) {
        System.out.println("Informe o nome do cliente: ");
        cliente.setNome(input.nextLine());
        System.out.println("Informe o email do cliente: ");
        cliente.setEmail(input.nextLine());
        System.out.println("Informe o cpf do cliente: ");
        cliente.setCpf(input.nextInt());
        biblioteca.cadastrarCliente(cliente);
    }

    public void cadastrarLivro() {
        var livro = Livro.builder().build();
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
//        System.out.println(listarEditoras().toString());

        biblioteca.cadastrar(livro);

    }

    public void adicionarLivros() {
    }

    public void removerLivros() {
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

    public void cadastrar(Editora novaEditora) {
        biblioteca.cadastrar(novaEditora);
    }

    public void cadastrar(Autor autor) {
        biblioteca.cadastrar(autor);
    }

    public List<Livro> getCatalogo() {
        return biblioteca.getLivros();
    }

    public Optional<Autor> getAutor(int autorId) {
        return biblioteca.getAutor(autorId);
    }
}
