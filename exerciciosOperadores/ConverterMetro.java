// Faça um programa que receba do usuário um valor
// em metros. Apresente na tela o valor convertido em
// centímetros e quilômetros

import java.util.Scanner;

public class ConverterMetro {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Valor em metros: ");
    float metros = scanner.nextFloat();

    float cm = metros * 100;
    float km = metros / 1000;

    System.out.println("Valor em metros para centímetros: " + cm);
    System.out.println("Valor em metros para quilômetros: " + km);

    scanner.close();
  }
}
