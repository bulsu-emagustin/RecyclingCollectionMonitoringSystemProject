package Assignment;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class EDPAssignment5 implements ActionListener {

    //Variables
    JFrame frame;
    JLabel titleL, nameL, gmailL, eventL, addonsL, displayL;
    JTextField name, gmail;
    JComboBox<String> eventtype;
    JCheckBox selection1, selection2;
    JButton register, clear, exit;
    JTextArea display;
    JPanel inputpanel, addonspanel, displayheader;

    public EDPAssignment5() {
        //Containers
        frame = new JFrame("Event Registration System");
        inputpanel = new JPanel();
        addonspanel = new JPanel();
        displayheader = new JPanel();

        //labels and Textfields
        inputpanel.setBounds(50, 0, 400, 500);
        inputpanel.setBackground(Color.gray);
        inputpanel.setLayout(null);
        titleL = new JLabel("REGISTRATION");
        titleL.setBounds(150, 3, 100, 20);
        nameL = new JLabel("Name: ");
        nameL.setBounds(68, 30, 55, 20);
        name = new JTextField(55);
        name.setBounds(110, 30, 250, 20);
        gmailL = new JLabel("Email Address: ");
        gmailL.setBounds(20, 60, 250, 20);
        gmail = new JTextField(55);
        gmail.setBounds(110, 60, 250, 20);

        //Combo Box
        eventL = new JLabel("Event Type: ");
        eventL.setBounds(35, 90, 250, 20);
        String[] type = {"Seminar", "Workshop", "Training"};
        eventtype = new JComboBox<>(type);
        eventtype.setBounds(110, 90, 250, 20);

        //Check Box
        addonspanel.setBounds(160, 130, 200, 110);
        addonspanel.setLayout(null);
        addonsL = new JLabel("Add-On: ");
        addonsL.setBounds(10, 5, 250, 20);
        selection1 = new JCheckBox("With Certificate");
        selection1.setBounds(60, 35, 130, 20);
        selection2 = new JCheckBox("With Meals");
        selection2.setBounds(60, 65, 130, 20);

        //Buttons
        register = new JButton("Register");
        register.setBounds(30, 255, 100, 40);
        clear = new JButton("Clear");
        clear.setBounds(145, 255, 100, 40);
        exit = new JButton("Exit");
        exit.setBounds(260, 255, 100, 40);

        //Display
        displayheader.setBounds(25, 320, 350, 30);
        displayheader.setBackground(Color.lightGray);
        displayheader.setLayout(null);
        displayL = new JLabel("DISPLAY");
        displayL.setBounds(150, 3, 50, 20);
        display = new JTextArea();
        display.setBounds(25, 350, 350, 140);

        //Adding Components
        frame.add(inputpanel);
        inputpanel.add(titleL);
        inputpanel.add(nameL);
        inputpanel.add(name);
        inputpanel.add(gmailL);
        inputpanel.add(gmail);
        inputpanel.add(eventL);
        inputpanel.add(eventtype);
        inputpanel.add(addonspanel);
        addonspanel.add(addonsL);
        addonspanel.add(selection1);
        addonspanel.add(selection2);
        inputpanel.add(register);
        inputpanel.add(clear);
        inputpanel.add(exit);
        inputpanel.add(displayheader);
        displayheader.add(displayL);
        inputpanel.add(display);

        //Frame Settings
        frame.setSize(515, 537);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                frame.dispose();
            }
        });

        //Listeners
        register.addActionListener(new RegisterListener());
        clear.addActionListener(this);
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(
                        frame,
                        "Are you sure you want to exit?",
                        "Exit Confirmation",
                        JOptionPane.YES_NO_OPTION
                );

                if (choice == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

    //Display Output
    class RegisterListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            String userName = name.getText();
            String userEmail = gmail.getText();

            if (userName.isEmpty() || userEmail.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill in all fields.");
                return;
            }

            if (!userEmail.contains("@")) {
                JOptionPane.showMessageDialog(frame, "Invalid email address.");
                return;
            }

            String selectedEvent = (String) eventtype.getSelectedItem();

            String addons = "";
            if (selection1.isSelected()) {
                addons += "With Certificate\n";
            }
            if (selection2.isSelected()) {
                addons += "With Meals\n";
            }
            if (addons.equals("")) {
                addons = "None";
            }

            String output = "Registration Summary\n"
                    + "Name: " + userName + "\n"
                    + "Email: " + userEmail + "\n"
                    + "Event: " + selectedEvent + "\n"
                    + "Add-ons:\n" + addons;

            display.setText(output);
        }
    }

    //Main Class
    public static void main(String[] args) {
        new EDPAssignment5();
    }

    //Clear Button Function
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clear) {
            name.setText("");
            gmail.setText("");
            eventtype.setSelectedIndex(0);
            selection1.setSelected(false);
            selection2.setSelected(false);
            display.setText("");
        }
    }

}
