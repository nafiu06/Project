package manager;
import entity.*;

public class BookingItem {
    private Train train;
    private double seats;

    public BookingItem(Train train, double seats) {
        setTrain(train);
        setSeats(seats);
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Train getTrain() {
        return train;
    }

    public void setSeats(double seats) {
        if (seats > 0){
			this.seats = seats;
		}
    }

    public double getSeats() {
        return seats;
    }

    public double getBill() {
        return train.getTicketPrice() * seats;
    }

    public void bookSeats() {
        train.sellSeats(seats);
    }

    public void showItem() {
        System.out.println(train.getId() + " | " + train.getName() + " | " + train.getTicketPrice() + " | " + seats + " | " + getBill());
    }

    @Override
    public String toString() {
        return train.getId() + " | " + train.getName() + " | " + train.getTicketPrice() + " | " + seats + " | " + getBill() + "\n";
    }
}
