public class Main {
  public static void main(String[] args) {
    Automovel carro = new Automovel(new Carro());
    Automovel moto = new Automovel(new Moto());
    Automovel carroEletrico = new Automovel(new CarroEletrico());

    System.out.println("\n---Teste Carro---");
    carro.acelerar();
    carro.frear();
    carro.ligarArCondicionado();
    carro.darGrau();
    carro.carregarBateria(100);
    carro.verificarNivelBateria();
    carro.ativarModoEconomico();

    System.out.println("\n---Teste Moto---");
    moto.acelerar();
    moto.frear();
    moto.darGrau();
    moto.ligarArCondicionado();
    moto.carregarBateria(100);
    moto.verificarNivelBateria();
    moto.ativarModoEconomico();

    System.out.println("\n---Teste Carro Elétrico---");
    carroEletrico.acelerar();
    carroEletrico.frear();
    carroEletrico.verificarNivelBateria();
    carroEletrico.carregarBateria(100);
    carroEletrico.verificarNivelBateria();
    carroEletrico.ativarModoEconomico();
    carroEletrico.darGrau();
    carroEletrico.ligarArCondicionado();
  }
}
