public class Automovel {
  private IVeiculo veiculo;

  public Automovel(IVeiculo veiculo) {
    this.veiculo = veiculo;
  }

  public void acelerar() {
    veiculo.acelerar();
  }

  public void frear() {
    veiculo.frear();
  }

  public void carregarBateria(double kilowatts) {
    if (veiculo instanceof IVeiculoEletrico) {
      ((IVeiculoEletrico) veiculo).carregarBateria(kilowatts);
    } else {
      System.out.println("Este veículo não é elétrico.");
    }
  }

  public void verificarNivelBateria() {
    if (veiculo instanceof IVeiculoEletrico) {
      ((IVeiculoEletrico) veiculo).verificarNivelBateria();
    } else {
      System.out.println("Este veículo não possui bateria.");
    }
  }

  public void ligarArCondicionado() {
    if (veiculo instanceof Carro) {
      ((Carro) veiculo).ligarArCondicionado();
    } else {
      System.out.println("Este veículo não possui ar condicionado.");
    }
  }

  public void darGrau() {
    if (veiculo instanceof Moto) {
      ((Moto) veiculo).darGrau();
    } else {
      System.out.println("Este veículo não consegue dar grau.");
    }
  }

  public void ativarModoEconomico() {
    if (veiculo instanceof CarroEletrico) {
      ((CarroEletrico) veiculo).ativarModoEconomico();
    } else {
      System.out.println("Este veículo não possui modo econômico.");
    }
  }
}
