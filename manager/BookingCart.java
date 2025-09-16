package manager;
import entity.*;

public class BookingCart {
    private BookingItem[] cartItems;

    public BookingCart() {
        cartItems = new BookingItem[1000];
    }

    public BookingCart(int size) {
        cartItems = new BookingItem[size];
    }

    public boolean addItem(int itemNo, Train t, double seats) {
        if (itemNo >= 0 && itemNo < cartItems.length && t.getAvailableSeats() >= seats) {
            cartItems[itemNo] = new BookingItem(t, seats);
            return true;
        } else {
            System.out.println("Not enough seats for " + t.getId());
            return false;
        }
    }

    public BookingItem getItem(int itemNo) {
        return cartItems[itemNo];
    }

    public Train getTrainById(String id) {
        for (BookingItem item : cartItems) {
            if (item != null) {
                if (item.getTrain().getId().equals(id)){ 
					return item.getTrain();
				}
            }
        }
        return null;
    }

    public void remove(int itemNo) {
        cartItems[itemNo] = null;
    }

    public void showCart() {
        System.out.println("------------ Booking Cart --------------");
        double total = 0;
        for (BookingItem item : cartItems) {
            if (item != null) {
                total += item.getBill();
                item.showItem();
            }
        }
        System.out.println("# Total Bill: " + total);
        System.out.println("----------------------------------------");
    }

    public void confirmBooking() {
        showCart();
        for (BookingItem item : cartItems) {
            if (item != null){
				item.bookSeats();
			}
        }
        cartItems = new BookingItem[1000];
    }

    @Override
    public String toString() {
		String allData = "";
        allData += "------------ Booking Cart --------------\n";
        double total = 0;
        for (BookingItem item : cartItems) {
            if (item != null) {
                total += item.getBill();
                allData += item.toString();
            }
        }
        allData += "# Total Bill: " + total + "\n";
        allData += "----------------------------------------\n";
        return allData;
    }
}
