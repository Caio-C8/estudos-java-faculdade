package br.com.sistemavendas.utilidades;

import br.com.sistemavendas.usuario.Cliente;
import br.com.sistemavendas.usuario.Endereco;
import br.com.sistemavendas.usuario.PessoaFisica;
import br.com.sistemavendas.usuario.PessoaJuridica;
import java.util.Scanner;

public class Cadastrar {

  public static Cliente cadastrarCliente(String tipo, Scanner scanner) {
    System.out.print("\nNome: ");
    String nome = scanner.nextLine();

    System.out.print("E-mail: ");
    String email = scanner.nextLine();

    System.out.print("Senha: ");
    String senha = scanner.nextLine();

    if (tipo.equalsIgnoreCase("pf")) {
      System.out.print("CPF: ");
      String cpf = scanner.nextLine();
      return PessoaFisica.criarConta(nome, email, senha, cpf);
    } else {
      System.out.print("CNPJ: ");
      String cnpj = scanner.nextLine();
      return PessoaJuridica.criarConta(nome, email, senha, cnpj);
    }
  }

  public static Endereco cadastrarEndereco(Scanner scanner, Cliente cliente) {
    System.out.print("\nRua: ");
    String rua = scanner.nextLine();

    System.out.print("Número: ");
    int numero = scanner.nextInt();
    scanner.nextLine();

    System.out.print("Complemento: ");
    String complemento = scanner.nextLine();

    return cliente.registrarEndereco(rua, numero, complemento);
  }
}
