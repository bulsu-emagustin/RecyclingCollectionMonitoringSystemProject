/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practice;

import javax.swing.*;

public class EmptyTableExample {
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Empty JTable");

        // Column names only
        String[] columns = {"ID", "Name", "Course"};

        // Empty data
        String[][] data = {};

        JTable table = new JTable(data, columns);

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);

        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}