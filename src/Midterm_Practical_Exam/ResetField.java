package Midterm_Practical_Exam;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ResetField {
    public static void main(String[] args) {
        //Frame Container
        JFrame frame = new JFrame("Form Reset");
 
        //Buttons Code
        JButton enterbutton = new JButton("Enter");
        JButton resetbutton = new JButton("Reset");
        enterbutton.setBounds(60,60,70,50);
        resetbutton.setBounds(150,60,70,50);        
        frame.add(enterbutton);
        frame.add(resetbutton);  

        //Textfield Code
        JTextField input1 = new JTextField(25);
        JTextField input2 = new JTextField(25);
        JPanel panel = new JPanel();
        panel.add(input1);
        panel.add(input2);
        frame.add(panel);  
        
        //Action Listener
        enterbutton.addActionListener(e -> {
            System.out.println("Nice to meet you! " + input1.getText() + " " + input2.getText());
        }); 
        
        resetbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input1.setText("");
                input1.requestFocus();
                input2.setText("");

            }
        });        
        
        //Settings
        frame.setVisible(true);
        frame.setSize(300, 150);
    }
}
