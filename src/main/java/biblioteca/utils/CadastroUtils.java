package biblioteca.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import biblioteca.entity.Autor;
import biblioteca.entity.Biblioteca;
import biblioteca.entity.Categoria;
import biblioteca.entity.Cliente;
import biblioteca.entity.Editora;
import biblioteca.entity.Emprestimo;
import biblioteca.entity.Livro;

public class CadastroUtils {
    private static final Biblioteca biblioteca = Biblioteca.getInstancia();

    public static void inicializarDados() {
        cadastrarEditoras();
        cadastrarAutores();
        cadastrarClientes();
        cadastrarLivros();
        cadastrarEmprestimos();
//        associarEmprestimosAosLivros();
    }

    public static void cadastrarEditoras() {
        biblioteca.setEditoras(new ArrayList<>(List.of(
                Editora.builder()
                        .id(0)
                        .nome("Editora Alfa")
                        .cnpj("12.345.678/0001-90")
                        .endereco("Rua das Letras, 123 - São Paulo/SP")
                        .telefone("(11) 98765-4321")
                        .email("contato@editoralfa.com")
                        .build(),
                Editora.builder()
                        .id(1)
                        .nome("Editora Beta")
                        .cnpj("98.765.432/0001-12")
                        .endereco("Av. Cultura, 456 - Rio de Janeiro/RJ")
                        .telefone("(21) 91234-5678")
                        .email("suporte@editorabeta.com")
                        .build(),
                Editora.builder()
                        .id(2)
                        .nome("Editora Gama")
                        .cnpj("11.222.333/0001-44")
                        .endereco("Praça do Saber, 789 - Belo Horizonte/MG")
                        .telefone("(31) 99876-5432")
                        .email("info@editoragama.com")
                        .build(),
                Editora.builder()
                        .id(3)
                        .nome("Editora Delta")
                        .cnpj("55.666.777/0001-88")
                        .endereco("Rua do Conhecimento, 321 - Curitiba/PR")
                        .telefone("(41) 98765-1234")
                        .email("contato@editoradelta.com")
                        .build(),
                Editora.builder()
                        .id(4)
                        .nome("Editora Épsilon")
                        .cnpj("22.333.444/0001-55")
                        .endereco("Av. Livros, 654 - Porto Alegre/RS")
                        .telefone("(51) 91234-8765")
                        .email("atendimento@editoraepsilon.com")
                        .build())));
    }

    public static void cadastrarAutores() {
        biblioteca.setAutores(new ArrayList<>(List.of(
                new Autor(1, "Machado de Assis", "Brasileiro"),
                new Autor(2, "José de Alencar", "Brasileiro"),
                new Autor(3, "Clarice Lispector", "Brasileira"),
                new Autor(4, "Graciliano Ramos", "Brasileiro"),
                new Autor(5, "Jorge Amado", "Brasileiro"),
                new Autor(6, "Monteiro Lobato", "Brasileiro"),
                new Autor(7, "Carlos Drummond de Andrade", "Brasileiro"),
                new Autor(8, "Paulo Coelho", "Brasileiro"),
                new Autor(9, "Eça de Queirós", "Português"),
                new Autor(10, "Fernando Pessoa", "Português"))));
    }

    public static void cadastrarClientes() {
        biblioteca.setClientes(new ArrayList<>(List.of(
                new Cliente(1, "João Silva", "joao.silva@email.com", "(11) 98765-4321", "123.456.789-00"),
                new Cliente(2, "Maria Oliveira", "maria.oliveira@email.com", "(21) 98765-4321", "987.654.321-00"),
                new Cliente(3, "Pedro Santos", "pedro.santos@email.com", "(31) 98765-4321", "456.789.123-00"),
                new Cliente(4, "Ana Costa", "ana.costa@email.com", "(41) 98765-4321", "789.123.456-00"),
                new Cliente(5, "Carlos Pereira", "carlos.pereira@email.com", "(51) 98765-4321", "321.654.987-00"))));
    }

