package com.DataFlair.FileOpening;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;


public class Game extends JFrame implements ActionListener {
    int charge = 0;
    int starting_positionx = 0;
    int starting_positiony = 100;
    int HP = 101;
    int ATK = 10;
    int BossHP = 300;
    int kill_count = 0;
    String VictoryMessage ="⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⣤⣄⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣀⣀⠤⠤⠴⠶⠒⠋⠉⠁⠀⠀⢀⣴⣿⣿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⡤⠴⠒⠒⠋⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣴⣾⣿⣿⣿⣿⣿⣯⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⣀⠴⠚⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣤⣤⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡞⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⡼⠁⠀⠀⢀⣀⣀⣀⣀⣤⣤⣴⣶⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡧⢱⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠈⠀⣀⣤⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⣀⣓⢤⣤⡤⠀⠀⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⢩⣿⣿⡿⠟⢛⣛⢿⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⢻⡍⢿⡯⠁⠀⠀⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⣿⣿⡇⢰⣾⢸⡈⣆⢹⣿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⢸⡇⠀⡇⠀⢀⠀⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⣠⠞⠉⠉⠛⢧⢈⣧⣧⣷⠿⣎⣿⡘⣿⣿⣿⡿⠛⡻⣿⣿⣿⣿⣿⣿⣧⠰⠥⠴⡟⠀⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⢱⠀⠀⠀⠀⠀⠀⠀⢠⠇⠀⠈⠳⣦⠘⡞⡎⠛⢢⡄⢹⣸⣇⡿⠛⢉⣵⣶⣷⣿⣿⣿⣿⣿⡻⣝⡛⢿⡟⠁⠀⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠸⡄⠀⠀⠀⠀⠀⠀⠸⡀⠀⢀⡄⣹⡇⣣⠹⣸⣿⠿⢾⠉⣀⣤⣖⣋⣾⣷⣾⣿⣿⣿⠻⣝⣎⡐⡄⣁⢱⡀⠀⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⢳⣀⠀⠀⠀⠀⠀⠀⠀⣤⣾⠥⠿⢷⠛⣋⣩⣤⠶⣾⡿⢟⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣿⣿⣧⣷⢸⡻⠇⠀⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⢸⣉⣉⣏⣉⣉⣉⣏⣉⣭⣤⠴⠶⠞⠛⠋⣉⣤⠾⣫⣴⣿⣟⣛⡧⣦⣽⣿⣿⣿⠋⣿⣿⣿⣿⣿⣀⠳⣤⠆⣀⡀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⢠⠎⠀⠀⠀⠉⠉⠀⠀⠀⠀⠀⠀⣀⣠⣶⡾⣋⣷⣿⣏⣻⣷⠿⣗⣲⡾⣿⣿⣿⡇⣸⣿⣿⢹⣿⣷⠺⢍⠭⠟⠉⠀⠀⢀\n" +
            "⠀⠀⠀⢀⡴⠃⠀⠀⠀⠀⣀⣀⣀⣤⣴⣶⣾⣿⣿⣫⣷⣾⣿⡷⡿⡿⢿⣋⡏⣀⣼⣿⣿⣿⣿⣿⠙⣿⣿⣾⢿⠻⣷⠈⡇⠀⠀⡠⠒⢉\n" +
            "⠀⠀⣠⠎⠀⠀⠀⠈⠙⠛⠛⠛⠛⣛⣻⡿⢿⣿⣿⡿⠛⣺⣯⣾⣛⣧⠤⠞⠊⠁⠀⢸⣿⣿⣿⣿⣾⠿⡟⣿⣌⣧⣹⡧⠜⣦⠞⢀⣴⣾\n" +
            "⣠⠾⠁⠀⠀⠀⠀⢀⣀⣤⣶⠾⠟⣋⣵⣾⣿⣿⣿⠟⢿⡟⠁⠀⠙⢏⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⠀⣠⡾⣿⣿⣿⣿⣷⣘⡏⣰⣿⣿⣿\n" +
            "⠋⢀⣀⣤⣴⠶⠟⢛⣋⡭⠴⠚⠋⢻⣿⣿⣿⠿⠿⡆⠘⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣿⣿⣿⡟⣾⣿⣧⣿⠀⣶⣶⣶⣾⣿⣿⣿⣿⣿\n" +
            "⠚⢛⣉⣩⡴⠶⠚⠋⠉⠀⠀⠀⠀⠸⡿⡏⠁⠀⢰⠃⠀⠀⠀⢠⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⡇⣿⣿⣿⣿⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
            "⣏⣉⣁⣀⡀⠀⠀⢀⣀⣀⣀⣀⣀⠤⢷⢱⠀⠀⠸⢤⣤⣶⡿⠟⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⡇⣿⣿⣿⣿⠀⢿⣿⣿⣿⣿⡿⠋⢁⣴\n" +
            "⡇⠀⢦⣬⣭⣭⣍⣍⣀⣀⣤⣤⣤⠶⠞⢣⡀⠀⠀⠀⠈⢉⠠⣀⣀⣀⡀⠀⠀⠀⠀⢀⣿⣿⡟⣽⣿⣿⣿⣿⡇⢸⣿⣿⡿⠃⠀⣴⣿⣿\n" +
            "⣧⠀⢸⣿⣩⣉⣉⣉⣩⠭⢭⣥⣴⣶⣾⣿⣷⡄⠀⠀⡼⠛⠛⠛⠉⠉⠉⠉⠀⠀⠀⣸⡿⢋⣼⠋⣿⣿⣿⣿⣷⠀⣿⣿⠃⠀⢸⣿⣿⡏\n" +
            "⣿⠀⢸⣿⣷⣶⣶⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣆⠀⠀⢢⣤⣶⣶⣶⣶⠎⠀⠀⢸⢏⣴⣿⡏⠀⣿⣿⡏⠀⠘⡄⣿⣿⠀⠀⣿⣿⣿⣿\n" +
            "⣿⡄⠘⣶⣶⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣆⠀⠀⠉⠉⠉⠉⠁⠀⠀⢠⣿⣿⠿⣿⠁⠀⣿⣿⣧⠀⠀⣧⢸⣿⠀⠀⣿⣿⣿⣿\n" +
            "⣿⡇⠀⡿⠿⠮⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠙⣦⠀⠀⠀⠀⠀⠀⢀⣴⣿⠟⠁⢀⡏⠀⠀⢻⣿⣿⡄⠀⣿⣼⣿⡆⠀⢻⣿⣿⣄\n" +
            "⣿⣇⠀⢳⣸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣇⠀⠘⣷⣤⣤⣤⣴⣶⡿⠋⠁⠀⠀⡜⠀⠀⠀⠸⣿⣿⣿⣦⡏⣿⣿⠙⣄⠀⢻⣿⣿\n" +
            "⣿⣿⠀⢸⣿⡇⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⢿⠙⠿⣿⠿⠋⠀⠀⠀⠀⡜⠀⣠⠀⠀⠀⠟⠛⠻⠿⠿⣿⠇⠀⣾⣦⣀⢹⣿\n" +
            "⣿⣿⠀⢸⣿⣇⣼⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠁⠘⡆⠀⢸⣧⡀⠀⠀⠀⠀⠀⠀⡼⠁⠀⡟⠀⢠⣶⣶⣶⣶⣾⣿⣿⠀⠀⣿⣿⣿⣿⣽\n" +
            "⠛⠉⠀⠉⠉⣉⣽⣿⣿⣿⠿⢿⣿⣿⡿⠁⠀⢀⣰⠁⠀⢸⠏⢻⣿⠆⠀⠀⡠⠊⠀⠀⢀⠇⠀⢸⣿⣿⣿⣿⣿⣿⣿⠀⣠⠟⠉⢉⣿⣿\n" +
            "⢀⣤⣶⣾⣿⣿⣿⣿⡿⠁⠀⠀⠈⠛⠷⠤⠤⣀⡀⠀⠀⣸⠀⠀⠁⢀⠴⠊⠀⢀⣀⡤⠞⡄⢀⣿⣿⣿⡫⣵⣿⣿⡿⠋⠀⢀⣴⣿⣿⠟\n" +
            "⣿⣿⣿⣿⣿⣋⠵⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣦⠀⠁⢀⡠⠴⠧⠤⠄⠊⠉⠁⢀⡰⠁⠘⣡⡟⣩⣿⣿⣿⣿⠁⠀⣰⣿⡿⠋⠁⠀\n" +
            "⣿⣿⣿⣟⣿⣏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⣿⠀⡰⠋⠀⠀⠀⠀⠀⠀⠠⣴⣿⠃⠀⣴⣿⣾⣿⣿⣿⣿⡇⠀⠀⣿⣿⣇⠀⢀⣴\n" +
            "⣿⣿⡟⣾⣯⠘⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⣿⠞⠁⠀⠀⠀⠀⠀⠀⠀⠀⢸⠏⠀⠀⠜⣿⣿⣿⣿⣿⣿⡄⠀⠀⣿⡇⣿⣿⣿⣯\n" +
            "⣿⣿⢡⣿⣿⢦⠘⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠎⠀⠀⠀⢠⣿⣿⣿⣿⣿⣿⣷⠀⠀⢿⣧⢻⣿⠟⠿\n" +
            "⣿⢇⣾⡏⠹⡀⢣⠘⢆⠀⠀⠀⠀⠀⠀⠀⠀⣼⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⡰⠃⠀⠀⠀⢀⣾⣿⣿⣿⣿⣿⣿⠏⢣⡀⠈⢿⣿⣿⡄⠀\n" +
            "⡏⣼⣿⡇⠀⢣⠀⠣⠈⢫⡢⢄⡀⠀⠀⠀⣰⣿⠃⠀⠀⠀⠀⠀⠀⠀⣠⠎⠀⠀⠀⣀⣴⣿⣿⣿⣿⣿⣿⣿⣿⠀⠰⣷⣄⡀⠙⣿⣧⡀\n" +
            "GOOD JOB";
    JPanel panel = new JPanel();
    Random random = new Random();
    int randomNumber = random.nextInt(8);

