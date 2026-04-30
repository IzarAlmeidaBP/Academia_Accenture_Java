package br.com.izarpaes.atividade2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1:Somar | 2:Subtrair | 3:Multiplicar | 4:Dividir");
        System.out.print("Escolha a operação: ");
        int opcao = scanner.nextInt();

        System.out.print("Digite o primeiro número: ");
        double num1 = scanner.nextDouble();

        System.out.print("Digite o segundo número: ");
        double num2 = scanner.nextDouble();

        System.out.print("Resultado: ");

        switch (opcao) {
            case 1:
                System.out.println(num1 + num2);
                break;
            case 2:
                System.out.println(num1 - num2);
                break;
            case 3:
                System.out.println(num1 * num2);
                break;
            case 4:
                if (num2 != 0) {
                    System.out.println(num1 / num2);
                } else {
                    System.out.println("Erro (Divisão por zero)");
                }
                break;
            default:
                System.out.println("Operação inválida!");
        }
    }
}