package br.com.sistemavendas.usuario;

import br.com.sistemavendas.produtos.Produto;
import java.util.ArrayList;

public class Carrinho {
  private double valorTotal;
  private ArrayList<Produto> produtos = new ArrayList<>();
  private Cliente cliente;

  public Carrinho(Cliente cliente) {
    this.cliente = cliente;
  }

  public void esvaziarCarrinho() {
    this.produtos.clear();
  }

  // Métodos GET
  public ArrayList<Produto> getProdutos() {
    return this.produtos;
  }
}
