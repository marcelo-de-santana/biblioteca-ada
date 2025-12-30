package biblioteca;

import static biblioteca.utils.CadastroUtils.*;

import biblioteca.gui.ApplicationUI;

public class Main {

    public static void main(String[] args) {
        cadatrarEditoras();
        cadastrarAutores();
        cadastrarClientes();
        ApplicationUI.iniciarUi();
    }

}


