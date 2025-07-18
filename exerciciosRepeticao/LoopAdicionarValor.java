// Faça um programa que permita duas opções ao usuário:
// Opção 'i'(inserir) para inserir o valor de um produto;
// Opção 'f'(finalizar) para finalizar o programa.
// Enquanto o usuário escolher a opção 'i' ele poderá informar novos valores.
// Quando o usuário informar a opção 'f' , o programa deve apresentar o valor total dos produtos e
// finalizar.

import java.util.Scanner;

public class LoopAdicionarValor {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    char resp = 'i';
    float valorTotal = 0.0f;

    while (resp == 'i') {
      System.out.print("Adicionar valor do produto: R$ ");
      float valor = scanner.nextFloat();

      System.out.println("Valor do produto: R$ " + valor);

      valorTotal = valorTotal + valor;

      System.out.print("'i' para adicionar outro 'f' para finalizar: ");
      resp = scanner.next().charAt(0);
    }

    System.out.println("Valor total dos produtos adicionados: R$ " + valorTotal);

    scanner.close();
  }
}
