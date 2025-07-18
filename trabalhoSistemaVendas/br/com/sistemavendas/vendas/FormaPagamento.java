package br.com.sistemavendas.vendas;

// Requisito 7: forma de entrega pode ser pix, cartão de crédito, cartão de débito ou boleto
public enum FormaPagamento {
  PIX,
  CARTAO_CREDITO,
  CARTAO_DEBITO,
  BOLETO;

  public double pagarPix(double valor) {
    return valor * 0.85; // Requisito 8: se for pix, 15% de desconto
  }

  public double pagarCartaoCredito(double valor) {
    return valor * 1.05;
  }

  public double pagarCartaoDebito(double valor) {
    return valor * 1.05;
  }

  public double pagarBoleto(double valor) {
    return valor;
  }
}
