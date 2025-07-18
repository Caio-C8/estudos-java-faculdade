// Faça um programa que receba duas notas parciais de
// um aluno. O programa deve calcular a média
// alcançada por aluno e apresentar:
// A mensagem "Aprovado", se a média alcançada for maior ou igual a sete;
// A mensagem "Reprovado" se a média for menor do que sete;
// A mensagem "Aprovado com Distinção", se a média for igual a dez.

import java.util.Scanner;

public class Aprovacao {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("1ª nota do aluno: ");
    double nota1 = scanner.nextDouble();

    System.out.print("2ª nota do aluno: ");
    double nota2 = scanner.nextDouble();

    double media = (nota1 + nota2) / 2;

    if (media == 10) {
      System.out.println("Aprovado com distinção");
    } else if (media >= 7) {
      System.out.println("Aprovado");
    } else {
      System.out.println("Reprovado");
    }

    scanner.close();
  }
}
