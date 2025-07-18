class Conta {
  String tipoConta;
  String agencia;
  String numeroConta;
  double saldo;

  void consultarSaldo() {
    System.out.println("Saldo da conta: R$ " + this.saldo + "\n");
  }

  void depositar(double valor) {
    double novoSaldo = this.saldo + valor;
    this.saldo = novoSaldo;
    System.out.println("Foi depositado um valor de R$ " + valor + "\n");
  }

  void sacar(double valor) {
    double novoSaldo = this.saldo - valor;
    this.saldo = novoSaldo;
    System.out.println("Foi sacado um valor de R$ " + valor + "\n");
  }
}
