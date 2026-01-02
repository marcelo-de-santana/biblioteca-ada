package biblioteca.service;

import java.util.List;
import java.util.Optional;

import biblioteca.entity.Autor;
import biblioteca.entity.Cliente;
import biblioteca.entity.Editora;
import biblioteca.entity.Emprestimo;
import biblioteca.entity.Livro;

public class BibliotecaService {
    private final AutorService autorService;
    private final LivroService livroService;
    private final ClienteService clienteService;
    private final EditoraService editoraService;
    private final EmprestimoService emprestimoService;

    public BibliotecaService(AutorService autorService,
                             LivroService livroService,
                             ClienteService clienteService,
                             EditoraService editoraService,
                             EmprestimoService emprestimoService) {
        this.autorService = autorService;
        this.livroService = livroService;
        this.clienteService = clienteService;
        this.editoraService = editoraService;
        this.emprestimoService = emprestimoService;
    }

    public List<Livro> getLivros() {
        return livroService.listarTodos();
    }

    public List<Autor> getAutores() {
        return autorService.listarTodos();
    }

    public List<Cliente> getClientes() {
        return clienteService.listarTodos();
    }

    public List<Editora> getEditoras() {
        return editoraService.listarTodos();
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimoService.listarTodos();
    }

    public boolean livroEstaDisponivel(Livro livro) {
        return emprestimoService.livroEstaDisponivel(livro);
    }

    public boolean cadastrar(Cliente cliente) {
        try {
            return clienteService.salvar(cliente) != null;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean cadastrar(Livro livro) {
        return livroService.salvar(livro) != null;
    }

    public boolean cadastrar(Editora novaEditora) {
        return editoraService.salvar(novaEditora) != null;
    }

    public boolean cadastrar(Autor autor) {
        return autorService.salvar(autor) != null;
    }

    public boolean cadastrar(Emprestimo novoEmprestimo) {
        return emprestimoService.salvar(novoEmprestimo) != null;
    }

    public Optional<Autor> getAutor(int autorId) {
        return autorService.buscarPorId(autorId);
    }

    public Optional<Emprestimo> getEmprestimo(int emprestimoId) {
        return emprestimoService.buscarPorId(emprestimoId);
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
