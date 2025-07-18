//  Peça ao usuário para informar um número. Verifique
// se ele é par ou ímpar.

import java.util.Scanner;

public class VerificaNum2 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Número: ");
    double num = scanner.nextDouble();

    if (num % 2 == 0) {
      System.out.println("Par");
    } else {
      System.out.println("Ímpar");
    }

    scanner.close();
  }
}
