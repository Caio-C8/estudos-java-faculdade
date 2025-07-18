// Crie um sistema de permissionamento. Peça ao
// usuário para informar qual será sua senha. Após isso,
// peça para ele digitar a senha novamente para fazer
// login no sistema. Verifique a senha informada e
// imprima "Acesso concedido" caso estiver correta e
// "Acesso negado" caso estiver incorreta. Obs: A senha
// deve ser númerica (inteiros).

import java.util.Scanner;

public class Senha {
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Digite a senha: ");
    int senha = scanner.nextInt();

    System.out.print("Confirme a senha: ");
    int confirmaSenha = scanner.nextInt();

    System.out.println(senha == confirmaSenha ? "Acesso concedido" : "Acesso negado");

    scanner.close();
  }
}
