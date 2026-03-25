package DEMO;

import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableExample {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Table Example");
		
		String[] columns = {"ID", "Name", "Age"};
		
		Object[][] data = { {1, "Ana", 20}, {2, "Mark", 21} };
		String[] courses = {"IT 203", "IT 206", "IT 307"};
		JList<String> list = new JList<>(courses);
		
		String[] yearLevels = {"1st Year", "2nd Year", "3rd Year"};
		JComboBox<String> comboBox = new JComboBox<>(yearLevels);
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		JMenu aboutMenu = new JMenu("About");
		JMenuItem exitItem = new JMenuItem("Exit");
		
		fileMenu.add(exitItem);
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(aboutMenu);
		
		frame.setLayout(new FlowLayout());
		
		JTable table = new JTable(data, columns);
		JScrollPane scrollPane = new JScrollPane(table);
		frame.add(menuBar);
		frame.add(list);
		frame.add(comboBox);
		frame.add(scrollPane);
		frame.setSize(500,500);
		frame.setVisible(true);

	}

}

