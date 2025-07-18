package br.com.sistemavendas.produtos;

import br.com.sistemavendas.vendas.Pedido;

public class Produto {
  private static long contadorId = 1;
  private final long id;

  private String nome;
  private double preco;
  private Pedido pertenceAoPedido = null;

  public Produto(String nome, double preco) {
    this.id = contadorId++;
    this.nome = nome;
    this.preco = preco;
  }

  // Métodos GET
  public double getPreco() {
    return this.preco;
  }

  public String getNome() {
    return this.nome;
  }

  public Pedido getPertenceAoPedido() {
    return this.pertenceAoPedido;
  }

  public long getId() {
    return this.id;
  }

  // Métodos SET
  public void setPertenceAoPedido(Pedido pedido) {
    this.pertenceAoPedido = pedido;
  }
}
