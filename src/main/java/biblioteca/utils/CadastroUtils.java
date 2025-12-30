package biblioteca.utils;

import java.util.ArrayList;
import java.util.List;

import biblioteca.entity.Autor;
import biblioteca.entity.Biblioteca;
import biblioteca.entity.Cliente;
import biblioteca.entity.Editora;

public class CadastroUtils {
    private static final Biblioteca biblioteca = Biblioteca.getInstancia();

    public static void cadatrarEditoras() {
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
                new Cliente(1, "João Silva", "joao.silva@email.com", "(11) 98765-4321",
                        "123.456.789-00"),
                new Cliente(2, "Maria Oliveira", "maria.oliveira@email.com", "(21) 98765-4321",
                        "987.654.321-00"),
                new Cliente(3, "Pedro Santos", "pedro.santos@email.com", "(31) 98765-4321",
                        "456.789.123-00"),
                new Cliente(4, "Ana Costa", "ana.costa@email.com", "(41) 98765-4321", "789.123.456-00"),
                new Cliente(5, "Carlos Pereira", "carlos.pereira@email.com", "(51) 98765-4321",
                        "321.654.987-00"))));
    }
}
