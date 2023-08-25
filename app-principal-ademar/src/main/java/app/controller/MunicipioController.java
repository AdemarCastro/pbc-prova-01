package app.controller;

import app.model.Municipio;
import comp.base.SeparadorCsv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static app.repository.MunicipioRepository.lerMunicipios;

public class MunicipioController {

    private static final String dadosIBGEAmazonas
            = "C:\\Users\\Adema.DESKTOP-MKK2GAA\\Desktop\\Trabalho\\TADS\\4\u00BA SEMESTRE\\PBC\\provas\\pbc-prova-01\\app-principal-ademar\\src\\csv\\dados_tab.txt";

    private static String separador;

    private static String criterio;

    public void inserirCriterioSeparador() throws IOException {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Separador (',' ou ';' ou '|t'): ");
        separador = entrada.nextLine();

        System.out.print("Critério (nome-coluna operador[>, =, <] valor[Pode ser um Nome ou um Número]): ");
        criterio = entrada.nextLine();

        List<Object> municipios = enviarObjetosCsv();

        SeparadorCsv separador = new SeparadorCsv();

        List<Municipio> municipiosFiltrados = converterParaMunicipios(separador.receberDados(municipios, criterio));

        exibirDados(municipiosFiltrados);

    }

    public List<Municipio> converterParaMunicipios(List<Object> objetos) {
        List<Municipio> municipios = new ArrayList<>();
    
        for (Object objeto : objetos) {
            List<?> parametros = (List<?>) objeto;
            if (parametros.size() == 13) {
                municipios.add(new Municipio(
                        parametros.get(0).toString(), parametros.get(1).toString(),
                        parametros.get(2).toString(), parametros.get(3).toString(),
                        parametros.get(4).toString(), parametros.get(5).toString(),
                        parametros.get(6).toString(), parametros.get(7).toString(),
                        parametros.get(8).toString(), parametros.get(9).toString(),
                        parametros.get(10).toString(), parametros.get(11).toString(),
                        parametros.get(12).toString()));
            } else {
                System.out.println("Lista de parâmetros não possui tamanho correto: " + parametros.size());
            }
        }
    
        return municipios;
    }
    

    public void exibirDados(List<Municipio> municipios) throws IOException {

        if(separador == null){
            separador = "\t";
        }

        if(municipios == null){
            municipios = converterParaMunicipios(lerMunicipios(dadosIBGEAmazonas, separador));
        }

        for(Municipio municipio : municipios) {
            System.out.println("Nome: " + ((Municipio) municipio).getNome());
            System.out.println("Codigo: " + ((Municipio) municipio).getCodigo());
            System.out.println("Gentilico: " + ((Municipio) municipio).getGentilico());
            System.out.println("Prefeito: " + ((Municipio) municipio).getPrefeito());
            System.out.println("Area: " + ((Municipio) municipio).getArea());
            System.out.println("População: " + ((Municipio) municipio).getPopulacao());
            System.out.println("Densidade: " + ((Municipio) municipio).getDensidade());
            System.out.println("Escolarizacao: " + ((Municipio) municipio).getEscolarizacao());
            System.out.println("IDHM: " + ((Municipio) municipio).getIdhm());
            System.out.println("Mortalidade: " + ((Municipio) municipio).getMortalidade());
            System.out.println("Receitas: " + ((Municipio) municipio).getReceitas());
            System.out.println("Despesas: " + ((Municipio) municipio).getDespesas());
            System.out.println("PIB: " + ((Municipio) municipio).getPib());
            System.out.println("\n");
        }

    }

    public List<Object> enviarObjetosCsv() throws IOException{
        List<Object> municipios = lerMunicipios(dadosIBGEAmazonas, separador);

        return municipios;
    }
}

/* LISTA DE OBJETOS List<Objets>, Critério (Exemplo: populacao > 100.000) */
