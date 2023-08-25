package app.view;

import java.io.IOException;
import java.util.Scanner;

import app.controller.MunicipioController;

public class MunicipioUI {

  public void viewMunicipioUI() throws IOException {

    Scanner entrada = new Scanner(System.in);
    MunicipioController municipioController = new MunicipioController();

    while (true) {
      System.out.println("\n/////////////////////////////////////////");
      System.out.println("///////////// Menu Principal ////////////");
      System.out.println("/////////////////////////////////////////");

      System.out.println("\n1: Inserir um Critério, Separador e receber o Resultado");
      System.out.println("2: Exibir todos os Dados do CSV");
      System.out.println("3: Sair do Programa");
      System.out.println("-------------------------------------------");
      System.out.print("  Selecione opção: ");

      try {

        int opcao = entrada.nextInt();

        if (opcao == 1) {
          municipioController.inserirCriterioSeparador();
        } else if (opcao == 2) {
          municipioController.exibirDados(null);
        } else if (opcao == 3) {
          break;
        } else {
          System.out.println("Opção inválida: Insira os valores 1, 2 ou 3.");
        }

      } catch (java.util.InputMismatchException e) {
        entrada.nextLine();
        System.out.println("Opção inválida: Insira um valor númerico.");
      }

    }

  }

}
