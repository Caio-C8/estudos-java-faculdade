class Cliente {
  String nomeTitular;
  String cpf;
  String rg;
  String endereco;
  String dataNascimento;
  String numeroCelular;

  void consultarDados(Conta conta) {
    System.out.println("\t\tDados do cliente");
    System.out.println("Nome do titular: " + this.nomeTitular);
    System.out.println("CPF: " + this.cpf);
    System.out.println("RG: " + this.rg);
    System.out.println("Endereço: " + this.endereco);
    System.out.println("Data de nascimneto: " + this.dataNascimento);
    System.out.println("Celular: " + this.numeroCelular + "\n");

    System.out.println("\t\tDados da conta");
    System.out.println("Tipo da conta: " + conta.tipoConta);
    System.out.println("Número da agência: " + conta.agencia);
    System.out.println("Número da conta: " + conta.numeroConta);
    System.out.println("Saldo disponível: R$ " + conta.saldo + "\n");
  }
}
