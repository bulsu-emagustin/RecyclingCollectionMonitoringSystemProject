package DEMO;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SampleAWT {
    public static void main(String [] args){
        Frame frame = new Frame("Sample Frame");
        TextField text = new TextField(10);
        Button button = new Button("Check");
        Checkbox check = new Checkbox ("I agree");
        Choice program = new Choice();
        program.add("BSIT");
        program.add("BSIS");
        program.add("BSCS");
        
        
        frame.add(text);
        frame.add(button);
        frame.add(check);
        frame.add(program);
        
        System.out.println(text.getText());
        frame.setLayout(null);
        frame.setSize(300, 300);
        
        text.setBounds(100, 100, 100, 100);
        button.setBounds(200, 100, 100, 100);
        check.setBounds(100, 200, 100, 100);
        
        frame.setVisible(true);
        
        //check.addMouseListener(new MouseListener)
        
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e){
                
                String selected = program.getSelectedItem();
                if(check.getState()){
                    System.out.println("Program Selected: " + selected);
                    System.out.println("check check check");
                } else {
                    System.out.println("walang check check check");
                }
            }
        });
        
        frame.addWindowListener(new WindowAdapter()
        { 
            public void windowClosing(WindowEvent e) { 
                frame.dispose(); 
            } 
        });  
        
    }
}
