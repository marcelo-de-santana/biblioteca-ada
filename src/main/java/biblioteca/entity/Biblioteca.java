package biblioteca.entity;

import biblioteca.service.LivroService;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.UUID;

public class Biblioteca {
    private static Biblioteca INSTANCIA = new Biblioteca();

    private final UUID id = UUID.randomUUID();
    private final String nome = "Biblioteca Nacional";
    private final LocalDate anoCriacao = LocalDate.of(2025, 01, 01);

    private Biblioteca() {
    }

    public static Biblioteca getInstancia() {
        return INSTANCIA;
    }


}
