package DEMO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TableExample2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JTable Example");

        String[] columns = {"ID", "Name", "Balance"};

        Object[][] data = {
                {"001", "John", 5000},
                {"002", "Mary", 7000},
                {"003", "Alex", 3000}
        };

        DefaultTableModel model = new DefaultTableModel(data, columns);
        JTable table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
