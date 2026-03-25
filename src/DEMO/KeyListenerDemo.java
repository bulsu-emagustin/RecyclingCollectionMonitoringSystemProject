package DEMO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyListenerDemo {

    public static void main(String[] args) {

        JFrame frame = new JFrame("KeyListener Demo");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Press a key...");
        JTextField textField = new JTextField(15);

        // Add KeyListener
        textField.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                label.setText("Key Typed: " + e.getKeyChar());
            }

            @Override
            public void keyPressed(KeyEvent e) {
                label.setText("Key Pressed: " + KeyEvent.getKeyText(e.getKeyCode()));
            }

            @Override
            public void keyReleased(KeyEvent e) {
                label.setText("Key Released");
            }
        });

        frame.add(textField);
        frame.add(label);

        frame.setVisible(true);
    }
}

