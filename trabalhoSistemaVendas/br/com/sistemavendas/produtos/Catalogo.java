package br.com.sistemavendas.produtos;

import java.util.ArrayList;

public class Catalogo {
  private ArrayList<Produto> produtos = new ArrayList<>();

  public void adicionarAoCatalogo(Produto produto) {
    this.produtos.add(produto);
  }

  public ArrayList<Produto> getProdutos() {
    return this.produtos;
  }
}
