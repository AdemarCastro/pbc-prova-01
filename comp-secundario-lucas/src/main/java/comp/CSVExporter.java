package comp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVExporter {
    public static void exportToCSV(List<String[]> data, String filePath, String separator) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String[] row : data) {
                writer.write(String.join(separator, row));
                writer.newLine();
            }
            System.out.println("Dados exportados com sucesso para o arquivo CSV.");
        } catch (IOException e) {
            System.err.println("Erro ao exportar os dados para o arquivo CSV: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
       
        List<String[]> data = List.of(
            new String[]{"municipio", "codigo", "prefeito"},
            new String[]{"Apui", "1300144", "MARCOS ANTONIO"},

        );

        String filePath = "caminho/do/dados-ibge-amazonas-2021.csv.csv";
        String separator = ",";

        exportToCSV(data, filePath, separator);
    }
}