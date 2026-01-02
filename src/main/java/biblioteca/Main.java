package biblioteca;

import biblioteca.repository.AutorRepository;
import biblioteca.repository.ClienteRepository;
import biblioteca.repository.EditoraRepository;
import biblioteca.repository.EmprestimoRepository;
import biblioteca.repository.LivroRepository;
import biblioteca.service.AutorService;
import biblioteca.service.BibliotecaService;
import biblioteca.service.ClienteService;
import biblioteca.service.EditoraService;
import biblioteca.service.EmprestimoService;
import biblioteca.service.LivroService;
import biblioteca.ui.ApplicationUI;
import biblioteca.utils.CadastroUtils;

public class Main {

    public static void main(String[] args) {
        var bibliotecaService = new BibliotecaService(
                new AutorService(new AutorRepository()),
                new LivroService(new LivroRepository()),
                new ClienteService(new ClienteRepository()),
                new EditoraService(new EditoraRepository()),
                new EmprestimoService(new EmprestimoRepository()));

        new CadastroUtils(bibliotecaService).inicializarDados();
        new ApplicationUI(bibliotecaService).iniciarUi();
    }

}
