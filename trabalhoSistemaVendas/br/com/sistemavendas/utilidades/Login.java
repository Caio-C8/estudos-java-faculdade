package br.com.sistemavendas.utilidades;

import br.com.sistemavendas.usuario.Cliente;
import java.util.ArrayList;
import java.util.Scanner;

public class Login {
  public static Cliente autenticaCliente(ArrayList<Cliente> clientes, Scanner scanner) {
    System.out.print("\nE-mail: ");
    String email = scanner.nextLine();

    System.out.print("Senha: ");
    String senha = scanner.nextLine();

    for (Cliente c : clientes) {
      if (c.fazerLogin(email, senha)) {
        return c;
      }
    }

    return null;
  }
}
