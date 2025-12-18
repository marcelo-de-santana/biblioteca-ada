package biblioteca.service;

import biblioteca.entity.*;
import biblioteca.repository.*;

import java.util.Scanner;
import java.util.UUID;


public class BibliotecaService {
    private Biblioteca biblioteca = Biblioteca.getInstancia();
    private final Scanner input;

    public BibliotecaService(Scanner input) {
        this.input = new Scanner(System.in);
    }

    /**
     * TODO :
     * Criar os Prompts para cada cadastro
     */
    public void cadastrarAutor(Autor autor) {
        autor.setId(UUID.randomUUID());
        System.out.println("Informe o nome do autor: ");
        autor.setNome(input.nextLine());
        System.out.println("Informe a nacionalidade do autor: ");
        autor.setNacionalidade(input.nextLine());
        biblioteca.cadastrarAutor(autor);
    }

    public void cadastrarCliente(Cliente cliente) {
        cliente.setId(UUID.randomUUID());
        System.out.println("Informe o nome do cliente: ");
        cliente.setNome(input.nextLine());
        System.out.println("Informe o email do cliente: ");
        cliente.setEmail(input.nextLine());
        System.out.println("Informe o cpf do cliente: ");
        cliente.setCpf(input.nextInt());
        biblioteca.cadastrarCliente(cliente);
    }

    public void cadastrarEditora(Editora editora) {
        editora.setId(UUID.randomUUID());
        System.out.println("Informe o nome da editora: ");
        editora.setNome(input.nextLine());
        System.out.println("Informe o cnpj da editora: ");
        editora.setCnpj(input.nextLine());
        System.out.println("Informe o endereço da editora: ");
        editora.setEndereco(input.nextLine());
        System.out.println("Informe o telefone da editora");
        editora.setTelefone(input.nextLine());
        System.out.println("Informe o email da editora");
        editora.setEmail(input.nextLine());
        biblioteca.cadastrarEditora(editora);
    }

    public static void cadastrarEmprestimo(Emprestimo emprestimo) {
        emprestimo.setId(UUID.randomUUID());
        System.out.println("Informe a data do empréstimo: ");

    }

    public void listarAutor() {
    }


    public static void cadastrarLivro(Scanner promptInput) {
        var livro = Livro.builder().isbn(UUID.randomUUID()).build();
        System.out.println("Digite o título do livro:");
        livro.setTitulo(promptInput.nextLine());
        System.out.println("Digite a quantidade de páginas:");
        livro.setNumeroDePaginas(promptInput.nextInt());
        System.out.println("Digite o ano de publicação:");
        livro.setAnoPublicacao(promptInput.nextInt());


    }

    public void adicionarLivros() {
    }

    public void removerLivros() {
    }

    public void listarLivros() {
        biblioteca.listarLivros();
    }

    public void listarAutores() {
        biblioteca.listarAutores();
    }

    public void listarClientes() {
        biblioteca.listarClientes();
    }

    public void listarEditoras() {
        biblioteca.listarEditoras();
    }

    public void listarEmprestimos() {
        biblioteca.listarEmprestimos();
    }


}
