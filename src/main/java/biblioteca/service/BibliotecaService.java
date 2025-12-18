package biblioteca.service;

import biblioteca.entity.*;
import biblioteca.repository.*;

import javax.sound.midi.Soundbank;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.UUID;



public class BibliotecaService {

    private static final Scanner input = new Scanner(System.in);
    private final BibliotecaRepository bibliotecaRepository;
    private final AutorRepository autorRepository;
    private final AutorService autor = new AutorService();
    private final ClienteRepository clienteRepository;
    private final ClienteService cliente = new ClienteService();
    private final EditoraRepository editoraRepository;
    private final EditoraService editora = new EditoraService();
    private final EmprestimoRepository emprestimoRepository;
    private final EmprestimoService emprestimo = new EmprestimoService();

    public BibliotecaService(BibliotecaRepository bibliotecaRepository, AutorRepository autorRepository, ClienteRepository clienteRepository, EditoraRepository editoraRepository, EmprestimoRepository emprestimoRepository) {
        this.bibliotecaRepository = bibliotecaRepository;
        this.autorRepository = autorRepository;
        this.clienteRepository = clienteRepository;
        this.editoraRepository = editoraRepository;
        this.emprestimoRepository = emprestimoRepository;
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
        autorRepository.save(autor);
    }

    public void cadastrarCliente(Cliente cliente) {
        cliente.setId(UUID.randomUUID());
        System.out.println("Informe o nome do cliente: ");
        cliente.setNome(input.nextLine());
        System.out.println("Informe o email do cliente: ");
        cliente.setEmail(input.nextLine());
        System.out.println("Informe o cpf do cliente: ");
        cliente.setCpf(input.nextInt());
        clienteRepository.save(cliente);
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
        editoraRepository.save(editora);
    }

    public static void cadastrarEmprestimo(Emprestimo emprestimo) {
        emprestimo.setId(UUID.randomUUID());
        System.out.println("Informe a data do empréstimo: ");

    }

    public void listarAutor() {}


    public static void cadastrarLivro(Scanner promptInput) {
        var livro = Livro.builder().isbn(UUID.randomUUID()).build();
        System.out.println("Digite o título do livro:");
        livro.setTitulo(promptInput.nextLine());
        System.out.println("Digite a quantidade de páginas:");
        livro.setNumeroDePaginas(promptInput.nextInt());
        System.out.println("Digite o ano de publicação:");
        livro.setAnoPublicacao(promptInput.nextInt());


    }

    void adicionarLivros() {
    }

    void removerLivros() {
    }

    void listarLivros() {
    }

}
