package biblioteca.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.Data;

@Data
public class Biblioteca {
    private static Biblioteca INSTANCIA = new Biblioteca();

    private final String nome = "Biblioteca Nacional";
    private final LocalDate anoCriacao = LocalDate.of(2025, 01, 01);

    private List<Livro> livros = new ArrayList<Livro>();
    private List<Emprestimo> emprestimos = new ArrayList<>();
    private List<Editora> editoras = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<Cliente>();
    private List<Autor> autores = new ArrayList<>();

    private Biblioteca() {
    }

    public static Biblioteca getInstancia() {
        return INSTANCIA;
    }

    public boolean cadastrar(Cliente novoCliente) {
        int id = clientes.isEmpty() ? 0
                : clientes.stream()
                .mapToInt(Cliente::getId).max().getAsInt() + 1;

        novoCliente.setId(id);

        var clienteJaCadastrado = clientes.stream()
                .anyMatch(clienteCadastrado -> clienteCadastrado.getCpf()
                        .equals(novoCliente.getCpf()));

        if (clienteJaCadastrado) {
            System.out.println("Cliente já cadastrado");
            return false;
        } else
            return clientes.add(novoCliente);
    }

    public boolean cadastrar(Autor novoAutor) {
        int id = autores.isEmpty() ? 0
                : autores.stream()
                .mapToInt(Autor::getId).max().getAsInt() + 1;

        novoAutor.setId(id);
        return autores.add(novoAutor);
    }

    public boolean cadastrar(Editora editora) {
        int maiorIsbn = editoras.isEmpty() ? 0
                : editoras.stream()
                .mapToInt(Editora::getId)
                .max()
                .getAsInt() + 1;

        editora.setId(maiorIsbn);
        return editoras.add(editora);
    }

    public boolean cadastrar(Emprestimo emprestimo) {
        int id = emprestimos.isEmpty() ? 0
                : emprestimos.stream()
                .mapToInt(Emprestimo::getId).max().getAsInt() + 1;

        emprestimo.setId(id);
        return emprestimos.add(emprestimo);
    }

    public boolean cadastrar(Livro livro) {
        int maiorIsbn = livros.stream()
                .mapToInt(Livro::getIsbn)
                .max()
                .orElse(0);

        livro.setIsbn(maiorIsbn == 0 ? maiorIsbn : maiorIsbn + 1);
        return livros.add(livro);
    }

    public Optional<Autor> getAutor(int autorId) {
        return this.autores.stream()
                .filter(autor -> autor.getId() == autorId).findFirst();
    }

    public Optional<Editora> getEditora(int editoraId) {
        return this.editoras.stream()
                .filter(editora -> editora.getId() == editoraId).findFirst();
    }

    public Optional<Livro> getLivro(int livroId) {
        return this.livros.stream()
                .filter(livro -> livro.getIsbn() == livroId).findFirst();
    }

    public Optional<Cliente> getCliente(int clienteId) {
        return this.clientes.stream()
                .filter(cliente -> cliente.getId() == clienteId).findFirst();
    }

    public boolean excluir(Autor autor) {
        var excluido = this.autores.remove(autor);

        if (excluido) {
            autores.forEach(a -> {
                if (a.getId() > autor.getId()) {
                    a.setId(a.getId() - 1);
                }
            });
        }
        return excluido;

    }

    public boolean excluir(Editora editora) {
        var excluido = this.editoras.remove(editora);

        if (excluido) {
            autores.forEach(e -> {
                if (e.getId() > editora.getId()) {
                    e.setId(e.getId() - 1);
                }
            });
        }
        return excluido;
    }

    public boolean excluir(Livro livro) {
        var excluido = this.livros.remove(livro);

        if (excluido) {
            livros.forEach(l -> {
                if (l.getIsbn() > livro.getIsbn()) {
                    l.setIsbn(l.getIsbn() - 1);
                }
            });
        }
        return excluido;
    }

    public boolean excluir(Cliente cliente) {
        var excluido = this.clientes.remove(cliente);

        if (excluido) {
            clientes.forEach(c -> {
                if (c.getId() > cliente.getId()) {
                    c.setId(c.getId() - 1);
                }
            });
        }
        return excluido;
    }

    public boolean atualizar(Autor autor) {
        return this.autores.stream()
                .filter(a -> a.getId() == autor.getId())
                .findFirst()
                .map(autorEncontrado -> {
                    autorEncontrado.setNome(autor.getNome());
                    autorEncontrado.setNacionalidade(autor.getNacionalidade());
                    return true;
                })
                .orElse(false);
    }

    public boolean atualizar(Editora editora) {
        return this.editoras.stream()
                .filter(e -> e.getId() == editora.getId())
                .findFirst()
                .map(editoraEncontrada -> {
                    editoraEncontrada.setNome(editora.getNome());
                    editoraEncontrada.setCnpj(editora.getCnpj());
                    editoraEncontrada.setEndereco(editora.getEndereco());
                    editoraEncontrada.setTelefone(editora.getTelefone());
                    editoraEncontrada.setEmail(editora.getEmail());
                    return true;
                })
                .orElse(false);
    }

    public boolean atualizar(Livro livro) {
        return this.livros.stream()
                .filter(l -> l.getIsbn() == livro.getIsbn())
                .findFirst()
                .map(livroEncontrado -> {
                    livroEncontrado.setNome(livro.getNome());
                    livroEncontrado.setAutor(livro.getAutor());
                    livroEncontrado.setEditora(livro.getEditora());
                    livroEncontrado.setAnoPublicacao(livro.getAnoPublicacao());
                    livroEncontrado.setNumeroDePaginas(livro.getNumeroDePaginas());
                    return true;
                })
                .orElse(false);
    }

    public boolean atualizar(Cliente cliente) {
        return this.clientes.stream()
                .filter(c -> c.getId() == cliente.getId())
                .findFirst()
                .map(clienteEncontrado -> {
                    clienteEncontrado.setNome(cliente.getNome());
                    clienteEncontrado.setEmail(cliente.getEmail());
                    clienteEncontrado.setTelefone(cliente.getTelefone());
                    clienteEncontrado.setCpf(cliente.getCpf());
                    return true;
                })
                .orElse(false);
    }

}
