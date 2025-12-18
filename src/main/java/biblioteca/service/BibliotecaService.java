package biblioteca.service;

import biblioteca.entity.Autor;
import biblioteca.entity.Cliente;
import biblioteca.entity.Livro;
import biblioteca.repository.AutorRepository;
import biblioteca.repository.BibliotecaRepository;
import biblioteca.repository.ClienteRepository;
import biblioteca.repository.EditoraRepository;

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

    public BibliotecaService(BibliotecaRepository bibliotecaRepository, AutorRepository autorRepository, ClienteRepository clienteRepository, EditoraRepository editoraRepository) {
        this.bibliotecaRepository = bibliotecaRepository;
        this.autorRepository = autorRepository;
        this.clienteRepository = clienteRepository;
        this.editoraRepository = editoraRepository;
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

    public void cadastrarEditora() {
        editora.setId(UUID.randomUUID());
        System.out.println("Informe o nome do editora: ");
        editora.setNome(input.nextLine());
        System.out.println("Informe o email do editora: ");
        editora.setEmail(input.nextLine());
        System.out.println("Informe o cpf do editora: ");
        editora.setCpf(input.nextInt());
        editoraRepository.save(editora);
    }

    public static void cadastrarEmprestimo() {
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
