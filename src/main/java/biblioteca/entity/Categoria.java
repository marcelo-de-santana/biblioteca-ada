package biblioteca.entity;

public enum Categoria {
    ARTE(1, "Arte"),
    AVENTURA(2, "Aventura"),
    BIOGRAFIA(3, "Biografia"),
    CIENCIAS(4, "Ciências"),
    FANTASIA(5, "Fantasia"),
    FICCAO(6, "Ficção"),
    HISTORIA(7, "História"),
    INFANTO_JUVENIL(8, "Infanto Juvenil"),
    MISTERIO(9, "Mistério"),
    ROMANCE(10, "Romance"),
    TECNOLOGIA(11, "Tecnologia"),
    THRILLER(12, "Thriller");

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

    public static Categoria porId(int id) {
        for (var c : values()) {
            if (c.id == id)
                return c;
        }
        return null;
    }

    public static boolean existsById(int id) {
        return porId(id) != null;
    }

    public String mostrar() {
        return getId() + " - " + getDescricao();
    }

}
