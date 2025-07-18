package br.com.sistemavendas.utilidades;

import br.com.sistemavendas.produtos.Catalogo;
import br.com.sistemavendas.produtos.Produto;
import br.com.sistemavendas.usuario.Cliente;
import br.com.sistemavendas.usuario.Endereco;
import br.com.sistemavendas.vendas.FormaEntrega;
import br.com.sistemavendas.vendas.Pedido;
import java.util.ArrayList;

public class Interfaces {
  public static void mostrarCatalogo(Catalogo catalogo) {
    System.out.println("\n=== CATÁLOGO ===");
    for (Produto p : catalogo.getProdutos()) {
      System.out.printf("ID %d - %s - R$ %.2f\n", p.getId(), p.getNome(), p.getPreco());
    }
  }

  public static void mostrarEndereco(Cliente cliente) {
    System.out.printf("\nEndereço cadastrado: %s\n", formatarEndereco(cliente.getEndereco()));
  }

  public static void mostrarPedidos(Cliente cliente) {
    System.out.print("\n=== MEUS PEDIDOS ===");
    ArrayList<Pedido> lista = cliente.getPedidos();
    if (lista == null || lista.isEmpty()) {
      System.out.println("\nNenhum pedido encontrado.");
      return;
    }

    for (Pedido pedido : lista) {
      String stringEndereco = "";
      if (pedido.getFormaEntrega().equals(FormaEntrega.RETIRADA)) {
        stringEndereco = "Retirada";
      } else {
        stringEndereco = formatarEndereco(cliente.getEndereco());
      }

      System.out.printf(
          "\nPedido %d: %s - %s\n", pedido.getId(), cliente.getNome(), stringEndereco);

      for (Produto p : pedido.getProdutos()) {
        System.out.printf("-ID %d - %s - R$ %.2f\n", p.getId(), p.getNome(), p.getPreco());
      }

      if (pedido.getStatus().equals("AGUARDANDO_PAGAMENTO")) {
        System.out.printf("Pagamento pendete de: R$ %.2f\n", pedido.getValorTotal());
      } else {
        System.out.printf("Valor pago: R$ %.2f\n", pedido.getValorTotal());
      }
    }
  }

  private static String formatarEndereco(Endereco e) {
    return e != null
        ? e.getRua() + ", " + e.getNumero() + ", " + e.getComplemento()
        : "sem endereço";
  }
}
