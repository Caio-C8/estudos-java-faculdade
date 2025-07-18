public class Desenvolvedor extends Funcionario {
  private String codigo;

  public void salvarCodigo() {
    String codigoDev = getCodigo();
    if (codigoDev != null) {
      System.out.println("Código " + codigoDev + " salvo.");
    } else {
      System.out.println("Não há codigo para salvar.");
    }
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }
}
