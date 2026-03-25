package Assignment;
import java.awt.*; 
import java.awt.event.*; 
 
public class EDPAssignment2 {
    Frame frame;
    Label name1, name2;
    TextField firstname, lastname;
    Button button;
    
    public EDPAssignment2() {
        frame = new Frame("Username");
        firstname = new TextField(30);
        lastname = new TextField(30);
        name1 = new Label("Enter First Name: ");
        name2 = new Label("Enter Last Name: ");
        button = new Button("Submit");
        
        button.addActionListener(e -> 
            System.out.println("Hello! " + firstname.getText() + " " + lastname.getText() ) 
        );
        
        frame.add(name1);
        frame.add(firstname);
        frame.add(name2);
        frame.add(lastname);
        frame.add(button);

        frame.setSize(350, 200);
        frame.setVisible(true);
        frame.setLayout(new FlowLayout()); 
        
        frame.addWindowListener(new WindowAdapter()
        { 
            public void windowClosing(WindowEvent e) { 
                frame.dispose(); 
            } 
        }); 
    }
 
    public static void main(String[] args) { 
        new EDPAssignment2();
    } 

} 
