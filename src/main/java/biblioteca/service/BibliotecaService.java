package biblioteca.service;

import java.util.List;
import java.util.Optional;

import biblioteca.entity.Autor;
import biblioteca.entity.Biblioteca;
import biblioteca.entity.Cliente;
import biblioteca.entity.Editora;
import biblioteca.entity.Emprestimo;
import biblioteca.entity.Livro;

public class BibliotecaService {
    private final Biblioteca biblioteca = Biblioteca.getInstancia();

    public BibliotecaService() {
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

    public List<Emprestimo> getEmprestimos() {
        return biblioteca.getEmprestimos();
    }

    public boolean livroEstaDisponivel(Livro livro) {
        return biblioteca.livroEstaDisponivel(livro);
    }

    public boolean cadastrar(Cliente cliente) {
        return biblioteca.cadastrar(cliente);
    }

    public boolean cadastrar(Livro livro) {return biblioteca.cadastrar(livro);}

    public boolean cadastrar(Editora novaEditora) {
        return biblioteca.cadastrar(novaEditora);
    }

    public boolean cadastrar(Autor autor) {
        return biblioteca.cadastrar(autor);
    }

    public boolean cadastrar(Emprestimo novoEmprestimo) {
        return biblioteca.cadastrar(novoEmprestimo);
    }

    public Optional<Autor> getAutor(int autorId) {
        return biblioteca.getAutor(autorId);
    }

    public Optional<Emprestimo> getEmprestimo(int emprestimoId) {
        return biblioteca.getEmprestimo(emprestimoId);
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

    public boolean excluir(Emprestimo emprestimo) {
        return biblioteca.excluir(emprestimo);
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

    public boolean atualizar(Emprestimo emprestimo) {
        return biblioteca.atualizar(emprestimo);
    }

}
