package com.DataFlair.FileOpening;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class MAL   extends JFrame implements ActionListener {
    static String MAlurl;


    JButton button2 = new JButton() ;
    MAL(){
        ImageIcon icon2 = new ImageIcon("C:\\Users\\tkard\\Downloads\\anime girl image java(1).jpg");
        JButton button2 = new JButton();

        button2.setBounds(0, 0, 300, 500);

        button2.setText("Open MAL Kudasai!");
        button2.setFocusable(false);
        button2.setIcon(icon2);
        button2.setHorizontalTextPosition(JButton.CENTER);          //button position and customization
        button2.setVerticalTextPosition(JButton.TOP);
        button2.setFont(new Font("Comic Sans", Font.BOLD, 20));
        button2.setBackground(Color.LIGHT_GRAY);

        button2.addActionListener(this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(300, 500);                         //frame
        this.setVisible(true);
        this.add(button2);
        this.setResizable(false);
    }




        @Override
        public void actionPerformed(ActionEvent e) {
            {
                Desktop desk = Desktop.getDesktop();
                MAlurl = "https://myanimelist.net/";

                System.out.println("Opening your browser and redirecting you now");
                try {
                    desk.browse(new URI(MAlurl));
                } catch (IOException | URISyntaxException ex) {
                }


            }

        }
    }



