public class CarroEletrico implements IVeiculo, IVeiculoEletrico {
  private double bateria = 0;

  @Override
  public void acelerar() {
    System.out.println("zooom");
  }

  @Override
  public void frear() {
    System.out.println("*carro elétrico freando*");
  }

  @Override
  public void carregarBateria(double kilowatts) {
    this.bateria = this.bateria + kilowatts;
    System.out.println("Nível de bateria aumentado em " + kilowatts + " KW");
  }

  @Override
  public void verificarNivelBateria() {
    System.out.println("Nível de bateria: " + this.bateria + " KW");
  }

  public void ativarModoEconomico() {
    System.out.println("*ativando modo econômico*");
  }
}
