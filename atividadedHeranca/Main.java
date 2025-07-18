public class Main {
  public static void main(String[] args) {
    Desenvolvedor dev = new Desenvolvedor();

    dev.setNome("Caio");
    dev.setIdade(20);
    dev.setEndereco("Rua alguma coisa");
    dev.setEscolaridade("Ensino superior incompleto");

    dev.cadastrar("caio@email.com", "senha123", 1000, "Desenvolvedor");

    dev.login("caio@enail.com", "senha12");
    dev.login("caio@email.com", "senha23");
    dev.login("caio@imail.com", "senha123");
    dev.login("caio@email.com", "senha123");

    dev.salvarCodigo();

    dev.setCodigo("print('hello')");

    dev.salvarCodigo();

    dev.apresentar();

    Gerente gerente = new Gerente();

    gerente.setNome("João");
    gerente.setIdade(20);
    gerente.setEndereco("Rua outra coisa");
    gerente.setEscolaridade("Ensino superior completo");

    gerente.cadastrar("joao@email.com", "senha456", 1500, "Gerente");

    gerente.login("joao@enail.com", "senha12");
    gerente.login("joao@email.com", "senha23");
    gerente.login("joao@imail.com", "senha123");
    gerente.login("joao@email.com", "senha456");

    gerente.enviarRelatorio();

    gerente.setRelatorio("Funcionário " + dev.getNome() + " enviou o código.");

    gerente.enviarRelatorio();

    gerente.apresentar();
  }
}
