package com.DataFlair.FileOpening;

import javax.swing.*;

//GOGOANIME HELPER//
public class Main {

    public static int application;
    static boolean while_var = false;
    public static void main(String[] args)
            throws Exception {
       do {
           try {

               JOptionPane.showMessageDialog(null, "type 1 to watch anime, 2 to access MyAnimeList and 3 to play AMQ ");
               int application = Integer.parseInt(JOptionPane.showInputDialog("I wanna type:"));
               if (application == 1) {
                   AnimeWatch app1 = new AnimeWatch();//instance the class
                   while_var = true;

               } else if (application == 2) {
                   MAL app2 = new MAL();
                   while_var = true;
               } else if (application == 3) {
                   AMQ app3 = new AMQ();
                   while_var = true;
               }
               else if (application == 4 ){

               }
               else {
                   JOptionPane optionPane1 = new JOptionPane("Error.Please type 1,2 or 3", JOptionPane.ERROR_MESSAGE);
                   JDialog dialog1 = optionPane1.createDialog("Failure");
                   dialog1.setAlwaysOnTop(true);
                   dialog1.setVisible(true);
               }

           } catch (Exception S) {
               JOptionPane optionPane2 = new JOptionPane("Error.Please type an integer as input", JOptionPane.ERROR_MESSAGE);
               JDialog dialog2 = optionPane2.createDialog("Failure");
               dialog2.setAlwaysOnTop(true);
               dialog2.setVisible(true);

           }
       }  while(while_var == false);



    }
}