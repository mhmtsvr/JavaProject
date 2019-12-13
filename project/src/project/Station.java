package project;

public class Station {

	private int id;
	private String name;
	private String address;
	private int numberOfContractuals; // Number of contractual employees - Sozlesmeli
	private int numberOfSubcontractors; // Number of subcontractor employees - Taseron
	private int numberOfSoldTickets; //number of tickets sold
	private double price;
	protected double income;
	protected double cost;
	protected double profit;
	protected boolean situation=true; // If Station is open, it will be true
	
	public Station()
	{
		this.id=0;
		this.name = "";
		this.address = "";
		this.numberOfContractuals = 0;
		this.numberOfSubcontractors = 0;
		this.numberOfSoldTickets = 0;
		this.price = 0;
		this.income = 0;
		this.cost = 0;
		this. profit = 0;
		this.situation = true;
	}
	public void calculateIncomeCost(){ 
		// Income, cost and profit of each station are calculated 
			income = price * numberOfSoldTickets;
			cost = (  ( numberOfSubcontractors)  * 1200 + ( numberOfContractuals * 2000 ) ) ;
			profit = income - cost ;
		}

	


	public String toString(){
		String s = "Id: " + id + "\n" +
		"Name: " + name + "\n" +
		"Address: " + address + "\n" +
		"Number of Contractual Employees: " + numberOfContractuals + "\n" +
		"Number of Subcontractor Employees: " + numberOfSubcontractors + "\n"  +
		"Number of Tickets Sold " + numberOfSoldTickets + "\n" +
		"Price: " + price + "\n";
		
		return s;
		
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setAd(String name) {
		this.name = name;
	}

	public String getAdres() {
		return address;
	}

	public void setAdres(String address) {
		this.address = address;
	}

	public int getSozSayisi() {
		return numberOfContractuals;
	}

	public void setSozSayisi(int numberOfContractuals) {
		this.numberOfContractuals = numberOfContractuals;
	}

	public int getNumberOfSubcontractors() {
		return numberOfSubcontractors;
	}

	public void setNumberOfSubcontractors(int numberOfSubcontractors) {
		this.numberOfSubcontractors = numberOfSubcontractors;
	}

	public int getNumberOfSoldTickets() {
		return numberOfSoldTickets;
	}

	public void setNumberOfSoldTickets(int numberOfSoldTickets) {
		this.numberOfSoldTickets = numberOfSoldTickets;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


	
}
