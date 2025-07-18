package br.com.sistemavendas.usuario;

public class Endereco {
  private String rua;
  private int numero;
  private String complemento;

  public Endereco(String rua, int numero, String complemento) {
    this.rua = rua;
    this.numero = numero;
    this.complemento = complemento;
  }

  public String getRua() {
    return rua;
  }

  public int getNumero() {
    return numero;
  }

  public String getComplemento() {
    return complemento;
  }
}
