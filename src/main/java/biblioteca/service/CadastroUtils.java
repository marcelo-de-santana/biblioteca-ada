package biblioteca.service;

import biblioteca.entity.Biblioteca;
import biblioteca.entity.Editora;

import java.util.List;

public class CadastroUtils {
    private static final Biblioteca biblioteca = Biblioteca.getInstancia();

    public static void cadatrarEditoras() {
        biblioteca.setEditoras(List.of(
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
                        .build()
        ));
    }
}