    //public void setRandomNumber(int randomNumber) {
        //this.randomNumber = randomNumber;
   // }

    public Game() throws InterruptedException {
        ImageIcon Boss = new ImageIcon("Images\\dio_original-removebg-preview.png");
        ImageIcon Player = new ImageIcon("Images\\jotaro_original-removebg-preview.png");
        ImageIcon StandJotaro = new ImageIcon("Images\\jotaro stand.png");
        ImageIcon Enemy = new ImageIcon("Images/bat_enemy_50_50-removebg-preview.png");
        ImageIcon Player_help = new ImageIcon("Images\\kakyoin-removebg-preview.png");
        ImageIcon Player_help_stand = new ImageIcon("Images\\kakyoin_stand_80-100_new-removebg-preview.png");

        setTitle("Game-chan");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.white);
        panel.setLayout(null);
        panel.setBackground(Color.white);

        JButton player = new JButton(Player);
        JButton player1 = new JButton(StandJotaro);
        JButton ultimate = new JButton("Q");
        JButton skill = new JButton("E");

        JButton enemy = new JButton("x");
        JButton enemy_spanner = new JButton("S");

        JButton boss = new JButton(Boss);
        JButton boss_up = new JButton();
        JButton boss_down = new JButton();
        JButton boss_left = new JButton();
        JButton boss_right = new JButton();

