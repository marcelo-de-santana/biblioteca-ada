package biblioteca.gui;

import biblioteca.service.BibliotecaService;

import java.util.Scanner;


public class ListagemUI {
    private Scanner promptInput;
    private BibliotecaService bibliotecaService;

    public ListagemUI(Scanner promptInput, BibliotecaService bibliotecaService) {
        this.promptInput = promptInput;
        this.bibliotecaService = bibliotecaService;
    }


}
