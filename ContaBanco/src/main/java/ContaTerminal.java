import java.math.BigDecimal;
import java.util.Scanner;

public class ContaTerminal {

    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);

        int numero = 0;
        String agencia = "";
        String nome = "";
        BigDecimal saldo = BigDecimal.ZERO;

        System.out.printf("Por favor, digite o número da Agência:\n");
        agencia = leitura.next();

        System.out.printf("Por favor, digite o número da Conta:\n");
        numero = Integer.parseInt(leitura.next());

        System.out.printf("Por favor, informe seu nome:\n");
        nome = leitura.next();

        System.out.printf("Digite o valor que deseja depositar:\n");
        saldo = new BigDecimal(leitura.next());

        System.out.printf("Olá " + nome +", obrigado por criar uma conta em nosso banco, sua agência é " + agencia + ", conta " + numero + " e seu saldo " + saldo + " já está disponível para saque.");
    }
}