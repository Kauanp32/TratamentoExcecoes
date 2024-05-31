package TratamentoExcecoes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ArquivoTexto {
	
	public static void main (String[] args) {
		
		// Cria um objeto File que representa o arquivo localizado em "C:\\temp\\in.txt"
		File file = new File("C:\\temp\\in.txt");
		
		// Declara uma variável Scanner como null para poder ser inicializada no bloco try
		Scanner sc = null;
		
		try {
			
			// Tenta inicializar o Scanner com o arquivo especificado
			sc = new Scanner(file);
			
			// Enquanto houver uma próxima linha no arquivo, leia e imprima essa linha
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		}
		catch (FileNotFoundException e) {
			
			// Caso o arquivo não seja encontrado, exibe uma mensagem de erro com a descrição do problema
			System.out.println("Error opening file: " + e.getMessage());
		}
		finally {
			
			// No bloco finally, que sempre é executado, verifica se o Scanner foi inicializado
			if (sc != null) {
			
				// Fecha o Scanner para liberar o recurso do arquivo
				sc.close();
			}
		}
	}
}