        JButton player_help = new JButton(Player_help);
        JButton player_help_stand = new JButton(Player_help_stand);

        final int[] player_y = {starting_positiony};
        final int[] player_x = {starting_positionx};




//player
        player.setFocusable(false);
        player.setBorder(null);
        player.setBackground(Color.white);
        player.setVisible(true);
        player.setBounds(starting_positionx, starting_positiony, 60, 100);
        panel.add(player);
        player.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowStats(player, HP, ATK);
            }
            //health bar
        });
        JTextField PlayerLife = new JTextField();
        PlayerLife.setBackground(Color.green);
        PlayerLife.setBounds(10, 950, 400, 30);
        PlayerLife.setVisible(true);
        panel.add(PlayerLife);
        PlayerLife.setEditable(false);
        JTextField PlayerLifeLost = new JTextField();
        PlayerLifeLost.setBackground(Color.white);
        PlayerLifeLost.setBounds(210, 950, 1, 30);
        PlayerLifeLost.setVisible(false);
        panel.add(PlayerLifeLost);

        PlayerLife.setEditable(false);
        if (HP == 51) {
            PlayerLife.setEditable(true);
            PlayerLife.setBackground(new Color(234, 91, 34, 255));
            PlayerLife.setBounds(10, 950, 200, 30);
            PlayerLifeLost.setVisible(true);
            PlayerLifeLost.setBounds(210, 950, 200, 30);
        }
        //player's stand
        player1.setBorder(null);
        player1.setFocusable(false);
        player1.setBackground(new Color(92, 34, 154));
        player1.setVisible(false);
        player1.setBounds(550, 400, 80, 100);
        panel.add(player1);
        //skill
        skill.setFocusable(false);
        skill.setBackground(new Color(58, 133, 180));
        skill.setVisible(true);
        skill.setBounds(1700, 100, 50, 50);
        panel.add(skill);
        skill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (charge == 3) {
                    JOptionPane.showMessageDialog(null, "Charge is full");
                } else {
                    SoundPlayer soundPlayer4 = new SoundPlayer();
                    soundPlayer4.playSound("audio\\Y2Mate.is - Star Platinum Summon Sound Effect-cZLUBF0_uOo-48k-1658058451351 (mp3cut.net).wav");
                    JOptionPane.showMessageDialog(null, "Star Platinum Charge");


                    charge++;
                }
            }
        });
        JButton[] oraButtons = new JButton[2];
        for (int i = 0; i < oraButtons.length; i++) {
            oraButtons[i] = new JButton();
            oraButtons[i].setFocusable(false);
            oraButtons[i].setBackground(new Color(92,34,154));
            oraButtons[i].setVisible(false);
            oraButtons[i].setBounds(551+ (i * 25), 410, 20, 20);
            panel.add(oraButtons[i]);
        }
        //ultimate
        ultimate.setFocusable(false);
        ultimate.setBackground(new Color(90, 61, 157));
        ultimate.setVisible(true);
        ultimate.setBounds(1700, 150, 50, 50);
        panel.add(ultimate);
        ultimate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (charge >= 3) {
                    SoundPlayer soundPlayer = new SoundPlayer();
                    soundPlayer.playSound("audio\\Y2Mate.is - ORA ORA ORA - Sound effect-bz5Z1yxs8cY-48k-1659817090874 (mp3cut.net)(1).wav");
                    charge = 0;
                    player1.setVisible(true);
                    panel.setBackground(new Color(92, 34, 154));
                    player.setBackground(new Color(92,34,154));
                    player_help.setBackground(new Color(92,34,154));
                    player_help_stand.setBackground(new Color(92,34,154));
                    enemy.setBackground(new Color(92,34,154));
                    JOptionPane.showMessageDialog(null, " ORA ORA ORA ORA ORA ORA ORA ORA ORA ORA ORA ORA ORA ORA ORA ORA ORA ");
                    ATK = ATK +50;
                    if(HP>=101){
                        JOptionPane.showMessageDialog(null,"Already at max HP");
                    }
                    else{
                        HP = HP + 100;
                    }
                    panel.setBackground(Color.white);
                    player.setBackground(Color.white);
                    player_help.setBackground(Color.white);
                    player_help_stand.setBackground(Color.white);
                    enemy.setBackground(Color.white);
                    soundPlayer.stopSound();
                    for (int i = 0; i < oraButtons.length; i++) {
                        oraButtons[i].setVisible(true);
                        oraButtons[i].setLocation(315 + (i * 5), 110);
                        moveButtonsToBoss(oraButtons, 800, 600);
                    }player1.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Ultimate needs charge first");
                }
            }
        });//kakyoin attack
        JButton[] attackButtons = new JButton[4];
        for (int i = 0; i < attackButtons.length; i++) {
            attackButtons[i] = new JButton();
            attackButtons[i].setFocusable(false);
            attackButtons[i].setBackground(new Color(48, 161, 14));
            attackButtons[i].setVisible(false);
            attackButtons[i].setBounds(315 + (i * 80), 110, 30, 30);
            panel.add(attackButtons[i]);
        }
