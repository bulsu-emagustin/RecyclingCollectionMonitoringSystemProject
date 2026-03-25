package DEMO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BasicSwingSample {

	public static void main(String[] args) {
		JFrame frame = new JFrame("JFrame Sample");
		JButton button = new JButton("Button");
		JButton button2 = new JButton("Button2");
		
		frame.setLayout(null);
		
		button.setBounds(100, 100, 100, 100);
		button2.setBounds(200, 100, 100, 100);
		frame.add(button);
		frame.add(button2);
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showConfirmDialog(button, "Are you sure?");
				if(answer == JOptionPane.YES_OPTION) {
					System.out.println("YESSSSSSS!!!");
				} else if(answer == JOptionPane.NO_OPTION) {
					System.out.println("IT\'S A NO NO!!");
				} else if(answer == JOptionPane.CANCEL_OPTION) {
					System.out.println("CANCELLED");
				}
				
			}
		});
		
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog(button, "Please enter your name: ");
				
				if(name.equalsIgnoreCase("alejandro")) {
					System.out.println("Mabait yan..");
				}
				
			}
		});
	}

}
