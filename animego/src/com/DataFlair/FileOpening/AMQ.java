package com.DataFlair.FileOpening;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
public class AMQ   extends JFrame implements ActionListener {
    JButton button3 = new JButton() ;
    AMQ(){
        ImageIcon icon3 = new ImageIcon("Images\\yato(1).png");
        JButton button3 = new JButton();

        button3.setBounds(0, 0, 300, 400);

        button3.setText("I wanna play AMQ!");
        button3.setFocusable(false);
        button3.setIcon(icon3);
        button3.setHorizontalTextPosition(JButton.CENTER);//button position and customization
        button3.setVerticalTextPosition(JButton.TOP);
        button3.setFont(new Font("Comic Sans", Font.BOLD, 25));
        button3.setBackground(Color.LIGHT_GRAY);

        button3.addActionListener(this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(300, 400);
        this.setVisible(true);
        this.add(button3);
        this.setResizable(false);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Desktop desk1 = Desktop.getDesktop();

        String AMQ = "https://animemusicquiz.com/";
        try {
            desk1.browse(new URI(AMQ));
        } catch (IOException | URISyntaxException exx) {
        }
    }
}
