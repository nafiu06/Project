package manager;
import entity.*;
import interfaces.*;

public class TrainSchedule implements ITrainOperations {
    private Train[] trains;

    public TrainSchedule() {
        trains = new Train[1000];
    }

    public TrainSchedule(int size) {
        trains = new Train[size];
    }

    public void addTrain(int tNo, Train t) {
        if (tNo >= 0 && tNo < trains.length) {
            trains[tNo] = t;
        }
    }

    public Train getTrain(int tNo) {
        return trains[tNo];
    }

    public Train getTrainById(String id) {
        for (Train t : trains) {
            if (t != null) {
                if (t.getId().equals(id)) {
                    return t;
                }
            }
        }
        return null;
    }

    public void remove(int tNo) {
        trains[tNo] = null;
    }

    public void showSchedule() {
        System.out.println("------------ Train Schedule --------------");
        for (Train t : trains) {
            if (t != null) {
                t.displayDetails();
            }
        }
        System.out.println("-----------------------------------------");
    }

    @Override
    public String toString() {
		String allData= "";
        allData += "------------ Train Schedule --------------"+"\n";
        for (int i = 0; i < trains.length; i++) {
            if (trains[i] != null) {
                allData += "Train No: " + i + "\n" ;
				allData += trains[i].toString();
				allData += "-----------------------------------------\n";
            }
        }
        allData += "-----------------------------------------\n";
        return allData;
    }
	public Train[] getAll() {
        return trains;
    }
}
