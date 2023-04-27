package com.DataFlair.FileOpening;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class AnimeWatch extends JFrame implements ActionListener
{
    JButton button1 = new JButton();
    String important_notice = "************ IMPORTANT ************* \n" +
            "This project was made solely by me the creator.For any questions email me at tkardaras1@gmail.com"+" ;D";

    static String URL;
    static int min = 0;
    static int max = 40;
    static int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);


    static String[] AniList = {
            "Angels of Death",//0
            "talentless nana",
            "86",
            "Shingeki no kyojin",
            "boku no hero academia",//4
            "Jujutsu Kaissen",
            "Jojo's Bizzare Adventure",
            "Black Clover",
            "Death Note",
            "Love is War",//9
            "SPY X FAMILY",
            "Monster",
            "Code Geass",
            "Kimetsu no yaiba",
            "One Piece",//14
            "durarara",
            "Chainsaw Man",
            "One punch man",
            "Hunter x hunter",
            "horimiya",//19
            "Akame ga kill",
            "Blend S",
            "Dr. Stone",
            "flcl",
            "Sword Art Online",//24
            "Fate/Zero",
            "Stein's Gate",
            "Tokyo Ghoul",
            "Beastars",
            "bleach",//29
            "naruto",
            "violet evergarden",
            "kill-la-kill,",
            "Samurai Champloo",
            "Fruits Basket",//34
            "Cowboy Bebop",
            "Black Lagoon",
            "Angel Beats",
            "urusei yatsura 2022",
            "haikyuu",//39
            "Hataraku-maou-sama"
    };
    AnimeWatch() {                                     //my constructor
        ImageIcon icon1 = new ImageIcon("C:\\Users\\tkard\\Downloads\\anime02.jpg");

        JButton button1 = new JButton();//button instance


        button1.setBounds(0, 0, 300, 500);

        button1.setText("LET'S WATCH");
        button1.setFocusable(false);
        button1.setIcon(icon1);
        button1.setHorizontalTextPosition(JButton.CENTER);          //button position and customization
        button1.setVerticalTextPosition(JButton.TOP);
        button1.setFont(new Font("Comic Sans", Font.BOLD, 25));
        button1.setBackground(Color.LIGHT_GRAY);

        button1.addActionListener(this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(300, 500);                         //frame
        this.setVisible(true);
        this.add(button1);
        this.setResizable(false);                                   //for now at least not resizable
    }
    @Override
    public void actionPerformed(ActionEvent a)
    {                    //when (not if)button is pressed do smth

        JOptionPane.showMessageDialog(null,"Our daily recommendation for you is watching the anime called:" + AniList[random_int]);
        JOptionPane.showMessageDialog(null,"for dub just add dub after example:  animetitle-season-2-dub");
        Desktop desk = Desktop.getDesktop();

        String title = JOptionPane.showInputDialog("what are we watching ?:");


        int episode = Integer.parseInt((JOptionPane.showInputDialog("Enter the anime episode you are about to watch:")));

        PrintWriter writer = null;
        try {
            writer = new PrintWriter("anime.txt", "UTF-8");         //create file
            } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
            } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
            }
                writer.println(important_notice);
                writer.println("title:" + title);
                writer.println("episode:" + episode);
                writer.close();
        try {
            File file_open = new File("anime.txt");                    //open file
            if (!Desktop.isDesktopSupported()) {
                JOptionPane.showMessageDialog(null,"Desktop Support Not Present in the system.");
                return;}
                Desktop desktop = Desktop.getDesktop();
            if (file_open.exists())
                desktop.open(file_open);
            } catch (Exception e)   {
            e.printStackTrace();
                                    }

        URL = "https://gogoanime.tel/search.html?keyword=" + title;
        try {
            desk.browse(new URI(URL));
            } catch (IOException e) {
            throw new RuntimeException(e);
            } catch (URISyntaxException e) {
            throw new RuntimeException(e);
            }
        for (int i = 0; i < 9999; i++)
        {
            //as a one piece fan you can never have too many episodes

            URL = "https://gogoanime.tel/" + title + "-episode-" + episode;
            episode = episode + 1;

            try {
                desk.browse(new URI(URL));
                 } catch (IOException e) {
                throw new RuntimeException(e);
                } catch (URISyntaxException e) {
                throw new RuntimeException(e);
                }

            try {
                Thread.sleep(1_440_000);//about the length of a 24_minute episode
                } catch (InterruptedException e) {
                throw new RuntimeException(e);
                }
        }

    }
}




