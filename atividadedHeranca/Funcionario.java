public class Funcionario extends Pessoa {
  private String email;
  private String senha;
  private double salario;
  private String tipo;

  public void login(String email, String senha) {
    String emailOriginal = getEmail();
    String senhaOriginal = getSenha();

    if (emailOriginal != email || senhaOriginal != senha) {
      System.out.println("E-mail ou senha incorretos.");
    } else {
      System.out.println("Login realizado com sucesso.");
    }
  }

  public void cadastrar(String email, String senha, double salario, String tipo) {
    setEmail(email);
    setSenha(senha);
    setSalario(salario);
    setTipo(tipo);

    String nomeFuncionario = getNome();

    System.out.println("Funcionário " + nomeFuncionario + " foi cadastrado.");
  }

  public void apresentar() {
    String nomeFuncionario = getNome();
    int idadeFuncionario = getIdade();
    String enderecoFuncionario = getEndereco();
    String escolaridadeFuncionario = getEscolaridade();
    double salarioFuncionario = getSalario();
    String tipoFuncionario = getTipo();

    System.out.println("Nome: " + nomeFuncionario);
    System.out.println("Idade: " + idadeFuncionario);
    System.out.println("Endereço: " + enderecoFuncionario);
    System.out.println("Escolaridade: " + escolaridadeFuncionario);
    System.out.println("Salário: R$" + salarioFuncionario);
    System.out.println("Tipo de Funcionário: " + tipoFuncionario);
  }

  public String getEmail() {
    return email;
  }

  public String getSenha() {
    return senha;
  }

  private void setEmail(String email) {
    this.email = email;
  }

  private void setSenha(String senha) {
    this.senha = senha;
  }

  private void setSalario(double salario) {
    this.salario = salario;
  }

  private void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public double getSalario() {
    return this.salario;
  }

  public String getTipo() {
    return this.tipo;
  }
}
