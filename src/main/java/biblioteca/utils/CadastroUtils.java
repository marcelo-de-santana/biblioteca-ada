package biblioteca.utils;

import java.time.LocalDate;
import java.util.List;

import biblioteca.entity.Autor;
import biblioteca.entity.Categoria;
import biblioteca.entity.Cliente;
import biblioteca.entity.Editora;
import biblioteca.entity.Emprestimo;
import biblioteca.entity.Livro;
import biblioteca.service.BibliotecaService;

public class CadastroUtils {
        private final BibliotecaService bibliotecaService;

        public CadastroUtils(BibliotecaService bibliotecaService) {
                this.bibliotecaService = bibliotecaService;
        }

        public void inicializarDados() {
                cadastrarEditoras();
                cadastrarAutores();
                cadastrarClientes();
                cadastrarLivros();
                cadastrarEmprestimos();
        }

        public void cadastrarEditoras() {
                List.of(
                                Editora.builder()
                                                .id(0)
                                                .nome("Editora Alfa")
                                                .cnpj("12.345.678/0001-90")
                                                .endereco("Rua das Letras, 123 - São Paulo/SP")
                                                .telefone("(11) 98765-4321")
                                                .email("contato@editoralfa.com")
                                                .build(),
                                Editora.builder()
                                                .id(0)
                                                .nome("Editora Beta")
                                                .cnpj("98.765.432/0001-12")
                                                .endereco("Av. Cultura, 456 - Rio de Janeiro/RJ")
                                                .telefone("(21) 91234-5678")
                                                .email("suporte@editorabeta.com")
                                                .build(),
                                Editora.builder()
                                                .id(0)
                                                .nome("Editora Gama")
                                                .cnpj("11.222.333/0001-44")
                                                .endereco("Praça do Saber, 789 - Belo Horizonte/MG")
                                                .telefone("(31) 99876-5432")
                                                .email("info@editoragama.com")
                                                .build(),
                                Editora.builder()
                                                .id(0)
                                                .nome("Editora Delta")
                                                .cnpj("55.666.777/0001-88")
                                                .endereco("Rua do Conhecimento, 321 - Curitiba/PR")
                                                .telefone("(41) 98765-1234")
                                                .email("contato@editoradelta.com")
                                                .build(),
                                Editora.builder()
                                                .id(0)
                                                .nome("Editora Épsilon")
                                                .cnpj("22.333.444/0001-55")
                                                .endereco("Av. Livros, 654 - Porto Alegre/RS")
                                                .telefone("(51) 91234-8765")
                                                .email("atendimento@editoraepsilon.com")
                                                .build())
                                .forEach(bibliotecaService::cadastrar);
        }

        public void cadastrarAutores() {
                List.of(
                                new Autor(0, "Machado de Assis", "Brasileiro"),
                                new Autor(0, "José de Alencar", "Brasileiro"),
                                new Autor(0, "Clarice Lispector", "Brasileira"),
                                new Autor(0, "Graciliano Ramos", "Brasileiro"),
                                new Autor(0, "Jorge Amado", "Brasileiro"),
                                new Autor(0, "Monteiro Lobato", "Brasileiro"),
                                new Autor(0, "Carlos Drummond de Andrade", "Brasileiro"),
                                new Autor(0, "Paulo Coelho", "Brasileiro"),
                                new Autor(0, "Eça de Queirós", "Português"),
                                new Autor(0, "Fernando Pessoa", "Português")).forEach(bibliotecaService::cadastrar);
        }

        public void cadastrarClientes() {
                List.of(
                                new Cliente(0, "João Silva", "joao.silva@email.com", "(11) 98765-4321",
                                                "123.456.789-00"),
                                new Cliente(0, "Maria Oliveira", "maria.oliveira@email.com", "(21) 98765-4321",
                                                "987.654.321-00"),
                                new Cliente(0, "Pedro Santos", "pedro.santos@email.com", "(31) 98765-4321",
                                                "456.789.123-00"),
                                new Cliente(0, "Ana Costa", "ana.costa@email.com", "(41) 98765-4321", "789.123.456-00"),
                                new Cliente(0, "Carlos Pereira", "carlos.pereira@email.com", "(51) 98765-4321",
                                                "321.654.987-00"))
                                .forEach(bibliotecaService::cadastrar);
        }

