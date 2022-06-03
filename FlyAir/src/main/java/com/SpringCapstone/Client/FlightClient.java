package com.SpringCapstone.Client;

import java.time.LocalDate;
import java.util.Scanner;

import com.SpringCapstone.domain.Flight;
import com.SpringCapstone.service.FlightService;
import com.SpringCapstone.service.FlightServiceImpl;

public class FlightClient {

	FlightService  flightService = new FlightServiceImpl();
	
	public FlightClient() {
		//TODO Auto-generated constructor stub
	}
	
	private void displayMenu() {
		String line="********************************";
		System.out.println(line);
		System.out.println("*            M E N U           *");
		System.out.println(line);
		System.out.println("* 1. Add a Flight              *");
		System.out.println("* 2. View an Flight details    *");
		System.out.println("* 3. Exit                      *");
		System.out.println(line);
	}
	
	private void addFlight(Scanner sc) {
		Flight flight = new Flight();
		System.out.println("Enter flight details ");
		System.out.println("Enter Airlines Name : ");
		String airlines = sc.next();
		flight.setAirlines(airlines);
		System.out.println("Enter the source : ");
		String source = sc.next();
		flight.setSource(source);
		System.out.println("Enter the destination: ");
		String destination = sc.next();
		flight.setDestination(destination);
		System.out.println("Enter the fare : ");
		Double fare = sc.nextDouble();
		flight.setFare(fare);
		System.out.println("Enter the journey date ");
		LocalDate journeDate = LocalDate.parse(sc.next());
		flight.setJourneyDate(journeDate);
		System.out.println("Enter the seat count ");
		Integer seatCount = sc.nextInt();
		flight.setSeatCount(seatCount);
		flightService.addFlight(flight);
	}
	
	private void searchFlight(Scanner sc) {
		
		System.out.println("Enter Flight Id");
		int fId = sc.nextInt();
		
		Flight flight = flightService.searchFlight(fId);
		
		if(flight == null ) {
			System.out.println("No records found for Flight Id : "+ fId);
		}
		else {
			System.out.println("Flight details");
			System.out.println("Flight Id : " + flight.getFlightId());
			System.out.println("Flight Airlines : " + flight.getAirlines());
			System.out.println("Flight Source : " + flight.getSource() );
			System.out.println("Flight Destination : " + flight.getDestination());
			System.out.println("Flight Fare : " + flight.getFare());
			System.out.println("Flight Journey Date : " + flight.getJourneyDate());
			System.out.println("Flight Seat Count : " + flight.getSeatCount());
		}
		
		
	}

	public static void main(String[] args) {
		FlightClient client = new FlightClient();
	    Scanner scanner = new Scanner(System.in);
		int choice = 0; String ans;
		do{
			try {
				client.displayMenu();
				System.out.print("Enter your choice : ");
				choice = scanner.nextInt();
				switch (choice) {
				case 1:
					client.addFlight(scanner);;
					break;
				case 2:
					client.searchFlight(scanner);
					break;
				default:
					System.out.println("Invalid choice!!, Please enter your choice again");
					break;
				}
			}  
			catch (Exception e) {
				System.out.println(e.getMessage());
			}

			System.out.println("\nDo you want to continue? Press y to continue OR Press any other key to Exit");
			ans = scanner.next();
			
		}while ( "y".equalsIgnoreCase(ans) || choice!=3);

	}
}