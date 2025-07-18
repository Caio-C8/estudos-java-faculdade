// Faça um programa que receba o valor de um
// depósito inicial em reais, a taxa de juros anual e o
// tempo investido em anos. Use a fórmula do juros
// simples e retorne o valor do montante final.
// Fórmula: M=C.(1+i⋅t)

import java.util.Scanner;

public class CalculadoraInvest1 {
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

    System.out.println("Montante: " + montante);

    scanner.close();
  }
}
