package entity;

public class PassengerTrain extends Train {
    private int stops;

    public PassengerTrain(String id, String name, double ticketPrice, double availableSeats, int stops) {
        super(id, name, ticketPrice, availableSeats);
        this.stops = stops;
    }
	public void setStops(int stops){
		this.stops=stops;
	}

    public int getStops() { 
	return stops; 
	}

    @Override
	public void displayDetails(){
		System.out.println("............................");
		System.out.println("ID: "+super.getId());
		System.out.println("Name: "+super.getName());
		System.out.println("Ticket Price: "+super.getTicketPrice());
		System.out.println("Available Seats: "+super.getAvailableSeats());
		System.out.println("Stops: "+stops);
		System.out.println("............................");
	}
	
	@Override
	public String toString(){
		String data = "";
		
		data+= "............................"+"\n";
		data+= "ID: "+super.getId()+"\n";
		data+= "Name : "+super.getName()+"\n";
		data+= "Ticket Price: "+super.getTicketPrice()+"\n";
		data+= "Available Seats: "+super.getAvailableSeats()+"\n";
		data+= "Stops: "+stops+"\n";
		data+= "............................"+"\n";
		
		return data;
	}
}

	
	

