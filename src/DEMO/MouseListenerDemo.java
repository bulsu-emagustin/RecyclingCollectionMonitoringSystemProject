package DEMO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseListenerDemo {

    public static void main(String[] args) {

        JFrame frame = new JFrame("MouseListener Demo");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel label = new JLabel("Interact with the panel", JLabel.CENTER);

        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);

        // Add MouseListener
        panel.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                label.setText("Mouse Clicked at (" + e.getX() + ", " + e.getY() + ")");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                label.setText("Mouse Pressed");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                label.setText("Mouse Released");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                label.setText("Mouse Entered Panel");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setText("Mouse Exited Panel");
            }
        });

        frame.add(label, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
