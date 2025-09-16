package entity;

public class FreightTrain extends Train {
    private double cargoCapacity;

    public FreightTrain(String id, String name, double ticketPrice, double availableSeats, double cargoCapacity) {
        super(id, name, ticketPrice, availableSeats);
        this.cargoCapacity = cargoCapacity;
    }
	public void setCargoCapacity(double cargoCapacity){
		this.cargoCapacity= cargoCapacity;
	}

    public double getCargoCapacity() { return cargoCapacity; }

    @Override
	public void displayDetails(){
		System.out.println("............................");
		System.out.println("ID: "+super.getId());
		System.out.println("Name: "+super.getName());
		System.out.println("Ticket Price: "+super.getTicketPrice());
		System.out.println("Available Seats: "+super.getAvailableSeats());
		System.out.println("Cargo Capacity: "+cargoCapacity);
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
		data+= "Cargo Capacity: "+cargoCapacity+"\n";
		data+= "............................"+"\n";
		
		return data;
	}
}
