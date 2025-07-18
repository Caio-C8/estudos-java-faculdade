// Faça um programa que leia 3 números e imprima o
// maior usando apenas if-else

import java.util.Scanner;

public class NumeroMaior {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    double[] nums = new double[3];

    for (int i = 0; i < 3; i++) {
      System.out.print("Numero " + (i + 1) + ": ");
      nums[i] = scanner.nextDouble();
    }

    if (nums[0] > nums[1] && nums[0] > nums[2]) {
      System.out.println(nums[0] + " é o maior");
    } else if (nums[1] > nums[2]) {
      System.out.println(nums[1] + " é o maior");
    } else {
      System.out.println(nums[2] + " é o maior");
    }

    scanner.close();
  }
}