//kakyoin
        player_help.setBorder(null);
        player_help.setFocusable(false);
        player_help.setBackground(Color.white);
        player_help.setVisible(true);
        player_help.setBounds(200, 100, 60, 100);
        panel.add(player_help);

        JTextField kakyoin = new JTextField("you got this Jotaro!!");
        kakyoin.setVisible(false);
        kakyoin.setBounds(200, 80, 150, 20);
        kakyoin.setEditable(false);
        panel.add(kakyoin);

        player_help_stand.setBorder(null);
        player_help_stand.setFocusable(false);
        player_help_stand.setBackground(Color.white);
        player_help_stand.setVisible(false);
        player_help_stand.setBounds(315, 110, 80, 100);
        panel.add(player_help_stand);

        player_help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(kill_count<4){
                    JOptionPane.showMessageDialog(null,"you need to kill more bats so that i can get my energy back" );
                }
                else if (kill_count >= 4) {
                    player_help.setVisible(false);
                    player_help_stand.setVisible(true);
                    SoundPlayer soundPlayer2 = new SoundPlayer();
                    soundPlayer2.playSound("audio\\emeraldsplash (mp3cut.net).wav");
                    panel.setBackground(new Color(47, 86, 23));
                    player.setBackground(new Color(47,86,23));
                    player_help.setBackground(new Color(47,86,23));
                    player_help_stand.setBackground(new Color(47,86,23));
                    enemy.setBackground(new Color(47,86,23));
                    JOptionPane.showMessageDialog(null, "Emerald Splash");


                    for (int i = 0; i < attackButtons.length; i++) {
                        attackButtons[i].setVisible(true);
                        attackButtons[i].setLocation(315 + (i * 80), 110);
                        moveButtonToBoss(attackButtons[i], 800, 600);
                        BossHP =BossHP- 5;
                    }
                    panel.setBackground(Color.white);
                    player.setBackground(Color.white);
                    player_help.setBackground(Color.white);
                    player_help_stand.setBackground(Color.white);
                    enemy.setBackground(Color.white);

                }player_help_stand.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        SoundPlayer soundPlayer3 = new SoundPlayer();
                        soundPlayer3.playSound("audio\\emeraldsplash (mp3cut.net).wav");
                        panel.setBackground(new Color(47, 86, 23));
                        player.setBackground(new Color(47,86,23));
                        player_help.setBackground(new Color(47,86,23));
                        player_help_stand.setBackground(new Color(47,86,23));
                        enemy.setBackground(new Color(47,86,23));
                        JOptionPane.showMessageDialog(null, "Emerald Splash");

                        for (int i = 0; i < attackButtons.length; i++) {
                            attackButtons[i].setVisible(true);
                            attackButtons[i].setLocation(315 + (i * 80), 110);
                            moveButtonToBoss(attackButtons[i], 800, 600);
                            BossHP =BossHP- 5;
                        }
                        panel.setBackground(Color.white);
                        player.setBackground(Color.white);
                        player_help.setBackground(Color.white);
                        player_help_stand.setBackground(Color.white);
                        enemy.setBackground(Color.white);
                    }
                });


            }
        });



