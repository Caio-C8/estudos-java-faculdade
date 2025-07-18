public class Moto implements IVeiculo {
  @Override
  public void acelerar() {
    System.out.println("vrooom");
  }

  @Override
  public void frear() {
    System.out.println("*moto freando*");
  }

  public void darGrau() {
    System.out.println("*dando grau*");
  }
}
