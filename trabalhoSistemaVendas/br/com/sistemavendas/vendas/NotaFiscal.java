package br.com.sistemavendas.vendas;

import br.com.sistemavendas.usuario.Cliente;

public class NotaFiscal {
  private Pedido pedido;
  private Cliente cliente;

  public NotaFiscal(Pedido pedido, Cliente cliente) {
    this.pedido = pedido;
    this.cliente = cliente;
  }
}
