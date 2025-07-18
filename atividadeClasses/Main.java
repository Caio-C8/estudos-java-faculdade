class Main {
  public static void main(String[] args) {
    // Atribuições
    Cliente cliente1 = new Cliente();
    cliente1.nomeTitular = "João";
    cliente1.cpf = "123.456.789-01";
    cliente1.rg = "12.345.678-9";
    cliente1.endereco = "Rua alguma coisa";
    cliente1.dataNascimento = "01/01/1999";
    cliente1.numeroCelular = "(00) 00000-0000";

    Conta contaCliente1 = new Conta();
    contaCliente1.tipoConta = "corrente";
    contaCliente1.agencia = "1234-5";
    contaCliente1.numeroConta = "12345678901-12";
    contaCliente1.saldo = 1000;
    // Atribuições

    // Métodos
    cliente1.consultarDados(contaCliente1);

    contaCliente1.consultarSaldo();

    contaCliente1.depositar(100);
    contaCliente1.consultarSaldo();

    contaCliente1.sacar(200);
    contaCliente1.consultarSaldo();
    // Métodos
  }
}
