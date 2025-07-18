// Faça um programa que receba 4 notas. Calcule e
// exiba a média dessas notas

import java.util.Scanner;

public class Media {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    float notas = 0;
    int alunos = 0;

    for (int i = 0; i < 4; i++) {
      System.out.print("Nota do " + (i + 1) + "º aluno: ");
      float nota = scanner.nextFloat();

      notas += nota;
      alunos = i + 1;
    }

    float media = notas / alunos;

    System.out.println("Média de notas dos " + alunos + " alunos: " + media);

    scanner.close();
  }
}