    public static void cadastrarLivros() {
        biblioteca.setLivros(new ArrayList<>(List.of(
                Livro.builder().isbn(0)
                        .titulo("Memórias Póstumas de Brás Cubas")
                        .autor(biblioteca.getAutores().get(0))
                        .editora(biblioteca.getEditoras().get(0))
                        .anoPublicacao(1881)
                        .categoria(Categoria.ROMANCE)
                        .numeroDePaginas(200)
                        .build(),
                Livro.builder()
                        .isbn(1)
                        .titulo("Dom Casmurro")
                        .autor(biblioteca.getAutores().get(0))
                        .editora(biblioteca.getEditoras().get(0))
                        .anoPublicacao(1899)
                        .categoria(Categoria.ROMANCE)
                        .numeroDePaginas(464)
                        .build(),
                Livro.builder()
                        .isbn(2)
                        .titulo("Memórias Póstumas de Brás Cubas")
                        .autor(biblioteca.getAutores().get(1))
                        .editora(biblioteca.getEditoras().get(1))
                        .anoPublicacao(1881)
                        .categoria(Categoria.ROMANCE)
                        .numeroDePaginas(304)
                        .build(),
                Livro.builder()
                        .isbn(3)
                        .titulo("O Guarani")
                        .autor(biblioteca.getAutores().get(1))
                        .editora(biblioteca.getEditoras().get(1))
                        .anoPublicacao(1857)
                        .categoria(Categoria.AVENTURA)
                        .numeroDePaginas(560)
                        .build(),
                Livro.builder()
                        .isbn(4)
                        .titulo("A Hora da Estrela")
                        .autor(biblioteca.getAutores().get(2))
                        .editora(biblioteca.getEditoras().get(2))
                        .anoPublicacao(1977)
                        .categoria(Categoria.ROMANCE)
                        .numeroDePaginas(88)
                        .build(),
                Livro.builder()
                        .isbn(5)
                        .titulo("Vidas Secas")
                        .autor(biblioteca.getAutores().get(3))
                        .editora(biblioteca.getEditoras().get(3))
                        .anoPublicacao(1938)
                        .categoria(Categoria.ROMANCE)
                        .numeroDePaginas(128)
                        .build(),
                Livro.builder()
                        .isbn(6)
                        .titulo("Gabriela, Cravo e Canela")
                        .autor(biblioteca.getAutores().get(4))
                        .editora(biblioteca.getEditoras().get(4))
                        .anoPublicacao(1958)
                        .categoria(Categoria.ROMANCE)
                        .numeroDePaginas(424)
                        .build(),
                Livro.builder()
                        .isbn(7)
                        .titulo("Sítio do Picapau Amarelo")
                        .autor(biblioteca.getAutores().get(5))
                        .editora(biblioteca.getEditoras().get(0))
                        .anoPublicacao(1920)
                        .categoria(Categoria.INFANTO_JUVENIL)
                        .numeroDePaginas(360)
                        .build(),
                Livro.builder()
                        .isbn(8)
                        .titulo("Alguma Poesia")
                        .autor(biblioteca.getAutores().get(6))
                        .editora(biblioteca.getEditoras().get(1))
                        .anoPublicacao(1930)
                        .categoria(Categoria.ARTE)
                        .numeroDePaginas(120)
                        .build(),
                Livro.builder()
                        .isbn(9)
                        .titulo("O Alquimista")
                        .autor(biblioteca.getAutores().get(7))
                        .editora(biblioteca.getEditoras().get(2))
                        .anoPublicacao(1988)
                        .categoria(Categoria.FICCAO)
                        .numeroDePaginas(176)
                        .build(),
                Livro.builder()
                        .isbn(10)
                        .titulo("Os Maias")
                        .autor(biblioteca.getAutores().get(8))
                        .editora(biblioteca.getEditoras().get(3))
                        .anoPublicacao(1878)
                        .categoria(Categoria.ROMANCE)
                        .numeroDePaginas(720)
                        .build(),
                Livro.builder()
                        .isbn(11)
                        .titulo("Mensagem")
                        .autor(biblioteca.getAutores().get(9))
                        .editora(biblioteca.getEditoras().get(4))
                        .anoPublicacao(1934)
                        .categoria(Categoria.ARTE)
                        .numeroDePaginas(104)
                        .build()
        )));
    }

