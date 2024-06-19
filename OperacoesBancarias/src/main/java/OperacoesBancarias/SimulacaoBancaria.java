package OperacoesBancarias;

import java.util.Scanner;

public class SimulacaoBancaria {

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);

        double saldo = 0;
        double saque = 0;

        // Loop infinito para manter o programa em execução até que o usuário decida sair
        while (true) {

            int opcao = scanner.nextInt();

            // TODO: Implemente as condições necessárias para avaliaa a opção escolhida:
            // Dica: Utilze o switch/case para o programa realizar as operações escolhidas pelo usuário.

            switch (opcao) {

                case 1: //DEPOSITAR
                    saldo = scanner.nextDouble();
                    System.out.println("Saldo atual: " + saldo);
                    break;

                case 2: //SACAR
                    saque = scanner.nextDouble();

                    if(saque > saldo) {
                        System.out.println("Saldo insuficiente.");
                    } else {
                        System.out.println("Saldo atual: " + (saldo - saque));
                    }

                    break;

                case 3: //CONSULTAR SALDO
                    System.out.println("Saldo atual: " + (saldo - saque));
                    break;

                case 0: //ENCERRAR
                    System.out.println("Programa encerrado.");
                    saque = 0;
                    saldo = 0;
                    scanner.close(); // Fechar o scanner antes de sair
                    return; // Sai do método main

                // Exibe mensagem de opção inválida se o usuário escolher uma opção inválida:
                default:
                    System.out.println("Programa encerrado.");
                    break;
            }
        }
    }


}