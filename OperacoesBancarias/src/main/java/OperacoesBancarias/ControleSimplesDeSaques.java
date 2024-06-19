package OperacoesBancarias;
import java.util.Scanner;

public class ControleSimplesDeSaques {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double limiteDiario = scanner.nextDouble();
        double valorSaque = 0;

            // TODO: Implemente as condições necessárias para avaliaa a opção escolhida:
            // Dica: Utilze o switch/case para o programa realizar as operações escolhidas pelo usuário.

// TODO: Crie um loop 'for' para iterar sobre os saques:
            for (int i = 0; i <= 3; i++) {
                valorSaque = scanner.nextDouble();

                if (valorSaque == 0) {
                    System.out.println("Transacoes encerradas.");
                    return;
                }

                if (valorSaque > limiteDiario) {
                    System.out.println("Limite diario de saque atingido. Transacoes encerradas.");
                    return;
                } else {
                    limiteDiario = limiteDiario - valorSaque;
                    System.out.println("Saque realizado. Limite restante: " + limiteDiario);
                }

            }

    }
}
