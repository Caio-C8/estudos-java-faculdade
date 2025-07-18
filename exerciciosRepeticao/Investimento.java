// Faça um programa para aplicações de investimento.
// O programa deve permitir o usuário selecionar duas
// opções: 1 - Pessoa Física; 2 - Pessoa Jurídica. Se
// selecionado pessoa física, o usuário deve informar o
// CPF e o deposito inicial. Se selecionado pessoa
// jurídica, o usuário deve informar o CNPJ e o
// deposito inicial. O deposito inicial para CNPJ deve
// ser no mínimo R$5.000

import java.util.Scanner;

public class Investimento {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("1 - Pessoa Física");
    System.out.println("2 - Pessoa Jurídica");
    System.out.print("Informe em qual você se encaixa: ");
    int tipo = scanner.nextInt();

    if (tipo == 1) {
      scanner.nextLine();

      System.out.print("CPF: ");
      String cpf = scanner.nextLine();

      System.out.print("Depósito inicial: ");
      float deposito = scanner.nextFloat();

      System.out.println("Portador do CPF: " + cpf + " fez um depósito inicial de: R$ " + deposito);
    } else {
      scanner.nextLine();

      System.out.print("CNPJ: ");
      String cnpj = scanner.nextLine();

      System.out.print("Depósito inicial: ");
      float deposito = scanner.nextFloat();

      while (deposito < 5000) {
        System.out.print(
            "O depósito inicial deve ser no mínimo R$ 5000. Deposite outro valor: R$ ");
        deposito = scanner.nextFloat();
      }

      System.out.println(
          "Portador do CNPJ: " + cnpj + " fez um depósito inicial de: R$ " + deposito);
    }

    scanner.close();
  }
}
