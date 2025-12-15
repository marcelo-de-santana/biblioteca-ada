package biblioteca.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;

public class JsonLoader {
    private static final ObjectMapper mapper = new ObjectMapper();


    public static <T> List<T> carregarLista(String nomeDoArquivo, Class<T> classe) {

        try (InputStream inputStream = JsonLoader.class.getResourceAsStream("/" + nomeDoArquivo + ".json")) {
            if (inputStream != null)
                return mapper.readValue(inputStream, mapper.getTypeFactory().constructType(List.class, classe));
            else
                throw new IllegalStateException("Arquivo " + nomeDoArquivo + ".json não encontrado em '/resources'");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
