package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import manager.*;
import entity.*;
import files.*;

public class BookingPage implements ActionListener {
    JFrame frame = new JFrame("Booking Page");
    
	TrainSchedule schedule = new TrainSchedule();
    BookingCart cart = new BookingCart();

    JLabel trainIdLabel, seatsLabel;
    JTextField trainIdField, seatsField;
    JButton bookBtn, confirmBtn;
    JTextArea screen;

    public BookingPage() {
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        FileIO.loadFromFile(schedule);

        trainIdLabel = new JLabel("Train ID:");
        trainIdLabel.setBounds(10, 10, 80, 30);
        frame.add(trainIdLabel);

        trainIdField = new JTextField();
        trainIdField.setBounds(100, 10, 100, 30);
        frame.add(trainIdField);

        seatsLabel = new JLabel("Seats:");
        seatsLabel.setBounds(10, 50, 80, 30);
        frame.add(seatsLabel);

        seatsField = new JTextField();
        seatsField.setBounds(100, 50, 100, 30);
        frame.add(seatsField);

        bookBtn = new JButton("Book");
        bookBtn.setBounds(10, 90, 100, 30);
        bookBtn.addActionListener(this);
        frame.add(bookBtn);

        confirmBtn = new JButton("Confirm");
        confirmBtn.setBounds(120, 90, 100, 30);
        confirmBtn.addActionListener(this);
        frame.add(confirmBtn);

        screen = new JTextArea();
        screen.setBounds(10, 130, 560, 300);
        frame.add(screen);

        refreshScreen();
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bookBtn) {
            try {
                String id = trainIdField.getText();
                int seats = Integer.parseInt(seatsField.getText());

                Train t = schedule.getTrainById(id);
                if (t != null) {
                    cart.addItem(0, t, seats);
                    refreshScreen();
                } else {
                    JOptionPane.showMessageDialog(frame, "Train not found");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input");
            }
        } else if (e.getSource() == confirmBtn) {
            cart.confirmBooking();
            FileIO.writeInFile(schedule);
            refreshScreen();
        }
    }

    void refreshScreen() {
        screen.setText(cart.toString());
    }
}

