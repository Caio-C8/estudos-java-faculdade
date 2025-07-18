package br.com.sistemavendas.utilidades;

import br.com.sistemavendas.produtos.Catalogo;
import br.com.sistemavendas.produtos.Produto;
import br.com.sistemavendas.usuario.AtendenteVirtual;
import br.com.sistemavendas.usuario.Cliente;
import br.com.sistemavendas.usuario.Endereco;
import br.com.sistemavendas.vendas.FormaEntrega;
import br.com.sistemavendas.vendas.FormaPagamento;
import br.com.sistemavendas.vendas.NotaFiscal;
import br.com.sistemavendas.vendas.Pedido;
import java.util.ArrayList;
import java.util.Scanner;

public class Menus {

  public static void menuCliente(Cliente cliente, Scanner scanner, Catalogo catalogo) {
    while (cliente.isAutenticado()) {
      System.out.println("\n=== MENU CLIENTE ===");
      System.out.println("1. Ver catálogo de produtos");
      System.out.println("2. Ver carrinho");
      System.out.println("3. Ver pedidos");
      System.out.println("4. Ver endereço");
      System.out.println("5. Conversar com atendente");
      System.out.println("6. Cadastrar endereço");
      System.out.println("7. Emitir nota fiscal");
      System.out.println("8. Logout");
      System.out.print("Escolha uma opção: ");
      int opcao = scanner.nextInt();
      scanner.nextLine();

      switch (opcao) {
        case 1 -> Interfaces.mostrarCatalogo(catalogo);

        case 2 -> menuCarrinho(cliente, scanner, catalogo);

        case 3 -> Interfaces.mostrarPedidos(cliente);

        case 4 -> Interfaces.mostrarEndereco(cliente);

        case 5 ->
            menuAtendente(
                cliente,
                scanner); // Requisito 5: cliente pode entrar em contato com atendente virtual

        case 6 -> {
          Endereco endereco = Cadastrar.cadastrarEndereco(scanner, cliente);
          cliente.setEndereco(endereco);
          System.out.println("Endereço cadastrado com sucesso.");
        }

        case 7 -> menuEmitirNotaFiscal(cliente, scanner);

        case 8 -> {
          cliente.fazerLogout();
          System.out.println("\nLogout realizado com sucesso.");
        }
        default -> System.out.println("\nOpção inválida.");
      }
    }
  }

  public static void menuCarrinho(Cliente cliente, Scanner scanner, Catalogo catalogo) {
    while (true) {
      System.out.println("\n=== CARRINHO ===");
      double total = 0.0;
      for (Produto p : cliente.getCarrinho().getProdutos()) {
        System.out.printf("%d %s - R$ %.2f\n", p.getId(), p.getNome(), p.getPreco());
        total += p.getPreco();
      }
      System.out.printf("Valor total: R$ %.2f\n\n", total);
      System.out.println("1. Adicionar produto");
      System.out.println("2. Remover produto");
      System.out.println("3. Voltar");
      System.out.print("Escolha uma opção: ");
      int escolha = scanner.nextInt();
      scanner.nextLine();

      if (escolha == 3) break;

      if (escolha > 3) {
        System.out.println("\nOpção inválida.");
        continue;
      }

      System.out.print("\nInforme o ID do produto: ");
      long id = scanner.nextLong();
      scanner.nextLine();

      Produto encontrado =
          catalogo.getProdutos().stream().filter(p -> p.getId() == id).findFirst().orElse(null);

      if (encontrado == null) {
        System.out.println("Produto não encontrado.");
        continue;
      }

      if (escolha == 1) {
        if (cliente.getCarrinho().getProdutos().contains(encontrado)) {
          System.err.println("Produto já está no carrinho.");
          continue;
        }

        cliente.adicionarProdutoCarrinho(encontrado);
        System.out.println("Produto adicionado ao carrinho.");
      } else if (escolha == 2) {
        if (!cliente.getCarrinho().getProdutos().contains(encontrado)) {
          System.err.println("Produto não está no carrinho.");
          continue;
        }

        cliente.removerProdutoCarrinho(encontrado);
        System.out.println("Produto removido do carrinho.");
      }
    }
  }

