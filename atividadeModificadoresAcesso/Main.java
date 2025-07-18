public class Main {
  public static void main(String[] args) {
    Funcionario funcionario1 = new Funcionario();

    funcionario1.setNome("Fulano");
    funcionario1.setCpf("123.123.123-12");

    System.out.println(funcionario1.getNome());
    System.out.println(funcionario1.getCpf());

    funcionario1.promocaoCargo("Analista de dados", 5000);

    System.out.println(funcionario1.getCargo());
    System.out.println(funcionario1.getSalario());

    funcionario1.promocaoCargo("Dono da empresa", 1000000);

    System.out.println(funcionario1.getCargo());
    System.out.println(funcionario1.getSalario());
  }
}
