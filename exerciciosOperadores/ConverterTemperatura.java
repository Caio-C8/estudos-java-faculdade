// Faça um programa que peça a temperatura em graus
// Fahrenheit, transforme e mostre a temperatura em
// graus Celsius.

import java.util.Scanner;

public class ConverterTemperatura {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Temperatura em farenheit: ");
    float tempFa = scanner.nextFloat();

    float tempCel = (tempFa - 32) * 5 / 9;

    System.out.println("Temperatura farenheit em celsius: " + tempCel);

    scanner.close();
  }
}
