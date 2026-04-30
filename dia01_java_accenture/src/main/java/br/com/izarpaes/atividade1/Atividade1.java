package br.com.izarpaes.atividade1;

import java.util.Scanner;

public class Atividade1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int precoClasseA = 50;
        int precoClasseB = 30;
        int precoClasseC = 20;

        System.out.print("quantos bilhetes da classe A ? ");
        int bilhetesA = scanner.nextInt();
        System.out.print("quantos bilhetes da classe B ? ");
        int bilhetesB = scanner.nextInt();
        System.out.print("quantos bilhetes da classe C ? ");
        int bilhetesC = scanner.nextInt();

        int rendaTotal = (bilhetesA * precoClasseA) +
                (bilhetesB * precoClasseB) +
                (bilhetesC * precoClasseC);


        System.out.println("A renda total gerada pela venda dos ingressos é: R$ "+rendaTotal);

    }
}