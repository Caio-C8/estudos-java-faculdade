public class Carro implements IVeiculo {
  @Override
  public void acelerar() {
    System.out.println("vruuum");
  }

  @Override
  public void frear() {
    System.out.println("*carro freando*");
  }

  public void ligarArCondicionado() {
    System.out.println("*ligando ar condicionado*");
  }
}
