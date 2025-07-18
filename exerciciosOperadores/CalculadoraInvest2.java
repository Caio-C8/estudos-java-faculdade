// Faça um programa que receba o valor de um
// deposito inicial em reais, a taxa de juros anual e o
// tempo investido. Use a fórmula do juros simples mas
// considere que o valor do montante final será
// tributado em 15% devido ao Imposto de Renda.

import java.util.Scanner;

public class CalculadoraInvest2 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Depósito inicial: ");
    float deposito = scanner.nextFloat();

    System.out.print("Taxa de juros anual: ");
    float juros = scanner.nextFloat();

    System.out.print("Tempo investido (anual): ");
    float tempo = scanner.nextFloat();

    juros = juros / 100;
    float montante = deposito * (1 + juros * tempo);

    float montanteTributado = montante - (montante * 0.15F);

    System.out.println("Montante: " + montanteTributado);

    scanner.close();
  }
}
