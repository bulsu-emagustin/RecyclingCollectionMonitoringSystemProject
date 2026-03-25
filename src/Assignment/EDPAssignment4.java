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

public class EDPAssignment4 implements ActionListener {

    Frame frame;
    Label principalL, rateL, timeL, resultsL;
    TextField principalF, rateF, timeF, simpleinterestF;
    Button computeB, clearB, exitB;
    Panel inputP, buttonP;

    public EDPAssignment4() {
        //Containers
        frame = new Frame("Simple Interest Calculator");
        inputP = new Panel();
        buttonP = new Panel();

        //Field Settings
        inputP.setBounds(50, 30, 300, 215);
        inputP.setBackground(Color.cyan);
        inputP.setLayout(null);
        principalL = new Label("Principal: ");
        principalL.setBounds(10, 30, 55, 20);
        principalL.setBackground(Color.WHITE);
        principalF = new TextField(50);
        principalF.setBounds(70, 30, 220, 20);
        rateL = new Label("Rate: ");
        rateL.setBounds(10, 75, 55, 20);
        rateL.setBackground(Color.WHITE);
        rateF = new TextField(50);
        rateF.setBounds(70, 75, 220, 20);
        timeL = new Label("Time: ");
        timeL.setBounds(10, 120, 55, 20);
        timeL.setBackground(Color.WHITE);
        timeF = new TextField(50);
        timeF.setBounds(70, 120, 220, 20);
        resultsL = new Label("Results: ");
        resultsL.setBounds(10, 165, 55, 20);
        resultsL.setBackground(Color.WHITE);
        simpleinterestF = new TextField(50);
        simpleinterestF.setBounds(70, 165, 220, 20);
        simpleinterestF.setEditable(false);

        //Button Settings
        buttonP.setBounds(50, 255, 300, 130);
        buttonP.setBackground(Color.GREEN);
        buttonP.setLayout(null);
        computeB = new Button("Compute");
        computeB.setBounds(30, 30, 100, 30);
        clearB = new Button("Clear");
        clearB.setBounds(170, 30, 100, 30);
        exitB = new Button("Exit");
        exitB.setBounds(30, 80, 240, 30);

        //Adding Components
        frame.add(inputP);
        inputP.add(principalL);
        inputP.add(principalF);
        inputP.add(rateL);
        inputP.add(rateF);
        inputP.add(timeL);
        inputP.add(timeF);
        inputP.add(resultsL);
        inputP.add(simpleinterestF);
        frame.add(buttonP);
        buttonP.add(computeB);
        buttonP.add(clearB);
        buttonP.add(exitB);

        //Frame Settings
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                frame.dispose();
            }
        });

        //Listeners
        computeB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double p = Double.parseDouble(principalF.getText());
                    double r = Double.parseDouble(rateF.getText());
                    double t = Double.parseDouble(timeF.getText());

                    double si = (p * r * t) / 100;

                    simpleinterestF.setText(String.valueOf(si));
                } catch (Exception ex) {
                    simpleinterestF.setText("Invalid Input");
                }
            }
        });

        clearB.addActionListener(
                new ClearButtonListener(principalF, rateF, timeF, simpleinterestF)
        );

        exitB.addActionListener(this);
    }

    class ClearButtonListener implements ActionListener {

        TextField principal, rate, time, result;

        ClearButtonListener(TextField p, TextField r, TextField t, TextField res) {
            principal = p;
            rate = r;
            time = t;
            result = res;
        }

        public void actionPerformed(ActionEvent e) {
            principal.setText("");
            rate.setText("");
            time.setText("");
            result.setText("");
        }
    }

    public void actionPerformed(ActionEvent e) {

        int choice = JOptionPane.showConfirmDialog(
                frame,
                "Are you sure you want to exit?",
                "Exit Confirmation",
                JOptionPane.YES_NO_OPTION
        );

        if (choice == JOptionPane.YES_OPTION) {
            frame.dispose();
        }
    }

    public static void main(String[] args) {
        new EDPAssignment4();
    }
}
