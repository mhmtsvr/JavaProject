package project;

public class London {

	public double total_Income(Station[] s){ //It calculates total income for all stations
		double income = 0;
		for(int i=0; i < s.length; i++){
			if(s[i].situation == true){ // If the station is open, add to income
				income += s[i].getPrice() * s[i].getNumberOfSoldTickets();
		}
		}
		return income;
	
	}
	public double total_Cost(Station[] s){ // It calculates all cost of all stations
		double cost = 0;
		for(int i=0; i < s.length; i++){ 
			if(s[i].situation == true){ // If the station is open, add to cost
				cost += ( ( s[i].getNumberOfSubcontractors() ) * 1200 + ( s[i].getSozSayisi() * 2000 ) );
		}
		}
		return cost;
	}
	public String minMaxIncome(Station [] s){
		
		Station stationLowestIncome = null;    // This is prevention in case of s[0] station is closed
		Station stationHighestIncome = null; // Comparisons will be done according to first open station.
		Station stationHighestCost = null;
		Station stationLowestCost = null;
		Station stationLowestProfit = null;
		Station stationHighestProfit = null;		
		for(int i=0; i < s.length; i++){	
			if( s[i].situation == true){
				stationLowestIncome = s[i];
				stationHighestIncome = s[i];
				stationHighestCost = s[i];
				stationLowestCost = s[i];
				stationLowestProfit = s[i];
				stationHighestProfit = s[i];	
				break; // Loop will break, after fist assigning
			}
		}

		
		StringBuffer buffer = new StringBuffer();
		String result = "boyu  " + s.length ;
		for(int i=0; i < s.length ; i++){ // It finds station which has lowest income.
			if( stationLowestIncome.income > s[i].income ){
				if(s[i].situation == true){
					stationLowestIncome = s[i];
				}
			}
		}
		for(int i=0; i < s.length ; i++){ // It finds Station with highest income.    
			if( stationHighestIncome.income < s[i].income ){  // Station with highest income
				if(s[i].situation == true){
					stationHighestIncome = s[i];
				}
			}
		}
		for(int i=0; i < s.length ; i++){ // It finds station which has lowest cost.
			if( stationLowestCost.cost > s[i].cost ){
				if(s[i].situation == true){
					stationLowestCost = s[i];
				}
			}
		}
		for(int i=0; i < s.length; i++){ // It finds Station with highest cost.
			if( stationHighestCost .cost < s[i].cost ){
				if(s[i].situation == true){
					stationHighestCost = s[i];
				}
			}
		}
		for(int i=0; i < s.length; i++){ // It finds station which has lowest profit.
			if( stationLowestProfit.profit > s[i].profit ){
				if(s[i].situation == true){
					stationLowestProfit = s[i];
				}
			}
		}
		for(int i1=0; i1 < s.length ; i1++){ // It finds the station which has maximum profit.
			if( stationHighestProfit.profit < s[i1].profit ){
				if(s[i1].situation == true){
					stationHighestProfit = s[i1];
				}
			}
		}
				
		buffer.append("Station with lowest income " + stationLowestIncome.getName() + "\n");		//enAzGelirliDurak
		buffer.append("Station with highest income: " + stationHighestIncome.getName() + "\n");	//enFazlaGelirliDurak
		buffer.append("Station with lowest cost: " + stationLowestCost.getName() + "\n"); 		//enAzGiderliDurak
		buffer.append("Station with highest cost: " + stationHighestCost.getName() + "\n"); 		//enFazlaGiderliDurak
		buffer.append("Station with lowest profit: " + stationLowestProfit.getName() + "\n");  	//enAzKarliDurak
		buffer.append("Station with highest profit: " + stationHighestProfit.getName() + "\n\n"); //enFazlaKarliDurak
		result = buffer.toString();
		return result;
	}
	
	public String compare(Station[] s ,String a, String b){
		Station x = new Station();
		Station y = new Station();
	
		for(int i=0; i < s.length ; i++){
			if( s[i].getName().equalsIgnoreCase(a) ){ // We find incoming station name in the array
				x = s[i];							// then keep these info in x object
			}
			if( s[i].getName().equalsIgnoreCase(b) ){ // We find incoming station name in the array
				y = s[i];							// then keep these info in y object
			}
		}
		
		if(  x.situation == false || y.situation == false){ // If one of stations is close, do not compare. Because you can't
			return "You cannot compare because of one of stations is already closed!" ;
			
		}
		
		double incomeX = x.getPrice() * x.getNumberOfSoldTickets();
		double incomeY = y.getPrice() * y.getNumberOfSoldTickets();
		if( incomeX > incomeY ){
			return x.getName() + " station has " + (incomeX-incomeY) + "£ more income than " +y.getName();
		}
		else if( incomeY > incomeX ){
			return y.getName() + " station has " + (incomeY-incomeX) + "£ more income than " +x.getName();
		}
		else{
			return "Station names you entered did not match!";
		}
		
	}
	
	public String showIncomeCostProfit(Station[] s, int numberOfStations){ // Showing Income/Cost/Profit of Stations
		
		String result = null;
		StringBuffer buffer = new StringBuffer();
		buffer.append("Income/Cost/Profit of All Stations\n");
		buffer.append("- - - - - - - - - - - - - - - - - - -\n");
		for(int i=0; i < numberOfStations ; i++ ){
			if(s[i].situation == true){
				buffer.append("\nID: \t" + s[i].getId() + "\n");
				buffer.append("Name: \t" + s[i].getName() + "\n");
				buffer.append("Income: \t" + s[i].income + "£\n");
				buffer.append("Cost: \t" + s[i].cost + "£\n");
				buffer.append("Profit: \t" + s[i].profit + "£\n");
			}
		}
		result = buffer.toString();
		return result;
	}
	
	public String closeLowestProfitableStation(Station[] s){
		Station stationLowestProfit = null; 		// s[0] can be closed, that's why we do null for right comparing
		for(int i=0; i < s.length; i++){	// comparison will be done according to first open station.
			if( s[i].situation == true){
				stationLowestProfit = s[i];
				break; 						// It's for breaking loop, after 1 run.
			}
		}
		if( stationLowestProfit == null ){
			return "There is no station to close!";
		}
		for(int i=0; i < s.length; i++){ // It finds station which has the lowest profit.
			if( stationLowestProfit.situation == true && s[i].situation == true ){ // If station is active, control it.
				if( stationLowestProfit.profit > s[i].profit ){
					stationLowestProfit = s[i];
				}
			}
		}

		int j=0;
		while(true) {
			if( stationLowestProfit.getName().equalsIgnoreCase(s[j].getName()) ){
				s[j].situation = false;
				break;
			}
			j++;
		}
		return "\n" + stationLowestProfit.getName() + " station just closed!\n";
	}
	
	
	
}
