package entity;

public abstract class Train {
    private String id;
    private String name;
    private double ticketPrice;
    private double availableSeats;

    public Train(String id, String name, double ticketPrice, double availableSeats) {
        this.id = id;
        this.name = name;
        this.ticketPrice = ticketPrice;
        this.availableSeats = availableSeats;
    }

    public void setId(String id){
		if(id.length() >= 4){
			this.id=id;
		}
		else{
			System.out.println("invalid id");
		}
	}
		
    public String getId() { return id; }
	
	public void setName(String name){
		if(!name.isEmpty()){
			this.name = name;
		}
		else{
			System.out.println("invalid name");
		}
	}
    public String getName() { return name; }
	
	public void setTicketPrice(double ticketPrice){
		if(ticketPrice>0){
			this.ticketPrice= ticketPrice;
		}
		else{
			System.out.println("invalid price");
		}
	}
    public double getTicketPrice() { return ticketPrice; }
	
	public void setAvailableSeats(double availableSeats){
		this.availableSeats = availableSeats;
	}
		
    public double getAvailableSeats() { return availableSeats; }

    
    public void sellSeats(double seats) {
        if (seats <= availableSeats) {
            availableSeats -= seats;
        } else {
            System.out.println("Not enough seats available");
        }
    }

    public abstract void displayDetails();
	public abstract String toString();
}

