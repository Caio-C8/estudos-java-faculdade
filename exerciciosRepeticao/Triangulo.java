// Faça um programa que receba a altura de um
// triangulo em um número inteiro e imprima-o
// utilizando asteriscos.

import java.util.Scanner;

public class Triangulo {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Digite a altura: ");
    int altura = scanner.nextInt();

    for (int i = 1; i <= altura; i++) {
      for (int j = 0; j < i; j++) {
        System.out.print("*");
      }

      System.out.println();
    }

    scanner.close();
  }
}
