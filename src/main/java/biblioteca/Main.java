package biblioteca;

import biblioteca.service.BibliotecaService;
import biblioteca.ui.ApplicationUI;
import biblioteca.utils.CadastroUtils;

public class Main {

    public static void main(String[] args) {
        var bibliotecaService = BibliotecaService.getInstancia();

        new CadastroUtils(bibliotecaService).inicializarDados();
        new ApplicationUI(bibliotecaService).iniciarUi();
    }

}
