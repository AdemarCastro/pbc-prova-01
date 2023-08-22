package app.controller;

import app.model.Municipio;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static app.repository.MunicipioRepository.lerMunicipios;

public class MunicipioController {

    private static final String dadosIBGEAmazonas
            = "D:\\Salve_Aqui_Seus_Arquivos\\pbc-prova-01\\app-principal-ademar\\src\\csv\\dados-ibge-amazonas-2021.csv";

    private static String separador;

    private static String criterio;

    public void lerDados() throws IOException {
        Scanner entrada = new Scanner(System.in);



        System.out.println("Separador: ");
        separador = entrada.nextLine();

        System.out.println("Critério: ");
        criterio = entrada.nextLine();
    }

    public void exibirDados() throws IOException {

        List<Municipio> municipios = lerMunicipios(dadosIBGEAmazonas, separador);

        for(Municipio municipio : municipios) {
            System.out.println("Nome: " + municipio.getNome());
            System.out.println("Codigo: " + municipio.getCodigo());
            System.out.println("Gentilico: " + municipio.getGentilico());
            System.out.println("Prefeito: " + municipio.getPrefeito());
            System.out.println("Area: " + municipio.getArea());
            System.out.println("População: " + municipio.getGentilico());
            System.out.println("Densidade: " + municipio.getNome());
            System.out.println("Codigo: " + municipio.getCodigo());
            System.out.println("Gentilico: " + municipio.getGentilico());
            System.out.println("Nome: " + municipio.getNome());
            System.out.println("Codigo: " + municipio.getCodigo());
            System.out.println("Gentilico: " + municipio.getGentilico());
        }

    }
}
