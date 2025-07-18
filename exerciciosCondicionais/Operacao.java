// Peça ao usuário para digitar um operador (+, -, *, /) e
// informar dois números. Em seguida, usando o
// switch-case, verifique qual a operação desejada e
// retorne o resultado. Lembre-se que não é permitido
// a divisão por 0.

import java.util.Scanner;

public class Operacao {
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Digite o primeiro número: ");
    double num1 = scanner.nextDouble();

    System.out.print("Digite o segundo número: ");
    double num2 = scanner.nextDouble();

    System.out.print("Digite um operador: ");
    char operador = scanner.next().charAt(0);

    switch (operador) {
      case '+':
        System.out.println("Resultado: " + (num1 + num2));
        break;
      case '-':
        System.out.println("Resultado: " + (num1 - num2));
        break;
      case '*':
        System.out.println("Resultado: " + (num1 * num2));
        break;
      case '/':
        if (num2 == 0) {
          System.out.println("Divisão por zero inválida");
          break;
        }

        System.out.println("Resultado: " + (num1 / num2));
        break;
      default:
        System.out.println("Operador inválido");
        break;
    }

    scanner.close();
  }
}
