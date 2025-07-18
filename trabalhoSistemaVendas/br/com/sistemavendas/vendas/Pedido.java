package br.com.sistemavendas.vendas;

import br.com.sistemavendas.produtos.Produto;
import br.com.sistemavendas.usuario.Cliente;
import br.com.sistemavendas.usuario.Endereco;
import java.time.LocalDate;
import java.util.ArrayList;

public class Pedido {
  private static long contadorId = 1;
  private final long id;

  private FormaPagamento formaPagamento;
  private FormaEntrega formaEntrega;
  private ArrayList<Produto> produtos = new ArrayList<>();
  private Cliente cliente; // Requisito 4: o pedido pertencea apenas um cliente
  private Endereco endereco;
  private double valorTotal;
  private LocalDate dataRealizacaoPedido = LocalDate.now();
  private String status = "AGUARDANDO_PAGAMENTO";
  private NotaFiscal notaFiscal;

  public Pedido(
      FormaPagamento formaPagamento,
      FormaEntrega formaEntrega,
      ArrayList<Produto> produtos,
      Cliente cliente,
      Endereco endereco) {
    this.id = contadorId++;
    this.formaPagamento = formaPagamento;
    this.formaEntrega = formaEntrega;
    this.produtos = produtos;
    this.cliente = cliente;
    this.endereco = endereco;

    for (Produto p : produtos) {
      this.valorTotal += p.getPreco();
    }

    if (formaPagamento.equals(FormaPagamento.PIX)) {
      this.valorTotal = formaPagamento.pagarPix(valorTotal);
    } else if (formaPagamento.equals(FormaPagamento.CARTAO_CREDITO)) {
      this.valorTotal = formaPagamento.pagarCartaoCredito(valorTotal);
    } else if (formaPagamento.equals(FormaPagamento.CARTAO_DEBITO)) {
      this.valorTotal = formaPagamento.pagarCartaoDebito(valorTotal);
    } else {
      this.valorTotal = formaPagamento.pagarBoleto(valorTotal);
    }
  }

  // Métodos GET
  public long getId() {
    return this.id;
  }

  public double getValorTotal() {
    return this.valorTotal;
  }

  public LocalDate getDataRealizacaoPedido() {
    return this.dataRealizacaoPedido;
  }

  public ArrayList<Produto> getProdutos() {
    return this.produtos;
  }

  public String getStatus() {
    return status;
  }

  public FormaPagamento getFormaPagamento() {
    return this.formaPagamento;
  }

  public FormaEntrega getFormaEntrega() {
    return this.formaEntrega;
  }

  public NotaFiscal getNotaFiscal() {
    return this.notaFiscal;
  }

  public Cliente getCliente() {
    return this.cliente;
  }

  // Métodos SET
  public void setStatus(String status) {
    this.status = status;
  }

  public void setNotaFiscal(NotaFiscal notaFiscal) {
    this.notaFiscal = notaFiscal;
  }
}
