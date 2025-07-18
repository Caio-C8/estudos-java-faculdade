// Faça um programa que receba 3 notas e seus
// respectivos pesos. Calcule e exiba a média
// ponderada dessas notas

import java.util.Scanner;

public class MediaPond {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    float notas = 0;
    float pesos = 0;

    for (int i = 0; i < 3; i++) {
      System.out.print("Nota do " + (i + 1) + "º aluno: ");
      float nota = scanner.nextFloat();

      System.out.print("Peso da nota do " + (i + 1) + "º aluno: ");
      float peso = scanner.nextFloat();

      float termoMedia = nota * peso;
      notas += termoMedia;
      pesos += peso;

      System.out.print("\n");
    }

    float media = notas / pesos;

    System.out.println("Média ponderada das notas: " + media);

    scanner.close();
  }
}
