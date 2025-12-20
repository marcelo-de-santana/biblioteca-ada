package biblioteca.gui;

import static biblioteca.service.CadastroUtils.cadatrarEditoras;

public class Main {

    public static void main(String[] args) {
        cadatrarEditoras();
        ApplicationUI.iniciarUi();
    }

}