//enemy
        enemy.setBorder(null);
        enemy.setFocusable(false);
        enemy.setBackground(Color.white);
        enemy.setVisible(true);
        enemy.setBounds(200, 300, 50, 50);
        enemy.setIcon(Enemy);
        panel.add(enemy);
        enemy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    JOptionPane.showMessageDialog(null, "enemy killed");
                    kill_count++;
                    enemy.setVisible(false);

            }
        });

        enemy_spanner.setFocusable(false);
        enemy_spanner.setBackground(Color.RED);
        enemy_spanner.setVisible(true);
        enemy_spanner.setBounds(1700,210, 50, 50);
        panel.add(enemy_spanner);
        enemy_spanner.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "enemy will spawn");
                    int random_x = random.nextInt(1800);
                    int random_y = random.nextInt(500);
                    enemy.setBounds(random_x,random_y,50,50);
                    enemy.setVisible(true);
                    panel.add(enemy);


            }
        });

            //health bar


        boss_up.setFocusable(false);
        boss_up.setBackground(new Color(255, 215, 0));
        boss_up.setVisible(false);
        boss_up.setBounds(820, 590, 50, 10);
        panel.add(boss_up);
        boss_down.setFocusable(false);
        boss_down.setBackground(new Color(255, 215, 0));
        boss_down.setVisible(false);
        boss_down.setBounds(820, 700, 50, 10);
        panel.add(boss_down);
        boss_left.setFocusable(false);
        boss_left.setBackground(new Color(255, 215, 0));
        boss_left.setVisible(false);
        boss_left.setBounds(790, 625, 10, 50);
        panel.add(boss_left);
        boss_right.setFocusable(false);
        boss_right.setBackground(new Color(255, 215, 0));
        boss_right.setVisible(false);
        boss_right.setBounds(890, 625, 10, 50);
        panel.add(boss_right);

        boss.setFocusable(false);
        boss.setBackground(Color.YELLOW);
        boss.setVisible(true);
        boss.setBounds(800, 600, 90, 100);
        panel.add(boss);
        //in case i need to check smthing about dio's ulti
       // setRandomNumber(2);
        boss.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SoundPlayer soundPlayer1 = new SoundPlayer();
                if ((590 <= player_y[0] || player_y[0] <= 710) || 790 <= player_x[0] || player_x[0] <= 910) {
                    JOptionPane.showMessageDialog(null, "Boss took " + ATK + " damage");
                    BossHP = BossHP - ATK;
                    ATK=10;
                    if (BossHP <= 0) {

                        JOptionPane.showMessageDialog(null, "Congratulations!Boss defeated");
                        JOptionPane.showMessageDialog(null, "you are welcome to play again");
                        System.out.println(VictoryMessage);
                        boss.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Boss is counterattacking");

                        {if(randomNumber == 2){
                            try {
                                soundPlayer1.playSound("audio\\Y2Mate.is - [ZA WARUDO OVER HEAVEN] Sound effect-D4H9DO5MwCk-48k-1659878323419 (mp3cut.net)(1).wav");
                                BossUltimate(boss,player,player_help,player_help_stand,enemy);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "MUDA MUDA MUDA MUDA MUDA MUDA MUDA MUDA MUDA ");
                            boss.setBackground(new Color(255, 215, 0));
                            boss_up.setVisible(true);
                            boss_down.setVisible(true);
                            boss_left.setVisible(true);
                            boss_right.setVisible(true);
                            enemy.setBackground(Color.lightGray);
                            player_help_stand.setBackground(Color.lightGray);
                            player_help.setBackground(Color.LIGHT_GRAY);
                            player.setBackground(Color.lightGray);
                            panel.setBackground(Color.LIGHT_GRAY);
                            soundPlayer1.playSound("audio\\Y2Mate.is - ZA WARUDO-7ePWNmLP0Z0-48k-1657990994260 (mp3cut.net)(1).wav");
                            JOptionPane.showMessageDialog(null, "ZA WARUDO!");


                            soundPlayer1.stopSound();

                            try {

                                BossAttack(boss, player,player_help,player_help_stand,enemy);
                                boss_up.setVisible(false);
                                boss_down.setVisible(false);
                                boss_left.setVisible(false);
                                boss_right.setVisible(false);
                                boss.setBackground(Color.yellow);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                        }


                        }
                    }
                }
            }
        });


