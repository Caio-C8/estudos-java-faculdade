package br.com.sistemavendas.usuario;

public class PessoaFisica extends Cliente {
  private String cpf; // Requisito 2: pode ser pessoa física

  public static PessoaFisica criarConta(String nome, String usuario, String senha, String cpf) {
    PessoaFisica pf = new PessoaFisica();
    pf.criarConta(nome, usuario, senha);
    pf.cpf = cpf;
    return pf;
  }
}
