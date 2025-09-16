package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import entity.*;
import manager.*;
import files.*;

public class SchedulePage implements ActionListener, MouseListener {
    JFrame frame = new JFrame("Train Schedule");
    Font font15 = new Font("Cambria", Font.BOLD, 15);

    JLabel noLabel, idLabel, nameLabel, priceLabel, seatsLabel, stopsLabel;
    JTextField noField, idField, nameField, priceField, seatsField, stopsField;
    JButton addBtn, saveBtn, deleteBtn;
	private int lastAddedIndex = -1;
    JTextArea screen;

    TrainSchedule schedule = new TrainSchedule();
    Random randNumber = new Random();

    public SchedulePage() {
        frame.setSize(700, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        FileIO.loadFromFile(schedule);

        JLabel welcomeLabel = new JLabel("Welcome to Train Schedule");
        welcomeLabel.setBounds(10, 10, 300, 30);
        welcomeLabel.setFont(font15);
        welcomeLabel.setOpaque(true);
        welcomeLabel.setBackground(new Color(84, 253, 218));
        frame.add(welcomeLabel);

        int x = 10, y = 50, w = 100, h = 30, yGap = 10;

        noLabel = createLabel(x, y, w, h, "Train No.");
        noField = createTextField(x + w + yGap, y, w, h, "");
        y += h + yGap;

        idLabel = createLabel(x, y, w, h, "ID");
        idField = createTextField(x + w + yGap, y, w, h, "");
        y += h + yGap;

        nameLabel = createLabel(x, y, w, h, "Name");
        nameField = createTextField(x + w + yGap, y, w, h, "");
        y += h + yGap;

        priceLabel = createLabel(x, y, w, h, "Ticket Price");
        priceField = createTextField(x + w + yGap, y, w, h, "");
        y += h + yGap;

        seatsLabel = createLabel(x, y, w, h, "Seats");
        seatsField = createTextField(x + w + yGap, y, w, h, "");
        y += h + yGap;

        stopsLabel = createLabel(x, y, w, h, "Stops");
        stopsField = createTextField(x + w + yGap, y, w, h, "");
        y += h + yGap;

        addBtn = createButton(x, y, 210, h, "Add");
        addBtn.setBackground(Color.green);
        addBtn.setForeground(Color.white);
        y += h + yGap;

        saveBtn = createButton(x, y, 210, h, "Save");
        saveBtn.setBackground(Color.blue);
        saveBtn.setForeground(Color.white);
        y += h + yGap;
		
        deleteBtn = createButton(x, y, 210, h, "Delete Last");
        deleteBtn.setBackground(Color.RED);
        deleteBtn.setForeground(Color.WHITE);
        y += h + yGap;


        screen = new JTextArea();
        screen.setBounds(250, 50, 400, 400);
        screen.setBackground(Color.black);
        screen.setForeground(Color.green);
		
		JScrollPane jsp = new JScrollPane(screen);
		jsp.setBounds(310,50, 350, 400);
		frame.add(jsp);
        
		

        frame.setVisible(true);
        refreshScreen();
    }

    JLabel createLabel(int x, int y, int w, int h, String text) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, w, h);
        frame.add(label);
        return label;
    }

    JTextField createTextField(int x, int y, int w, int h, String text) {
        JTextField tf = new JTextField(text);
        tf.setBounds(x, y, w, h);
        frame.add(tf);
        return tf;
    }

    JButton createButton(int x, int y, int w, int h, String text) {
        JButton btn = new JButton(text);
        btn.setBounds(x, y, w, h);
        frame.add(btn);
        btn.addActionListener(this);
        return btn;
    }
	void refreshScreen() {
        screen.setText(schedule.toString());
    }

    public void mouseClicked(MouseEvent e) {
		
	}
    public void mousePressed(MouseEvent e) {
		
	}
    public void mouseReleased(MouseEvent e) {
		
	}
    public void mouseEntered(MouseEvent e) {
		
	}
    public void mouseExited(MouseEvent e) {
		
	}

    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == addBtn) {
    try {
        int no = Integer.parseInt(noField.getText());
        String id = idField.getText();
        String name = nameField.getText();
        double price = Double.parseDouble(priceField.getText());
        double seats = Double.parseDouble(seatsField.getText());
        int stops = Integer.parseInt(stopsField.getText());

        
        if (no >= 0 && no < schedule.getAll().length) {
            schedule.addTrain(no, new PassengerTrain(id, name, price, seats, stops));
            lastAddedIndex = no; 
            refreshScreen();
        } else {
            JOptionPane.showMessageDialog(frame, "Train number out of range.");
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(frame, "Invalid input.");
    }
}
 else if (e.getSource() == saveBtn) {
            FileIO.writeInFile(schedule);
            JOptionPane.showMessageDialog(frame, "Saved!");
        }
    
	else if (e.getSource() == deleteBtn) {
    if (lastAddedIndex >= 0 && lastAddedIndex < schedule.getAll().length) {
        schedule.remove(lastAddedIndex);
        JOptionPane.showMessageDialog(frame, "Deleted train last train");
        lastAddedIndex = -1; 
        refreshScreen();
    } else {
        JOptionPane.showMessageDialog(frame, "No train to delete.");
    }
}
	}


    
}