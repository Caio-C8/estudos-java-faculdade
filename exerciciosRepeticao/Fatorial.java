// Faça um programa que receba um número inteiro e
// calcule o seu fatorial.

import java.util.Scanner;

public class Fatorial {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Digite um número: ");
    int num = scanner.nextInt();

    int resultado = 1;

    for (int i = 1; i <= num; i++) {
      resultado = resultado * i;
    }

    System.out.println("Fatorial de " + num + ": " + resultado);

    scanner.close();
  }
}
