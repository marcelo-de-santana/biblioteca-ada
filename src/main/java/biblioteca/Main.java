package biblioteca;

import biblioteca.ui.ApplicationUI;
import biblioteca.utils.CadastroUtils;

public class Main {

    public static void main(String[] args) {
        CadastroUtils.inicializarDados();
        ApplicationUI.iniciarUi();
    }

}


