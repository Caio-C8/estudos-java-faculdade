// Peça para o usuário informar um número. Verifique
// se esse número é positivo, negativo ou 0.

import java.util.Scanner;

public class VerificaNum {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Número: ");
    double num = scanner.nextDouble();

    if (num > 0) {
      System.out.println("Positivo");
    } else if (num < 0) {
      System.out.println("Negativo");
    } else {
      System.out.println("Número é 0");
    }

    scanner.close();
  }
}
