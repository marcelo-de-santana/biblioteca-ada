package biblioteca.entity;

import java.util.Optional;

import biblioteca.repository.AutorRepository;
import biblioteca.repository.ClienteRepository;
import biblioteca.repository.EditoraRepository;
import biblioteca.repository.EmprestimoRepository;
import biblioteca.repository.LivroRepository;
import biblioteca.service.AutorService;
import biblioteca.service.ClienteService;
import biblioteca.service.EditoraService;
import biblioteca.service.EmprestimoService;
import biblioteca.service.LivroService;
import lombok.Data;

@Data
public class Biblioteca {
    private static Biblioteca INSTANCIA = new Biblioteca();
    
    // Injeção de Dependência dos Serviços
    private AutorService autorService = new AutorService(new AutorRepository());
    private LivroService livroService = new LivroService(new LivroRepository());
    private ClienteService clienteService = new ClienteService(new ClienteRepository());
    private EditoraService editoraService = new EditoraService(new EditoraRepository());
    private EmprestimoService emprestimoService = new EmprestimoService(new EmprestimoRepository());

    private Biblioteca() {
    }

    public static Biblioteca getInstancia() {
        return INSTANCIA;
    }

    public boolean cadastrar(Cliente novoCliente) {
        try {
            return clienteService.salvar(novoCliente) != null;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean cadastrar(Autor novoAutor) {
        return autorService.salvar(novoAutor) != null;
    }

    public boolean cadastrar(Editora editora) {
        return editoraService.salvar(editora) != null;
    }

    public boolean cadastrar(Emprestimo emprestimo) {
        return emprestimoService.salvar(emprestimo) != null;
    }

    public boolean cadastrar(Livro livro) {
        return livroService.salvar(livro) != null;
    }

    public Optional<Autor> getAutor(int autorId) {
        return autorService.buscarPorId(autorId);
    }

    public Optional<Editora> getEditora(int editoraId) {
        return editoraService.buscarPorId(editoraId);
    }

    public Optional<Livro> getLivro(int livroId) {
        return livroService.buscarPorIsbn(livroId);
    }

    public Optional<Cliente> getCliente(int clienteId) {
        return clienteService.buscarPorId(clienteId);
    }

    public Optional<Emprestimo> getEmprestimo(int emprestimoId) {
        return emprestimoService.buscarPorId(emprestimoId);
    }

    public boolean livroEstaDisponivel(Livro livro) {
        return emprestimoService.livroEstaDisponivel(livro);
    }

    public boolean excluir(Autor autor) {
        return autorService.excluir(autor.getId());
    }

    public boolean excluir(Editora editora) {
        return editoraService.excluir(editora.getId());
    }

    public boolean excluir(Livro livro) {
        return livroService.excluir(livro.getIsbn());
    }

    public boolean excluir(Cliente cliente) {
        return clienteService.excluir(cliente.getId());
    }

    public boolean excluir(Emprestimo emprestimo) {
        return emprestimoService.excluir(emprestimo.getId());
    }

    public boolean atualizar(Autor autor) {
        return autorService.salvar(autor) != null;
    }

    public boolean atualizar(Editora editora) {
        return editoraService.salvar(editora) != null;
    }

    public boolean atualizar(Livro livro) {
        return livroService.salvar(livro) != null;
    }

    public boolean atualizar(Cliente cliente) {
        try {
            return clienteService.salvar(cliente) != null;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean atualizar(Emprestimo emprestimo) {
        return emprestimoService.salvar(emprestimo) != null;
    }
}
