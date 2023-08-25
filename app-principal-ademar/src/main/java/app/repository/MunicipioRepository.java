package app.repository;

import app.model.Municipio;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class MunicipioRepository {

    public static List<Object> lerMunicipios(String arquivo, String separador) throws IOException {
        return Files
                .readAllLines(new File(arquivo).toPath(), StandardCharsets.UTF_8)
                .stream()
                .skip(3)
                .map(s -> Municipio.parse(s, separador))
                .collect(Collectors.toList());
    }

}
