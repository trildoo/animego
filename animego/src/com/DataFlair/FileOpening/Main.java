package com.DataFlair.FileOpening;
import javax.swing.*;

public class Main {

    static boolean while_var = false;

    public static void main(String[] args) {
        do {
            try {
                JOptionPane.showMessageDialog(null, "Type 1 to watch anime, 2 to access MyAnimeList and 3 to play AMQ, and 4 to play Game-chan");
                int application = Integer.parseInt(JOptionPane.showInputDialog("I wanna type:"));
                if (application == 1) {
                    AnimeWatch app1 = new AnimeWatch();
                    while_var = true;
                } else if (application == 2) {
                    MAL app2 = new MAL();
                    while_var = true;
                } else if (application == 3) {
                    AMQ app3 = new AMQ();
                    while_var = true;
                } else if (application == 4) {
                    Game app4 = new Game();
                    String game_controls = "GAME CONTROLS:\n" +
                            "MOVEMENT:PLAYER CAN USE EITHER THE W,A,S,D TO MOVE OR THE ARROW KEYS OR THE BUTTONS LOCATED BOTTOM LEFT ON THE FRAME\n" +
                            "NORMAL ATTACK:PLAYER CAN ATTACK BY CLICKING THE ENEMY\n" +
                            "SKILL:BY PRESSING THE 'E' KEY PLAYER WILL GAIN ONE CHARGE,ONCE PLAYER HAS 3 CHARGES HE CAN USE HIS ULTIMATE ABILITY,NO MORE THAN THREE CHARGES ALLOWED AT ONCE\n" +
                            "ULTIMATE:BY PRESSING THE 'Q' KEY WHILE PLAYER HAS 3 CHARGES WILL UNLEASH HIS ULTIMATE WHICH WILL DAMAGE THE ENEMY BOSS,GAIN THE PLAYER ATTACK AND HEAL HIM\n" +
                            "SUPPORT:IF THE PLAYER KILLS THE BASIC ENEMY BAT AND RESPAWNS IT BY THE RED S BUTTON FOR A TOTAL OF 4 TIMES(1+3) KAKYOIN BECOMES AVAILABLE\n" +
                            "KAKYOIN:IF THE PLAYER'S KILL COUNT IS GREATER THAN OR EQUAL TO 4 HE CAN FIRE HIS SPECIAL ATTACK BY CKICKING HIM\n" +
                            "BOSS:AFTER THE PLAYER MAKES HIS MOVE,BOSS WILL ATTACK.THERE IS ALSO A SMALL PERCENTAGE THAT THE BOSS KILLS THE PLAYER INSTANTANEOUSLY(ZA WARUDO OVER HEAVEN)";
                    System.out.println(game_controls);
                    Thread thread_music = new Thread();
                    SoundPlayer soundPlayer = new SoundPlayer();
                    for(int i=0; i<999; i++){
                        soundPlayer.playSound("audio\\Y2Mate.is - JoJo's Bizarre Adventure - Opening 3 4K 60FPS Creditless -7a9fFpNMSpo-48k-1659809909489.wav");
                        try {
                            Thread.sleep(103000); // Adjust the duration as needed
                        } catch (InterruptedException exex) {
                            exex.printStackTrace();
                        }
                    }
;
                } else {
                    JOptionPane optionPane1 = new JOptionPane("Error. Please type 1, 2, 3, or 4.", JOptionPane.ERROR_MESSAGE);
                    JDialog dialog1 = optionPane1.createDialog("Failure");
                    dialog1.setAlwaysOnTop(true);
                    dialog1.setVisible(true);
                }
            } catch (NumberFormatException e) {
                JOptionPane optionPane2 = new JOptionPane("Error. Please type an integer as input.", JOptionPane.ERROR_MESSAGE);
                JDialog dialog2 = optionPane2.createDialog("Failure");
                dialog2.setAlwaysOnTop(true);
                dialog2.setVisible(true);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } while (while_var == false);
    }
}
