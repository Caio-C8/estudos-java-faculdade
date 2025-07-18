public class Funcionario {
  String nome;
  String cpf;
  String cargo;
  double salario;

  public void promocaoCargo(String novoCargo, double novoSalario) {
    this.cargo = novoCargo;
    aumentaSalario(novoSalario);
    System.out.println(
        "Promoção para o cargo " + novoCargo + " e salário aumentado para R$ " + novoSalario);
  }

  private void aumentaSalario(double novoSalario) {
    this.salario = novoSalario;
  }

  public String getNome() {
    return nome;
  }

  public String getCargo() {
    return cargo;
  }

  public double getSalario() {
    return salario;
  }

  public String getCpf() {
    return cpf;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
}
