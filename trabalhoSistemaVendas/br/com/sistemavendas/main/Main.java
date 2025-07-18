package br.com.sistemavendas.main;

import br.com.sistemavendas.produtos.Catalogo;
import br.com.sistemavendas.produtos.Produto;
import br.com.sistemavendas.usuario.AtendenteVirtual;
import br.com.sistemavendas.usuario.Cliente;
import br.com.sistemavendas.utilidades.Cadastrar;
import br.com.sistemavendas.utilidades.Login;
import br.com.sistemavendas.utilidades.Menus;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
  private static final ArrayList<Cliente> clientes = new ArrayList<>();
  private static final ArrayList<AtendenteVirtual> atendentes = new ArrayList<>();
  private static final Catalogo catalogo = new Catalogo();

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    cadastrarProdutos();

    AtendenteVirtual a1 = new AtendenteVirtual("João");
    AtendenteVirtual a2 = new AtendenteVirtual("Alice");
    AtendenteVirtual a3 = new AtendenteVirtual("Joana");

    atendentes.add(a1);
    atendentes.add(a2);
    atendentes.add(a3);

    while (true) {
      System.out.println("\n=== MENU ===");
      System.out.println("1. Cadastrar Pessoa Física");
      System.out.println("2. Cadastrar Pessoa Jurídica");
      System.out.println("3. Login");
      System.out.println("4. Sair");
      System.out.print("Escolha uma opção: ");
      int opcao = scanner.nextInt();
      scanner.nextLine();

      switch (opcao) {
        case 1 -> {
          Cliente pf = Cadastrar.cadastrarCliente("pf", scanner);
          clientes.add(pf);

          int atendenteAleatorio = random.nextInt(atendentes.size());
          AtendenteVirtual atendente = atendentes.get(atendenteAleatorio);
          atendente.setClientes(pf);
          pf.setAtendente(atendente);

          System.out.println("Pessoa Física cadastrada com sucesso.");
        }
        case 2 -> {
          Cliente pj = Cadastrar.cadastrarCliente("pj", scanner);
          clientes.add(pj);

          int atendenteAleatorio = random.nextInt(atendentes.size() - 1);
          AtendenteVirtual atendente = atendentes.get(atendenteAleatorio);
          atendente.setClientes(pj);
          pj.setAtendente(atendente);

          System.out.println("Pessoa Jurídica cadastrada com sucesso.");
        }
        case 3 -> {
          // Requisito 1: só acessa se tiver criado conta e logado
          Cliente logado = Login.autenticaCliente(clientes, scanner);

          if (logado != null) {
            System.out.println(
                "Login realizado com sucesso. Bem-vindo(a), " + logado.getNome() + "!");
            Menus.menuCliente(logado, scanner, catalogo);
          } else {
            System.out.println("Usuário ou senha incorretos.");
          }
        }
        case 4 -> {
          System.out.println("Saindo do sistema...");
          scanner.close();
          return;
        }
        default -> System.out.println("Opção inválida.");
      }
    }
  }

  private static void cadastrarProdutos() {
    catalogo.adicionarAoCatalogo(new Produto("Camiseta", 100.00));
    catalogo.adicionarAoCatalogo(new Produto("Calça", 150.00));
    catalogo.adicionarAoCatalogo(new Produto("Tênis", 250.00));
  }
}
