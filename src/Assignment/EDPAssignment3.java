package Assignment;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class EDPAssignment3 implements ActionListener {

    Frame frame;
    Button compute, clear, exit;
    Label displayL, inputL;
    TextField Displayfield, Inputfield;
    Panel ButtonPanel, FieldPanel;

    public EDPAssignment3() {
        //Containers
        frame = new Frame("Celsius to Fahrenheit Converter");
        ButtonPanel = new Panel();
        FieldPanel = new Panel();

        //Field
        displayL = new Label("Fahrenheit: ");
        displayL.setBounds(10, 15, 60, 20);
        Displayfield = new TextField(50);
        Displayfield.setBounds(75, 15, 155, 20);
        inputL = new Label("Celsius: ");
        inputL.setBounds(25, 45, 45, 20);
        Inputfield = new TextField(50);
        Inputfield.setBounds(75, 45, 155, 20);

        //Field Panel Settings
        FieldPanel.setBounds(30, 60, 240, 80);
        FieldPanel.setBackground(Color.red);
        FieldPanel.setLayout(null);

        //Buttons
        compute = new Button("Compute");
        compute.setBounds(30, 30, 85, 30);
        clear = new Button("Clear");
        clear.setBounds(135, 30, 85, 30);
        exit = new Button("Exit");
        exit.setBounds(80, 75, 85, 30);

        //Button Panel Settings
        ButtonPanel.setBounds(30, 145, 240, 130);
        ButtonPanel.setBackground(Color.gray);
        ButtonPanel.setLayout(null);

        //Adding compoments
        frame.add(FieldPanel);
        frame.add(ButtonPanel);
        ButtonPanel.add(compute);
        ButtonPanel.add(clear);
        ButtonPanel.add(exit);
        FieldPanel.add(displayL);
        FieldPanel.add(Displayfield);
        Displayfield.setEditable(false);
        FieldPanel.add(inputL);
        FieldPanel.add(Inputfield);

        //Frame Settings
        frame.setSize(300, 300);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                frame.dispose();
            }
        });

        //Listeners
        compute.addActionListener(new computeListener());
        clear.addActionListener(this);
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?");

                if (choice == JOptionPane.YES_OPTION) {
                    frame.dispose();
                }
            }
        });
    }

    //Computation Function
    class computeListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            try {

                double c = Double.parseDouble(Inputfield.getText());

                double f = (c * 9 / 5) + 32;

                Displayfield.setText(String.valueOf(f));

            } catch (Exception ex) {

                Displayfield.setText("Invalid input");

            }
        }
    }

    //Clear Button Function
    public void actionPerformed(ActionEvent e) {

        Inputfield.setText("");
        Displayfield.setText("");

    }

    public static void main(String[] args) {
        new EDPAssignment3();
    }
}
