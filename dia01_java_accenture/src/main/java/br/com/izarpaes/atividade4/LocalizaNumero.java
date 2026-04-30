package br.com.izarpaes.atividade4;

import java.util.Scanner;

public class LocalizaNumero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vetor[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.print("Digite o número que deseja pesquisar: ");
        int numero = scanner.nextInt();

        boolean achou = false;
        int i;

        for (i = 0; i < 10; i++) {
            if (vetor[i] == numero) {
                achou = true;
                break;
            }
        }

        if (achou) {
            System.out.println("Achei");
            System.out.printf("Na Posição %d está localizado do numero %d.", i, vetor[i]);
        }

        scanner.close();
    }
}