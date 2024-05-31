package TratamentoExcecoes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Model.Treatment.DomainException;
import entities.Treatment.Reservation;

public class ChecarReserva {

    public static void main(String[] args) {

        // Cria um objeto Scanner para ler a entrada do usuário a partir do console
        Scanner sc = new Scanner(System.in);
        
        // Define o formato de data que será utilizado (dia/mês/ano)
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try { 
            // Solicita e lê o número do quarto
            System.out.print("Room number: ");
            int number = sc.nextInt();
            
            // Solicita e lê a data de check-in no formato especificado
            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            
            // Solicita e lê a data de check-out no formato especificado
            System.out.print("Check-out date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());

            // Cria uma nova reserva com os dados fornecidos
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            // Exibe os detalhes da reserva
            System.out.println("Reservation: " + reservation);
            System.out.println();
            
            // Solicita novos dados para atualizar a reserva
            System.out.println("Enter data to update the reservation:");
            
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            // Atualiza as datas da reserva com os novos dados fornecidos
            reservation.updateDates(checkIn, checkOut);
           
            // Exibe os detalhes atualizados da reserva
            System.out.println("Reservation: " + reservation);
        }
        catch (ParseException e) {
            
        	// Captura exceção caso a data fornecida não esteja no formato especificado e exibe uma mensagem de erro
            System.out.println("Invalid date format");
        }
        catch (DomainException e) {
            
        	// Captura exceção personalizada de domínio e exibe a mensagem de erro correspondente
            System.out.println("Error in reservation: " + e.getMessage());
        }
        catch (RuntimeException e) {
           
        	// Captura qualquer outra exceção de tempo de execução inesperada e exibe uma mensagem de erro
            System.out.println("Unexpected error");
        }

        // Fecha o objeto Scanner para liberar os recursos
        sc.close();
    }
}