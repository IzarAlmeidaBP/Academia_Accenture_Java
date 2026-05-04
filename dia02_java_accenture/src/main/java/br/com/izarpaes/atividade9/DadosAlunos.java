package br.com.izarpaes.atividade9;

import java.util.Scanner;

public class DadosAlunos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quantidadeAlunos = 0;

        while (quantidadeAlunos <= 0) {
            System.out.print("Digite a quantidade de alunos: ");
            try {
                quantidadeAlunos = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                quantidadeAlunos = 0;
            }
        }

        String[] nomes = new String[quantidadeAlunos];
        double[][] notas = new double[quantidadeAlunos][3];
        double[] medias = new double[quantidadeAlunos];
        String[] status = new String[quantidadeAlunos];

        double maiorMedia = -1;
        double menorMedia = 101;
        double somaGeral = 0;
        int aprovados = 0, emRecuperacao = 0, reprovados = 0;

        for (int i = 0; i < quantidadeAlunos; i++) {
            nomes[i] = "";
            while (nomes[i].length() < 3) {
                System.out.print("Nome do aluno " + (i + 1) + ": ");
                nomes[i] = scanner.nextLine();
            }

            double somaNotas = 0;
            for (int j = 0; j < 3; j++) {
                notas[i][j] = -1;
                while (notas[i][j] < 0 || notas[i][j] > 100) {
                    System.out.print("Nota " + (j + 1) + ": ");
                    try {
                        notas[i][j] = Double.parseDouble(scanner.nextLine());
                    } catch (Exception e) {
                        notas[i][j] = -1;
                    }
                }
                somaNotas += notas[i][j];
            }

            medias[i] = somaNotas / 3.0;
            somaGeral += medias[i];

            maiorMedia = Math.max(maiorMedia, medias[i]);
            menorMedia = Math.min(menorMedia, medias[i]);

            int categoria = (int) (medias[i] / 10);
            switch (categoria) {
                case 10: case 9: case 8: case 7:
                    status[i] = "APROVADO";
                    aprovados++;
                    break;
                case 6: case 5:
                    status[i] = "RECUPERAÇÃO";
                    emRecuperacao++;
                    break;
                default:
                    status[i] = "REPROVADO";
                    reprovados++;
                    break;
            }
        }

        System.out.println("\n Relatório");
        for (int i = 0; i < quantidadeAlunos; i++) {
            System.out.printf("%s | Notas: %.1f, %.1f, %.1f | Média: %.2f | %s\n",
                    nomes[i], notas[i][0], notas[i][1], notas[i][2], medias[i], status[i]);
        }

        System.out.println("\n Estatísticas");
        System.out.printf("Maior média: %.2f\n", maiorMedia);
        System.out.printf("Menor média: %.2f\n", menorMedia);
        System.out.printf("Média geral da turma: %.2f\n", (somaGeral / quantidadeAlunos));

        System.out.println("\n Resultado");
        System.out.println("Quantidade de alunos:");
        System.out.println("APROVADOS: " + aprovados);
        System.out.println("RECUPERAÇÃO: " + emRecuperacao);
        System.out.println("REPROVADOS: " + reprovados);

        System.out.println("\n Melhores alunos");
        for (int i = 0; i < quantidadeAlunos; i++) {
            while (medias[i] == maiorMedia) {
                System.out.println(nomes[i]);
                break;
            }
        }

        scanner.close();
    }
}