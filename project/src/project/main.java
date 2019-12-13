package project;

import java.util.Scanner;

public class main {

	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		London company = new London(); // It's created to reach all company information.
		
		int numberOfStations = 0;
		double total_Income = 0;
		double total_Cost = 0;
		int selection = 0;
		String a,b; // These attributes are to compare 2 stations
		
		System.out.println("London Underground Company \n"
				+ "- - - - - - - - - - - - - - - - - - - - - - - - - - \n"
				+ "Please enter the number of station which will be created:");
		numberOfStations = scan.nextInt(); 
		//Stations will be created according to number of stations which will be taken from user.
		//So, Test step will be easy. If user want to create 10 or 100 stations, user will be able to do it.
		

		Station stations [] = new Station[numberOfStations];
		for(int i=0; i<numberOfStations; i++){
			stations[i] = new Station();
			System.out.println("\n" + (i+1) +". Station:");
			System.out.println("Id:");
			stations[i].setId( scan.nextInt() );
			scan.nextLine();
			System.out.println("Name: "); // If there is space in it, it skips other process, without taking address!!
			stations[i].setAd( scan.nextLine() );				// This warning is given user.
			System.out.println("Address:");
			stations[i].setAdres ( scan.nextLine() );
			System.out.println("Number of Contractual Employees:");
			stations[i].setSozSayisi( scan.nextInt() );
			scan.nextLine();
			System.out.println("Number of Subcontractor Employees:");
			stations[i].setNumberOfSubcontractors( scan.nextInt() );
			System.out.println("Number of Sold Tickets:");
			scan.nextLine();
			stations[i].setNumberOfSoldTickets( scan.nextInt() );
			scan.nextLine();
			System.out.println("Price:");			// You have to use , for double variables. Not '.'
			stations[i].setPrice( scan.nextDouble() );
			
			stations[i].calculateIncomeCost(); // Calculation method for station

		}
		System.out.println("-------------------------------\n\n");
		System.out.println(numberOfStations + " stations entered to system.\n");
		System.out.println("Transactions you can take are listed:\n"
				+ "1-\t List all open stations\n"
				+ "2-\t Show annual calculations \n3-\t Show Prices of Stations, Income/Cost/Profit of Stations\n"
				+ "4-\t Show the stations which have maximum and minimum profit or loss\n"
				+ "5-\t Shut down a station which has minimum profit or loss\n"
				+ "6-\t Compare 2 station in terms of income\n"
				+ "7-\t Exit"
				+ "\nEnter your selection");
		selection = scan.nextInt();
		while(selection != 7){
			switch(selection){
			case 1 :
			{	// Loop code for listing all active stations
				System.out.println("-------------------------------\n\n");
				
				for(int i=0; i<numberOfStations; i++){
					if( stations[i].situation == true){
						System.out.println(stations[i].toString() );
					}
				} 
				break;
			}
			case 2 :
			{
				System.out.println("-------------------------------\n\n");
				
				total_Income = company.total_Income(stations);
				total_Cost = company.total_Cost(stations);
				
				System.out.println("Annual Calculations of Company\n" + 
						"# # # # # # # # # # # # # # # # # # # # # # #");
				System.out.println("Monthly Income:\t" + total_Income + "£" );
				System.out.println("Monthly Cost:\t" + total_Cost + "£");
				System.out.println("Monthly Profit:\t" + ( total_Income-total_Cost ) + 
						 "" + "\n- - - - - - - - - - - - - - - - - - - - - - -\n"
						 + "Annual Income:\t" + ( total_Income*12 ) + "\nAnnual Cost:\t" + ( total_Cost*12 ) + "£"
						 +"\nAnnual Profit:\t" + ( total_Income-total_Cost )*12 + "£\n");
				break;
			}
			case 3 :
			{
				System.out.println("-------------------------------\n\n");
				System.out.println(company.showIncomeCostProfit(stations, numberOfStations));
				break;
			}
			case 4 :
			{
				System.out.println("-------------------------------\n\n");
				System.out.println(company.minMaxIncome(stations)); 
				break;
			}
			case 5:
			{
				System.out.println("-------------------------------\n\n");
				System.out.println( company.closeLowestProfitableStation(stations) );
				break;
			}
			case 6 :
			{
				System.out.println("-------------------------------\n\n"
						+ "Enter stations to compare\nFirst Station Name: "); 
				a = scan.next();
				System.out.println("Second Station Name: ");
				b = scan.next();
				System.out.println(company.compare(stations, a, b));
				break;
				
			}
	
			default:
			{
				System.out.println("Wrong Selection!");
				break;
			}
			} //end of switch
		System.out.println("Transactions you can take are listed:\n"
				+ "1-\t List all open stations\n"
				+ "2-\t Show annual calculations \n3-\t Show Prices of Stations, Income/Cost/Profit of Stations\n"
				+ "4-\t Show the stations which have maximum and minimum profit or loss\n"
				+ "5-\t Shut down a station which has minimum profit or loss\n"
				+ "6-\t Compare 2 station in terms of income\n"
				+ "7-\t Exit"
				+ "\nEnter your selection:");
		selection = scan.nextInt();
		} // end of while
		
		System.out.println("###########################\n\nExit successfully!");
		

	}

}