    public static void cadastrarEmprestimos() {
        biblioteca.setEmprestimos(new ArrayList<>(List.of(
                Emprestimo.builder()
                        .id(1)
                        .livro(biblioteca.getLivros().get(0))
                        .dataEmprestimo(LocalDate.now().minusDays(10))
                        .dataPrevistaDevolucao(LocalDate.now().plusDays(5))
                        .devolvido(false)
                        .build(),
                Emprestimo.builder()
                        .id(2)
                        .livro(biblioteca.getLivros().get(1))
                        .dataEmprestimo(LocalDate.now().minusDays(5))
                        .dataPrevistaDevolucao(LocalDate.now().plusDays(10))
                        .devolvido(false)
                        .build(),
                Emprestimo.builder()
                        .id(3)
                        .livro(biblioteca.getLivros().get(2))
                        .dataEmprestimo(LocalDate.now().minusDays(20))
                        .dataPrevistaDevolucao(LocalDate.now().minusDays(5)) // Atrasado
                        .devolvido(false)
                        .build(),
                Emprestimo.builder()
                        .id(4)
                        .livro(biblioteca.getLivros().get(3))
                        .dataEmprestimo(LocalDate.now().minusDays(2))
                        .dataPrevistaDevolucao(LocalDate.now().plusDays(12))
                        .devolvido(false)
                        .build(),
                Emprestimo.builder()
                        .id(5)
                        .livro(biblioteca.getLivros().get(4))
                        .dataEmprestimo(LocalDate.now().minusDays(15))
                        .dataPrevistaDevolucao(LocalDate.now())
                        .devolvido(false)
                        .build(),
                Emprestimo.builder()
                        .id(6)
                        .livro(biblioteca.getLivros().get(5))
                        .dataEmprestimo(LocalDate.now().minusDays(30))
                        .dataPrevistaDevolucao(LocalDate.now().minusDays(15)) // Atrasado e devolvido
                        .devolvido(true)
                        .build(),
                Emprestimo.builder()
                        .id(7)
                        .livro(biblioteca.getLivros().get(6))
                        .dataEmprestimo(LocalDate.now().minusDays(3))
                        .dataPrevistaDevolucao(LocalDate.now().plusDays(11))
                        .devolvido(false)
                        .build(),
                Emprestimo.builder()
                        .id(8)
                        .livro(biblioteca.getLivros().get(7))
                        .dataEmprestimo(LocalDate.now().minusDays(8))
                        .dataPrevistaDevolucao(LocalDate.now().plusDays(7))
                        .devolvido(false)
                        .build(),
                Emprestimo.builder()
                        .id(9)
                        .livro(biblioteca.getLivros().get(8))
                        .dataEmprestimo(LocalDate.now().minusDays(1))
                        .dataPrevistaDevolucao(LocalDate.now().plusDays(14))
                        .devolvido(false)
                        .build(),
                Emprestimo.builder()
                        .id(10)
                        .livro(biblioteca.getLivros().get(9))
                        .dataEmprestimo(LocalDate.now().minusDays(12))
                        .dataPrevistaDevolucao(LocalDate.now().plusDays(2))
                        .devolvido(true)
                        .build()
        )));
    }

//    public static void associarEmprestimosAosLivros() {
//        for (Livro livro : biblioteca.getLivros()) {
//            for (Emprestimo emprestimo : biblioteca.getEmprestimos()) {
//                if (emprestimo.getLivro().getIsbn() == livro.getIsbn()) {
//                    livro.setEmprestimo(emprestimo);
//                }
//            }
//        }
//    }
}

