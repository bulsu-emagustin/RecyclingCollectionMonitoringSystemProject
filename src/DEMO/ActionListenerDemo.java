package DEMO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ActionListenerDemo {

    public static void main(String[] args) {

        // Create Frame
        JFrame frame = new JFrame("Listener Demo");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Create Components
        JLabel label = new JLabel("Button not clicked yet.");
        JButton button = new JButton("Click Me");

        // Add ActionListener to button
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Button was clicked!");
            }
        });

        // Add components to frame
        frame.add(label);
        frame.add(button);

        // Make frame visible
        frame.setVisible(true);
    }
}

