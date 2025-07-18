package br.com.sistemavendas.usuario;

import br.com.sistemavendas.produtos.Produto;
import br.com.sistemavendas.vendas.FormaEntrega;
import br.com.sistemavendas.vendas.FormaPagamento;
import br.com.sistemavendas.vendas.Pedido;
import java.util.ArrayList;

public class Cliente implements IPessoa {
  protected String nome; // Requisito 2: tem nome
  protected String email; // Requisito 2: tem e-mail
  protected String senha;
  protected boolean autenticado = false;
  protected Endereco endereco; // Requisito 2: tem endereço
  protected Carrinho carrinho;
  private AtendenteVirtual atendente; // Requisito 5: cliente possui um atendente
  private ArrayList<Pedido> pedidos =
      new ArrayList<>(); // Requisito 4: cliente pode fazer vários pedidos

  public void criarConta(String nome, String email, String senha) {
    this.nome = nome;
    this.email = email;
    this.senha = senha;
    this.carrinho = new Carrinho(this);
  }

  public void adicionarProdutoCarrinho(Produto produto) {
    this.carrinho.getProdutos().add(produto);
  }

  public void removerProdutoCarrinho(Produto produto) {
    this.carrinho.getProdutos().remove(produto);
  }

  public void realizarPagamento(Pedido pedido) {
    pedido.setStatus("PAGO");
  }

  public void adicionarPedido(Pedido pedido) {
    this.pedidos.add(pedido);
  }

  public void fazerLogout() {
    this.autenticado = false;
  }

  public Endereco registrarEndereco(String rua, int numero, String complemento) {
    return new Endereco(rua, numero, complemento);
  }

  public FormaPagamento registrarFormaDePagamento(int opcao) {
    switch (opcao) {
      case 1:
        return FormaPagamento.PIX;

      case 2:
        return FormaPagamento.CARTAO_CREDITO;

      case 3:
        return FormaPagamento.CARTAO_DEBITO;

      case 4:
        return FormaPagamento.BOLETO;

      default:
        return null;
    }
  }

  public FormaEntrega registrarFormaDeEntrega(int opcao) {
    switch (opcao) {
      case 1:
        return FormaEntrega.ENTREGA_PADRAO;

      case 2:
        return FormaEntrega.ENTREGA_RAPIDA;

      case 3:
        return FormaEntrega.RETIRADA;

      default:
        return null;
    }
  }

  public boolean fazerLogin(String email, String senha) {
    if (this.email.equals(email) && this.senha.equals(senha)) {
      this.autenticado = true;
      return true;
    }
    return false;
  }

  public boolean isAutenticado() {
    return this.autenticado;
  }

  // Métodos GET
  public ArrayList<Pedido> getPedidos() {
    return this.pedidos;
  }

  public String getNome() {
    return this.nome;
  }

  public Carrinho getCarrinho() {
    return this.carrinho;
  }

  public Endereco getEndereco() {
    return this.endereco;
  }

  public AtendenteVirtual getAtendente() {
    return this.atendente;
  }

  // Métodos SET
  public void setAtendente(AtendenteVirtual atendente) {
    this.atendente = atendente;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }
}
