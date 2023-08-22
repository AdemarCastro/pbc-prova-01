package app;

import app.model.Municipio;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static app.repository.MunicipioRepository.lerMunicipios;

public class Main {

    private static final String dadosIBGEAmazonas
            = "D:\\Salve_Aqui_Seus_Arquivos\\pbc-prova-01\\app-principal-ademar\\src\\csv\\dados_tab.txt";

    public static void main(String[] args) throws IOException {
        List<Municipio> municipios = lerMunicipios(dadosIBGEAmazonas, " ");

        for(Municipio municipio : municipios) {
            System.out.println("Nome: " + municipio.getNome());
            System.out.println("Area: " + municipio.getArea());
        }
    }

}

// arquivo, critério(populacao maior que 100 mil exemplo), separador