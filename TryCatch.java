package TratamentoExcecoes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatch {
	
	public static void main (String [] args) {
		
		// Cria um objeto Scanner para ler a entrada do usuário a partir do console
		Scanner sc = new Scanner(System.in);
		
		try {
			
			// Lê uma linha de entrada do usuário, divide em substrings com base em espaços e armazena em um vetor
			String[] vect = sc.nextLine().split(" ");
			
			// Lê um número inteiro da entrada do usuário, representando a posição desejada no vetor
			int position = sc.nextInt();
			
			// Imprime o elemento do vetor na posição especificada
			System.out.println(vect[position]);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			
			// Captura exceção caso a posição especificada seja inválida (fora dos limites do vetor)
			System.out.println("Invalid position");
		}
		catch (InputMismatchException e) {
			
			// Captura exceção caso a entrada fornecida para a posição não seja um número inteiro válido
			System.out.println("Input error");
		}
		
		// Mensagem indicando o fim do programa
		System.out.println("End of program");
		
		// Fecha o objeto Scanner para liberar os recursos
		sc.close();
	}
}