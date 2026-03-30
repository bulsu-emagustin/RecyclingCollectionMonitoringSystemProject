package Practice;

import java.awt.*;
import javax.swing.*;

public class CardLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("CardLayout Demo");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CardLayout cl = new CardLayout();
        JPanel mainPanel = new JPanel(cl);

        // First panel
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.RED);
        JButton btn1 = new JButton("Go to Panel 2");

        // Second panel
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.BLUE);
        JButton btn2 = new JButton("Go to Panel 1");

        // Add panels to CardLayout
        mainPanel.add(panel1, "p1");
        mainPanel.add(panel2, "p2");

        // Button actions
        btn1.addActionListener(e -> cl.show(mainPanel, "p2"));
        btn2.addActionListener(e -> cl.show(mainPanel, "p1"));

        panel1.add(btn1);
        panel2.add(btn2);

        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
