package OperacoesBancarias;

import java.util.Scanner;

public class VerificacaoChequeEspecial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double saldo = scanner.nextDouble();
        double saque = scanner.nextDouble();
        double limiteChequeEspecial = 500;

        // TODO: Verifique se o saque não ultrapassa o saldo disponível na conta:

        // TODO: Verifique se o saque ultrapassa o limite do cheque especial, mas não o saldo total disponível:

        if(saque > saldo) {
            if(saque > (limiteChequeEspecial + saldo)) {
                // Se o saque ultrapassar tanto o saldo disponível quanto o limite do cheque especial
                System.out.println("Transacao nao realizada. Limite do cheque especial excedido.");
            } else {
                System.out.println("Transacao realizada com sucesso utilizando o cheque especial.");
            }
        } else {
            System.out.println("Transacao realizada com sucesso.");
        }


// Fechamos o objeto Scanner para liberar os recursos:
        scanner.close();
    }
}