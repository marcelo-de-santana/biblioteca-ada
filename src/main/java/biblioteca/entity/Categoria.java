package biblioteca.entity;

public enum Categoria {
    FICCAO(1, "Ficção"),
    NAO_FICCAO(2, "Não Ficção"),
    TECNOLOGIA(3, "Tecnologia"),
    HISTORIA(4, "História"),
    CIENCIAS(5, "Ciências"),
    ARTE(6, "Arte"),
    INFANTO_JUVENIL(7, "Infanto-Juvenil"),
    BIOGRAFIA(8, "Biografia"),
    ROMANCE(9, "Romance"),
    FANTASIA(10, "Fantasia"),
    MISTERIO(11, "Mistério");

    private final int id;
    private final String descricao;

    Categoria(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
}
