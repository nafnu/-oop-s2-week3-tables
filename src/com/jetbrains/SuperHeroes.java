package com.jetbrains;

import javax.swing.*;
import java.awt.*;

public class SuperHeroes extends JPanel { //Change Main with edit configurations

    private static boolean DEBUG = true;

    public static void main(String[] args) {
        // write your code here
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public SuperHeroes() {
        super(new GridLayout(1, 0)); //Call the constructor frame (first layer)

        String[] columnNames = {"Real Name", "Super Hero Name", "Speed", "Power", "Tier"}; //Column names

        Object[][] data = {
                {"Tamaran's Princess Koriand'r", "Starfire", 55, 70, 4},
                {"Bruce Banner", "Hulk", 85, 100, 6},
                {"Emil Blonsky", "Abomination", 100, 80, 6},
                {"Wanda Maximoff", "Scarlet Witch", 100, 100, 7},
                {"Wade Wilson", "Deadpool", 50, 55, 3}
        };

        final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 100));
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }


    private static void createAndShowGUI(){
        if (DEBUG){
            System.out.println("yes, so do I.. <3 I Love Super Heroes "); //Console debug
        }

        JFrame frame = new JFrame("Super Heroes"); //Name of the table
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        SuperHeroes newContentPane = new SuperHeroes();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);

        frame.pack();
        frame.setVisible(true);

    }
}