        public void cadastrarLivros() {
                var autores = bibliotecaService.getAutores();
                var editoras = bibliotecaService.getEditoras();

                List.of(
                                Livro.builder().isbn(0)
                                                .titulo("Memórias Póstumas de Brás Cubas")
                                                .autor(autores.get(0))
                                                .editora(editoras.get(0))
                                                .anoPublicacao(1881)
                                                .categoria(Categoria.ROMANCE)
                                                .numeroDePaginas(200)
                                                .build(),
                                Livro.builder()
                                                .isbn(0)
                                                .titulo("Dom Casmurro")
                                                .autor(autores.get(0))
                                                .editora(editoras.get(0))
                                                .anoPublicacao(1899)
                                                .categoria(Categoria.ROMANCE)
                                                .numeroDePaginas(464)
                                                .build(),
                                Livro.builder()
                                                .isbn(0)
                                                .titulo("Memórias Póstumas de Brás Cubas")
                                                .autor(autores.get(1))
                                                .editora(editoras.get(1))
                                                .anoPublicacao(1881)
                                                .categoria(Categoria.ROMANCE)
                                                .numeroDePaginas(304)
                                                .build(),
                                Livro.builder()
                                                .isbn(0)
                                                .titulo("O Guarani")
                                                .autor(autores.get(1))
                                                .editora(editoras.get(1))
                                                .anoPublicacao(1857)
                                                .categoria(Categoria.AVENTURA)
                                                .numeroDePaginas(560)
                                                .build(),
                                Livro.builder()
                                                .isbn(0)
                                                .titulo("A Hora da Estrela")
                                                .autor(autores.get(2))
                                                .editora(editoras.get(2))
                                                .anoPublicacao(1977)
                                                .categoria(Categoria.ROMANCE)
                                                .numeroDePaginas(88)
                                                .build(),
                                Livro.builder()
                                                .isbn(0)
                                                .titulo("Vidas Secas")
                                                .autor(autores.get(3))
                                                .editora(editoras.get(3))
                                                .anoPublicacao(1938)
                                                .categoria(Categoria.ROMANCE)
                                                .numeroDePaginas(128)
                                                .build(),
                                Livro.builder()
                                                .isbn(0)
                                                .titulo("Gabriela, Cravo e Canela")
                                                .autor(autores.get(4))
                                                .editora(editoras.get(4))
                                                .anoPublicacao(1958)
                                                .categoria(Categoria.ROMANCE)
                                                .numeroDePaginas(424)
                                                .build(),
                                Livro.builder()
                                                .isbn(0)
                                                .titulo("Sítio do Picapau Amarelo")
                                                .autor(autores.get(5))
                                                .editora(editoras.get(0))
                                                .anoPublicacao(1920)
                                                .categoria(Categoria.INFANTO_JUVENIL)
                                                .numeroDePaginas(360)
                                                .build(),
                                Livro.builder()
                                                .isbn(0)
                                                .titulo("Alguma Poesia")
                                                .autor(autores.get(6))
                                                .editora(editoras.get(1))
                                                .anoPublicacao(1930)
                                                .categoria(Categoria.ARTE)
                                                .numeroDePaginas(120)
                                                .build(),
                                Livro.builder()
                                                .isbn(0)
                                                .titulo("O Alquimista")
                                                .autor(autores.get(7))
                                                .editora(editoras.get(2))
                                                .anoPublicacao(1988)
                                                .categoria(Categoria.FICCAO)
                                                .numeroDePaginas(176)
                                                .build(),
                                Livro.builder()
                                                .isbn(0)
                                                .titulo("Os Maias")
                                                .autor(autores.get(8))
                                                .editora(editoras.get(3))
                                                .anoPublicacao(1878)
                                                .categoria(Categoria.ROMANCE)
                                                .numeroDePaginas(720)
                                                .build(),
                                Livro.builder()
                                                .isbn(0)
                                                .titulo("Mensagem")
                                                .autor(autores.get(9))
                                                .editora(editoras.get(4))
                                                .anoPublicacao(1934)
                                                .categoria(Categoria.ARTE)
                                                .numeroDePaginas(104)
                                                .build())
                                .forEach(bibliotecaService::cadastrar);
        }

