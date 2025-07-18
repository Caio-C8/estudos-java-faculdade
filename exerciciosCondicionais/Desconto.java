// Calcule o desconto progressivo de uma conta
// seguindo as seguintes regras:
// Compras entre R$100 e R$199, 10% de desconto;
// Compras entre R$200 e R$299, 15% de desconto;
// Compras com valor igual ou acima de R$300, 20% de desconto;

import java.util.Scanner;

public class Desconto {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    double desconto = 0;
    double novoValor = 0;

    System.out.print("Valor da compra: R$ ");
    double valor = scanner.nextDouble();

    if (valor >= 100 && valor <= 199) {
      desconto = 10;
      novoValor = valor - (valor * (desconto / 100));
    } else if (valor >= 200 && valor <= 299) {
      desconto = 15;
      novoValor = valor - (valor * (desconto / 100));
    } else {
      desconto = 20;
      novoValor = valor - (valor * (desconto / 100));
    }

    if (valor < 100) {
      System.out.println("Sem desconto");
    } else {
      System.out.println("O novo valor com o desconto de " + desconto + "% é R$ " + novoValor);
    }

    scanner.close();
  }
}
