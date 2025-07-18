package br.com.sistemavendas.usuario;

public class PessoaJuridica extends Cliente {
  private String cnpj; // Requisito 3: pode ser empresa

  public static PessoaJuridica criarConta(String nome, String usuario, String senha, String cnpj) {
    PessoaJuridica pj = new PessoaJuridica();
    pj.criarConta(nome, usuario, senha);
    pj.cnpj = cnpj;
    return pj;
  }
}