        public void cadastrarEmprestimos() {
                var livros = bibliotecaService.getLivros();

                List.of(
                                Emprestimo.builder()
                                                .id(0)
                                                .livro(livros.get(0))
                                                .dataEmprestimo(LocalDate.now().minusDays(10))
                                                .dataPrevistaDevolucao(LocalDate.now().plusDays(5))
                                                .devolvido(false)
                                                .build(),
                                Emprestimo.builder()
                                                .id(0)
                                                .livro(livros.get(1))
                                                .dataEmprestimo(LocalDate.now().minusDays(5))
                                                .dataPrevistaDevolucao(LocalDate.now().plusDays(10))
                                                .devolvido(false)
                                                .build(),
                                Emprestimo.builder()
                                                .id(0)
                                                .livro(livros.get(2))
                                                .dataEmprestimo(LocalDate.now().minusDays(20))
                                                .dataPrevistaDevolucao(LocalDate.now().minusDays(5)) // Atrasado
                                                .devolvido(false)
                                                .build(),
                                Emprestimo.builder()
                                                .id(0)
                                                .livro(livros.get(3))
                                                .dataEmprestimo(LocalDate.now().minusDays(2))
                                                .dataPrevistaDevolucao(LocalDate.now().plusDays(12))
                                                .devolvido(false)
                                                .build(),
                                Emprestimo.builder()
                                                .id(0)
                                                .livro(livros.get(4))
                                                .dataEmprestimo(LocalDate.now().minusDays(15))
                                                .dataPrevistaDevolucao(LocalDate.now())
                                                .devolvido(false)
                                                .build(),
                                Emprestimo.builder()
                                                .id(0)
                                                .livro(livros.get(5))
                                                .dataEmprestimo(LocalDate.now().minusDays(30))
                                                .dataPrevistaDevolucao(LocalDate.now().minusDays(15)) // Atrasado e
                                                                                                      // devolvido
                                                .devolvido(true)
                                                .build(),
                                Emprestimo.builder()
                                                .id(0)
                                                .livro(livros.get(6))
                                                .dataEmprestimo(LocalDate.now().minusDays(3))
                                                .dataPrevistaDevolucao(LocalDate.now().plusDays(11))
                                                .devolvido(false)
                                                .build(),
                                Emprestimo.builder()
                                                .id(0)
                                                .livro(livros.get(7))
                                                .dataEmprestimo(LocalDate.now().minusDays(8))
                                                .dataPrevistaDevolucao(LocalDate.now().plusDays(7))
                                                .devolvido(false)
                                                .build(),
                                Emprestimo.builder()
                                                .id(0)
                                                .livro(livros.get(8))
                                                .dataEmprestimo(LocalDate.now().minusDays(1))
                                                .dataPrevistaDevolucao(LocalDate.now().plusDays(14))
                                                .devolvido(false)
                                                .build(),
                                Emprestimo.builder()
                                                .id(0)
                                                .livro(livros.get(9))
                                                .dataEmprestimo(LocalDate.now().minusDays(12))
                                                .dataPrevistaDevolucao(LocalDate.now().plusDays(2))
                                                .devolvido(true)
                                                .build())
                                .forEach(bibliotecaService::cadastrar);
        }

}
