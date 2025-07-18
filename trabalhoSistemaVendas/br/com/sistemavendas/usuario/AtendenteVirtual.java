package br.com.sistemavendas.usuario;

import br.com.sistemavendas.produtos.Produto;
import br.com.sistemavendas.vendas.FormaEntrega;
import br.com.sistemavendas.vendas.FormaPagamento;
import br.com.sistemavendas.vendas.Pedido;
import java.util.ArrayList;

public class AtendenteVirtual {
  private String nome;
  private ArrayList<Cliente> clientes =
      new ArrayList<>(); // Requisito 5: atendente possui vários clientes

  public AtendenteVirtual(String nome) {
    this.nome = nome;
  }

  public Pedido realizarPedido(
      FormaPagamento formaPagamento,
      FormaEntrega formaEntrega,
      ArrayList<Produto> produtos,
      Cliente cliente,
      Endereco endereco) {
    return new Pedido(formaPagamento, formaEntrega, produtos, cliente, endereco);
  }

  // Métodos GET
  public ArrayList<Cliente> getClientes() {
    return this.clientes;
  }

  public String getNome() {
    return this.nome;
  }

  // Métodos SET
  public void setClientes(Cliente cliente) {
    this.clientes.add(cliente);
  }
}
