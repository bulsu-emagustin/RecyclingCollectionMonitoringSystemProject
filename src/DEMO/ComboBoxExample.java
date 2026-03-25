package DEMO;

import javax.swing.*;

public class ComboBoxExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JComboBox Example");

        String[] items = {"Savings", "Current", "Fixed Deposit"};

        JComboBox<String> comboBox = new JComboBox<>(items);

        frame.add(comboBox);

        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