//w key
        JButton upkey = new JButton("w");
        upkey.setFocusable(false);
        upkey.setBackground(Color.white);
        upkey.setVisible(true);
        upkey.setBounds(1700, 850, 50, 50);
        panel.add(upkey);

        upkey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player_y[0] = player_y[0] - 10;
                player.setBounds(player_x[0], player_y[0], 60, 100);

            }
        });
//s key
        JButton downkey = new JButton("s");
        downkey.setFocusable(false);
        downkey.setBackground(Color.white);
        downkey.setVisible(true);
        downkey.setBounds(1700, 900, 50, 50);
        panel.add(downkey);
        downkey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player_y[0] = player_y[0] + 10;
                player.setBounds(player_x[0], player_y[0], 60, 100);
            }
        });

//a key
        JButton leftkey = new JButton("a");
        leftkey.setFocusable(false);
        leftkey.setBackground(Color.white);
        leftkey.setVisible(true);
        leftkey.setBounds(1650, 900, 50, 50);
        panel.add(leftkey);

        leftkey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player_x[0] = player_x[0] - 10;
                player.setBounds(player_x[0], player_y[0], 60, 100);
            }
        });
//d key
        JButton rightkey = new JButton("d");
        rightkey.setFocusable(false);
        rightkey.setBackground(Color.white);
        rightkey.setVisible(true);
        rightkey.setBounds(1750, 900, 50, 50);
        panel.add(rightkey);
        rightkey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player_x[0] = player_x[0] + 10;
                player.setBounds(player_x[0], player_y[0], 60, 100);
            }
        });
        // Add key listeners to the player
        player.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                // Handle W key press
                if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
                    // Move the player up
                    int currentY = player.getY();
                    player.setLocation(player.getX(), currentY - 10);
                }
                // Handle S key press
                if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
                    // Move the player down
                    int currentY = player.getY();
                    player.setLocation(player.getX(), currentY + 10);
                }
                // Handle A key press
                if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
                    // Move the player left
                    int currentX = player.getX();
                    player.setLocation(currentX - 10, player.getY());
                }
                // Handle D key press
                if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
                    // Move the player right
                    int currentX = player.getX();
                    player.setLocation(currentX + 10, player.getY());
                }//skill
                if(key == KeyEvent.VK_E){
                    if (charge == 3) {
                        JOptionPane.showMessageDialog(null, "Charge is full");
                    } else {
                        SoundPlayer soundPlayer4 = new SoundPlayer();
                        soundPlayer4.playSound("audio\\Y2Mate.is - Star Platinum Summon Sound Effect-cZLUBF0_uOo-48k-1658058451351 (mp3cut.net).wav");
                        JOptionPane.showMessageDialog(null, "Star Platinum Charge");
                        charge++;
                    }
                }//ultimate
                if(key == KeyEvent.VK_Q){
                    if (charge >= 3) {
                        SoundPlayer soundPlayer = new SoundPlayer();
                        soundPlayer.playSound("audio\\Y2Mate.is - ORA ORA ORA - Sound effect-bz5Z1yxs8cY-48k-1659817090874 (mp3cut.net)(1).wav");
                        charge = 0;
                        player1.setVisible(true);
                        panel.setBackground(new Color(92, 34, 154));
                        player.setBackground(new Color(92,34,154));
                        player_help.setBackground(new Color(92,34,154));
                        player_help_stand.setBackground(new Color(92,34,154));
                        enemy.setBackground(new Color(92,34,154));
                        JOptionPane.showMessageDialog(null, " ORA ORA ORA ORA ORA ORA ORA ORA ORA ORA ORA ORA ORA ORA ORA ORA ORA ");
                        ATK = ATK +50;
                        if(HP>=101){
                            JOptionPane.showMessageDialog(null,"Already at max HP");
                        }
                        else{
                            HP = HP + 100;
                        }
                        panel.setBackground(Color.white);
                        player.setBackground(Color.white);
                        player_help.setBackground(Color.white);
                        player_help_stand.setBackground(Color.white);
                        enemy.setBackground(Color.white);
                        soundPlayer.stopSound();
                        for (int i = 0; i < oraButtons.length; i++) {
                            oraButtons[i].setVisible(true);
                            oraButtons[i].setLocation(315 + (i * 5), 110);
                            moveButtonsToBoss(oraButtons, 800, 600);
                        }player1.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Ultimate needs charge first");
                    }
                }
            }
        });

        // Set the focusable property for key events
        player.setFocusable(true);
        player.requestFocusInWindow();
        add(panel);
        setVisible(true);
        panel.add(player);//I add the player here so that he can go behind the others if for example I want to click kakyoin but jotaro was in front I would have to move him
    }
    public void updateHealthBar() {
        JTextField PlayerLife = new JTextField();
        PlayerLife.setBackground(Color.green);
        PlayerLife.setBounds(10, 950, 400, 30);
        PlayerLife.setVisible(true);
        panel.add(PlayerLife);
        PlayerLife.setEditable(false);
        JTextField PlayerLifeLost = new JTextField();
        PlayerLifeLost.setBackground(Color.white);
        PlayerLifeLost.setBounds(210, 950, 1, 30);
        PlayerLifeLost.setVisible(false);
        panel.add(PlayerLifeLost);
        PlayerLife.setEditable(false);
        if (HP == 51) {
            PlayerLife.setEditable(true);
            PlayerLife.setBackground(new Color(234, 91, 34, 255));
            PlayerLife.setBounds(10, 950, 200, 30);
            PlayerLifeLost.setVisible(true);
            PlayerLifeLost.setBounds(210, 950, 200, 30);
        }
        else if(HP ==1){
            PlayerLife.setEditable(true);
            PlayerLife.setBackground(new Color(252, 0, 0, 255));
            PlayerLife.setBounds(10, 950, 5, 30);
            PlayerLifeLost.setVisible(true);
            PlayerLifeLost.setBounds(15, 950, 395, 30);
        }
        else if(HP<=0){
            PlayerLife.setEditable(true);
            PlayerLife.setEditable(true);
            PlayerLifeLost.setVisible(false);
            PlayerLife.setVisible(false);
        }
    }
    public void ShowStats(JButton player, int hp, int attack) {
        JOptionPane.showMessageDialog(null, "HP :" + HP + " ATK :" + ATK + " CHARGES ACTIVE : " + charge+" kill count : "+kill_count);
    }
    public void BossAttack(JButton boss, JButton player,JButton player_help,JButton player_help_stand,JButton enemy) throws InterruptedException {
        Thread.sleep(5000);
        JOptionPane.showMessageDialog(null, "Time will move once again");
        panel.setBackground(Color.WHITE);
        player.setBackground(Color.white);
        player_help.setBackground(Color.white);
        player_help_stand.setBackground(Color.white);
        enemy.setBackground(Color.white);
        HP = HP - 50;
        if (HP <= 0) {
            updateHealthBar();
            JOptionPane.showMessageDialog(null, "You lose Jotaro");
            player.setVisible(false);
            JOptionPane.showMessageDialog(null, "I, the great DIO, sense another human spying on me from afar, likely even right now");
            JOptionPane.showMessageDialog(null, "You are next, human!");
            panel.setVisible(false);
        } else {
            updateHealthBar(); // Update the health bar color when the player takes damage
        }
    }
    public void BossUltimate(JButton boss, JButton player,JButton player_help,JButton player_help_stand,JButton enemy) throws InterruptedException {

        JOptionPane.showMessageDialog(null, "ZA WARUDO OVER HEAVEN");
        panel.setBackground(new Color(215, 138, 27));
        boss.setBackground(new Color(215, 138, 27));
        player.setBackground(new Color(215, 138, 27));
        player_help.setBackground(new Color(215, 138, 27));
        player_help_stand.setBackground(new Color(215, 138, 27));
        enemy.setBackground(new Color(215, 138, 27));

        boss.setBorder(null);
        HP = 0;
        updateHealthBar();
        JOptionPane.showMessageDialog(null, "You lose Jotaro");

        player.setVisible(false);
        player_help.setVisible(false);
        player_help_stand.setVisible(false);

        JOptionPane.showMessageDialog(null, "I, the great and almighty DIO, sense another human spying on me from afar, likely even right now");
        JOptionPane.showMessageDialog(null, "You are next, human!");
        panel.setVisible(false);
    }
    public void moveButtonToBoss(JButton button, int targetX, int targetY) {//kakyoin attck
        int startX = button.getX();
        int startY = button.getY();
        int dx = (targetX - startX) / 100;
        int dy = (targetY - startY) / 100;

        Timer timer = new Timer(10, new ActionListener() {
            int step = 0;
            int totalDamage = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (step < 100) {
                    int newX = startX + (step * dx);
                    int newY = startY + (step * dy);
                    button.setLocation(newX, newY);
                    step++;
                } else {
                    ((Timer) e.getSource()).stop();
                    button.setVisible(false);

                    // Calculate the total damage inflicted
                    int damagePerButton = 5;
                    totalDamage = damagePerButton;
                    BossHP =BossHP- totalDamage;
                }
            }
        });
        timer.start();
    }
    public void moveButtonsToBoss(JButton[] buttons, int targetX, int targetY) {//jotaro attack
        int startX = 550;
        int startY = 400;
        int dx = (targetX - startX) / 100;
        int dy = (targetY - startY) / 100;
        int buttonSpacing = 8;
        Timer timer = new Timer(2, new ActionListener() {
            int step = 0;
            int totalDamage = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (step < 100) {
                    int newX = startX + (step * dx);
                    int newY = startY + (step * dy);
                    for (int i = 0; i < buttons.length; i++) {
                        buttons[i].setLocation(newX + (i * buttonSpacing), newY);
                    }
                    step++;
                } else {
                    ((Timer) e.getSource()).stop();
                    for (JButton button : buttons) {
                        button.setVisible(false);
                    }
                    // Calculate the total damage inflicted
                    int damagePerButton = 20;
                    totalDamage = buttons.length * damagePerButton;
                    BossHP =BossHP- totalDamage;
                }
            }
        });
        timer.start();
    }
     @Override
    public void actionPerformed(ActionEvent e) {

    }
}
