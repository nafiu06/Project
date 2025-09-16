package files;
import java.io.*;
import java.util.*;
import entity.*;
import manager.*;

public class FileIO {

    public static void loadFromFile(TrainSchedule schedule) {
        try {
            File folder = new File("files");
            if (!folder.exists()) {
				folder.mkdir();
			}

            File passengerFile = new File(folder.getName() + "/passenger.txt");
            if (!passengerFile.exists()) {
				passengerFile.createNewFile();
			}

            Scanner sc = new Scanner(passengerFile);
            int trainNo = 0;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split(";");
                String id = data[0];
                String name = data[1];
                double price = Double.parseDouble(data[2]);
                double seats = Double.parseDouble(data[3]);
                int stops = Integer.parseInt(data[4]);
                schedule.addTrain(trainNo++, new PassengerTrain(id, name, price, seats, stops));
            }
            sc.close();

            File freightFile = new File(folder.getName() + "/freight.txt");
            if (!freightFile.exists()) {
				freightFile.createNewFile();
			}

            sc = new Scanner(freightFile);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split(";");
                String id = data[0];
                String name = data[1];
                double price = Double.parseDouble(data[2]);
                double seats = Double.parseDouble(data[3]);
                double capacity = Double.parseDouble(data[4]);
                schedule.addTrain(trainNo++, new FreightTrain(id, name, price, seats, capacity));
            }
            sc.close();
		}
		catch(FileNotFoundException e){
			System.out.println(e.getMessage());
		}

         
		catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void writeInFile(TrainSchedule schedule) {
        try {
            FileWriter passengerWriter = new FileWriter(new File("files/passenger.txt"));
            FileWriter freightWriter = new FileWriter(new File("files/freight.txt"));

            Train[] trains = schedule.getAll();

            for (Train t : trains) {
                if (t instanceof PassengerTrain) {
                    PassengerTrain pt = (PassengerTrain) t;
                    String line = pt.getId() + ";" + pt.getName() + ";" + pt.getTicketPrice() + ";" +
                            pt.getAvailableSeats() + ";" + pt.getStops() + "\n";
                    passengerWriter.write(line);
                } else if (t instanceof FreightTrain) {
                    FreightTrain ft = (FreightTrain) t;
                    String line = ft.getId() + ";" + ft.getName() + ";" + ft.getTicketPrice() + ";" +
                            ft.getAvailableSeats() + ";" + ft.getCargoCapacity() + "\n";
                    freightWriter.write(line);
                }
            }

            passengerWriter.close();//better than flush()
            freightWriter.close();//beter than flush()
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
