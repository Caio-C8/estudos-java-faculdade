package br.com.sistemavendas.utilidades;

import br.com.sistemavendas.produtos.Produto;
import br.com.sistemavendas.vendas.Pedido;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class EmitirNotaFiscal {
  public static void emitirNotaFiscal(Pedido pedido) {
    String nomeArquivo = "notas/nota_pedido_" + pedido.getId() + ".txt";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    try {
      File pastaNotas = new File("notas");
      if (!pastaNotas.exists()) {
        pastaNotas.mkdirs();
      }

      BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo));

      writer.write("===== NOTA FISCAL =====\n");
      writer.write("Pedido ID: " + pedido.getId() + "\n");
      writer.write("Cliente: " + pedido.getCliente().getNome() + "\n");
      writer.write("Data: " + pedido.getDataRealizacaoPedido().format(formatter) + "\n\n");

      writer.write("Produtos:\n");
      for (Produto p : pedido.getProdutos()) {
        writer.write(String.format("- ID %d %s - R$ %.2f\n", p.getId(), p.getNome(), p.getPreco()));
      }

      writer.write(String.format("\nTotal Pago: R$ %.2f\n", pedido.getValorTotal()));
      writer.write("Forma de Pagamento: " + pedido.getFormaPagamento() + "\n");
      writer.write("Status: " + pedido.getStatus() + "\n");

      writer.close();
      System.out.println("Nota fiscal salva em: " + nomeArquivo);
    } catch (IOException e) {
      System.err.println("Erro ao gerar nota fiscal: " + e.getMessage());
    }
  }
}