  public static void menuAtendente(Cliente cliente, Scanner scanner) {
    AtendenteVirtual atendente = cliente.getAtendente();
    if (atendente == null) {
      System.out.println("Você ainda não foi atribuído a um atendente.");
      return;
    }

    System.out.println(
        "\nOlá "
            + cliente.getNome()
            + ", eu sou seu/sua atendente virtual, meu nome é "
            + atendente.getNome()
            + ".");

    while (true) {
      System.out.println("\nO que gostaria de fazer?");
      System.out.println("1. Realizar pedido");
      System.out.println("2. Pagar pedidos");
      System.out.println("3. Voltar");
      System.out.print("Escolha uma opção: ");
      int opcao = scanner.nextInt();
      scanner.nextLine();

      switch (opcao) {
        case 1 -> {
          ArrayList<Produto> produtosCarrinho = new ArrayList<>();
          for (Produto p : cliente.getCarrinho().getProdutos()) {
            if (p.getPertenceAoPedido() == null) produtosCarrinho.add(p);
          }

          // Requisito 1: só pode realizar pedido com produtos no carrinho
          // Requisito 4: impede que tenha outro pedido de um mesmo produto
          if (produtosCarrinho.isEmpty()) {
            System.out.println("\nSeu carrinho está vazio ou os produtos já foram pedidos.");
            break;
          }

          // Requisito 1: só pode fazer pedido com endereço registrado
          if (cliente.getEndereco() == null) {
            System.out.println("\nVocê não possui um endereço registrado.");
            break;
          }

          FormaPagamento pagamento = null;
          while (true) {
            // Requisito 1: ao fazer pedido registra uma forma de pagamento
            System.out.println(
                "\nEscolha a forma de pagamento (1-PIX, 2-Crédito, 3-Débito, 4-Boleto): ");
            int escolhaFormaPagamento = scanner.nextInt();
            scanner.nextLine();

            if (escolhaFormaPagamento > 4 || escolhaFormaPagamento < 0) {
              System.out.println("Opção inválida.\n");
              continue;
            } else {
              pagamento = cliente.registrarFormaDePagamento(escolhaFormaPagamento);
              break;
            }
          }

          FormaEntrega entrega = null;
          while (true) {
            System.out.println("\nEscolha a forma de entrega (1-Padrão, 2-Rápida, 3-Retirada): ");
            int escolhaFormaEntrega = scanner.nextInt();
            scanner.nextLine();

            if (escolhaFormaEntrega > 3 || escolhaFormaEntrega < 0) {
              System.out.println("Opção inválida.\n");
              continue;
            } else {
              entrega = cliente.registrarFormaDeEntrega(escolhaFormaEntrega);
              break;
            }
          }

          Pedido pedido =
              atendente.realizarPedido(
                  pagamento, entrega, produtosCarrinho, cliente, cliente.getEndereco());
          produtosCarrinho.forEach(p -> p.setPertenceAoPedido(pedido));
          cliente.getCarrinho().esvaziarCarrinho();
          cliente.adicionarPedido(pedido);

          pedido.setNotaFiscal(
              new NotaFiscal(
                  pedido,
                  cliente)); // Requisito 9: gera nota fiscal apenas quando um pedido é gerado

          System.out.println(
              "Pedido registrado e nota fiscal gerada. Status: Aguardando pagamento.");
        }

        case 2 -> {
          ArrayList<Pedido> lista = cliente.getPedidos();
          if (lista == null || lista.isEmpty()) {
            System.out.println("\nNenhum pedido encontrado.");
            break;
          }

          ArrayList<Pedido> pendentes = new ArrayList<>();
          for (Pedido p : lista) {
            if (p.getStatus().equals("AGUARDANDO_PAGAMENTO")) pendentes.add(p);
          }

          if (pendentes.isEmpty()) {
            System.out.println("\nNenhum pedido pendente.");
            break;
          }

          System.out.println("\n=== PEDIDOS PENDENTES ===");
          for (Pedido p : pendentes) {
            System.out.printf("ID %d - Valor: R$ %.2f\n", p.getId(), p.getValorTotal());
          }

          while (true) {
            System.out.print("\nInforme o ID do pedido para pagar: ");
            long idEscolhido = scanner.nextLong();
            scanner.nextLine();

            Pedido pedidoSelecionado =
                pendentes.stream().filter(p -> p.getId() == idEscolhido).findFirst().orElse(null);

            if (pedidoSelecionado == null) {
              System.out.println("\nID inválido.");
              continue;
            } else {
              cliente.realizarPagamento(pedidoSelecionado);
              System.out.printf(
                  "\nPagamento confirmado. Valor final: R$ %.2f\n",
                  pedidoSelecionado.getValorTotal());
              break;
            }
          }
        }

        case 3 -> {
          return;
        }

        default -> System.out.println("\nOpção inválida.");
      }
    }
  }

  public static void menuEmitirNotaFiscal(Cliente cliente, Scanner scanner) {
    Interfaces.mostrarPedidos(cliente);
    ArrayList<Pedido> pedidos = cliente.getPedidos();

    if (pedidos == null || pedidos.isEmpty()) {
      System.out.println("Nenhum pedido encontrado para emitir nota fiscal.");
      return;
    }

    while (true) {
      System.out.print("\nInforme o ID do pedido para emitir a nota fiscal: ");
      long id = scanner.nextLong();
      scanner.nextLine();

      Pedido pedidoSelecionado =
          pedidos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);

      if (pedidoSelecionado == null) {
        System.out.println("ID inválido.");
        continue;
      } else {
        EmitirNotaFiscal.emitirNotaFiscal(pedidoSelecionado);
      }
    }
  }
}
