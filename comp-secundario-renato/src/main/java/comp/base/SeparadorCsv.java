package comp.base;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeparadorCsv {

  private static String atributo;
  private static String operador;
  private static String valor;

  public List<Object> receberDados(List<Object> municipios, String criterio) {

    String regex = "(\\w+)\\s*([><=]+)\\s*(\\w+)";

    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(criterio);

    if (matcher.matches()) {
      String atributo = matcher.group(1);
      String operador = matcher.group(2);
      String valor = matcher.group(3);

      this.atributo = atributo;
      this.operador = operador;
      this.valor = valor;

      System.out.println("Atributo: " + atributo);
      System.out.println("Operador: " + operador);
      System.out.println("Valor: " + valor);
    } else {
      System.out.println("Formato incorreto.");
    }

    return tratarDados(municipios);
  }

  private List<Object> tratarDados(List<Object> objetos){
    List<Object> municipiosFiltrados = new ArrayList<>();

    List<Municipio> municipios = converterParaMunicipios(objetos);

    for(Municipio municipio : municipios){
      String valorDoAtributo = definirAtributo(municipio, atributo);

      Double valorNumericoDoAtributo = transformaEmDouble(valorDoAtributo);
      Double valorNumerico = transformaEmDouble(valor);

      if(operador == ">"){
        if(valorNumericoDoAtributo == null || valorNumerico == null){
          if(valorDoAtributo == valor){
            municipiosFiltrados.add(municipio);
          }
        }else if(valorNumericoDoAtributo > valorNumerico){
          municipiosFiltrados.add(municipio);
        }
      } else if (operador == "="){
        if(valorNumericoDoAtributo == valorNumerico){
          municipiosFiltrados.add(municipio);
        }
      } else if (operador == "<"){
        if(valorNumericoDoAtributo < valorNumerico){
          municipiosFiltrados.add(municipio);
        }
      }

    }

    return municipiosFiltrados;
  }

    public List<Municipio> converterParaMunicipios(List<Object> objetos) {
        List<Municipio> municipios = new ArrayList<>();

        for (Object objeto : objetos) {
            if (objeto instanceof Municipio) {
                municipios.add((Municipio) objeto);
            } else {
                System.out.println("Objeto não é do tipo Municipio: " + objeto.getClass().getName());
            }
        }

        return municipios;
    }

  private Double transformaEmDouble(String valor){
    try {
      double valorDouble = Double.parseDouble(valor);
      return valorDouble;
    } catch (NumberFormatException e) {
      System.out.println("Valor inválido: " + valor);
      e.printStackTrace();
      return null;
    }
  }

  public String definirAtributo(Municipio municipio, String atributo) {
    String atributoDefinido = null;

    switch (atributo) {
        case "nome":
            atributoDefinido = municipio.getNome();
            break;
        case "codigo":
            atributoDefinido = municipio.getCodigo();
            break;
        case "gentilico":
            atributoDefinido = municipio.getGentilico();
            break;
        case "prefeito":
            atributoDefinido = municipio.getPrefeito();
            break;
        case "area":
            atributoDefinido = municipio.getArea();
            break;
        case "populacao":
            atributoDefinido = municipio.getPopulacao();
            break;
        case "densidade":
            atributoDefinido = municipio.getDensidade();
            break;
        case "escolarizacao":
            atributoDefinido = municipio.getEscolarizacao();
            break;
        case "idhm":
            atributoDefinido = municipio.getIdhm();
            break;
        case "mortalidade":
            atributoDefinido = municipio.getMortalidade();
            break;
        case "receitas":
            atributoDefinido = municipio.getReceitas();
            break;
        case "despesas":
            atributoDefinido = municipio.getDespesas();
            break;
        case "pib":
            atributoDefinido = municipio.getPib();
            break;
        default:
            System.out.println("Atributo desconhecido: " + atributo);
            break;
    }

    return atributoDefinido;

  }

}
