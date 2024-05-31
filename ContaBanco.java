package TratamentoExcecoes;

import java.util.Locale;
import java.util.Scanner;

import Model.Treatment.BusinessException;
import entities.Treatment.Account;

public class ContaBanco {

    public static void main(String[] args) {
        
        // Define a localização padrão como Estados Unidos para configurar a formatação de números
        Locale.setDefault(Locale.US);
        
        // Cria um objeto Scanner para ler a entrada do usuário a partir do console
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe os dados da conta");
        
        // Solicita e lê o número da conta
        System.out.print("Numero: ");
        int number = sc.nextInt();
        
        // Limpa o buffer do Scanner
        System.out.print("Titular: ");
        sc.nextLine();
        
        // Solicita e lê o nome do titular da conta
        String holder = sc.nextLine();
        
        // Solicita e lê o saldo inicial da conta
        System.out.print("Saldo inicial: ");
        double balance = sc.nextDouble();
        
        // Solicita e lê o limite de saque da conta
        System.out.print("Limite de saque: ");
        double withdrawLimit = sc.nextDouble();

        // Cria uma nova conta com os dados fornecidos
        Account acc = new Account(number, holder, balance, withdrawLimit);
        
        System.out.println();
        
        // Solicita e lê uma quantia para saque
        System.out.print("Informe uma quantia para sacar: ");
        double amount = sc.nextDouble();
        
        try {
            
        	// Tenta realizar o saque na conta
            acc.withdraw(amount);
           
            // Se o saque for bem-sucedido, exibe o novo saldo
            System.out.printf("Novo saldo: %.2f%n", acc.getBalance());
        }
        catch (BusinessException e) {
         
        	// Se ocorrer uma exceção de negócio, exibe a mensagem de erro
            System.out.println(e.getMessage());
        }
        
        // Fecha o objeto Scanner para liberar os recursos
        sc.close();
    }
}