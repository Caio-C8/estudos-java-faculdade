package br.com.sistemavendas.usuario;

import br.com.sistemavendas.produtos.Produto;
import br.com.sistemavendas.vendas.FormaEntrega;
import br.com.sistemavendas.vendas.FormaPagamento;

public interface IPessoa {
  public void criarConta(String nome, String email, String senha);

  public void adicionarProdutoCarrinho(Produto produto);

  public Endereco registrarEndereco(String rua, int numero, String complemento);

  public FormaPagamento registrarFormaDePagamento(int opcao);

  public FormaEntrega registrarFormaDeEntrega(int opcao);

  public boolean fazerLogin(String email, String senha);
}
