package DEMO;

import javax.swing.*;
import java.awt.*;

public class GridLayoutExample {
    public static void main(String[] args) {

        // Create Frame
        JFrame frame = new JFrame("GridLayout Example");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set GridLayout (2 rows, 3 columns, with gaps)
        frame.setLayout(new GridLayout(2, 3, 10, 10));

        // Add components
        frame.add(new JButton("1"));
        frame.add(new JButton("2"));
        frame.add(new JButton("3"));
        frame.add(new JButton("4"));
        frame.add(new JButton("5"));
        frame.add(new JButton("6"));

        // Make frame visible
        frame.setVisible(true);
    }
}

