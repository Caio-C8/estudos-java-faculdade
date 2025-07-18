public class Gerente extends Funcionario {
  private String relatorio;

  public void enviarRelatorio() {
    String relatorioGerente = getRelatorio();

    if (relatorioGerente != null) {
      System.out.println("Relatório: " + relatorioGerente + "; foi enviado.");
    } else {
      System.out.println("Não há relatório para enviar.");
    }
  }

  public String getRelatorio() {
    return this.relatorio;
  }

  public void setRelatorio(String relatorio) {
    this.relatorio = relatorio;
  }
}
