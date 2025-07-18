// Calcule o valor da multa seguindo as regras: Receba
// como input do usuário a velocidade de um carro
// Multa de 50 reais se a velocidade for até 10km/h
// acima;
// Multa de 120 reais se a velocidade for entre
// 11km/h e 20km/h;
// Multa de 300 reais se a velocidade 20km/h acima

import java.util.Scanner;

public class CalcularMulta {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Velocidade em Km/h: ");
    double vel = scanner.nextDouble();

    if (vel <= 10) {
      System.out.println("Multa de R$ 50,00");
    } else if (vel > 20) {
      System.out.println("Multa de R$ 300,00");
    } else if (vel > 10 && vel <= 20) {
      System.out.println("Multa de R$ 120,00");
    }

    scanner.close();
  }
}
