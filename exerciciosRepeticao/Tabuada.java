// Faça um programa que receba um número e usando
// laços de repetição calcule e mostre a tabuada desse
// número.

import java.util.Scanner;

public class Tabuada {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Digite um número: ");
    int num = scanner.nextInt();

    for (int i = 0; i <= 10; i++) {
      int tabuada = num * i;
      System.out.println(tabuada);
    }

    scanner.close();
  }
}
