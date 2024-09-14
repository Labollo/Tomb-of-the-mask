package com.labollo;

import javax.swing.*;

public class Main {


    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("gameeee");
        frame.setSize(GamePanel.SCREEN_WIDTH, GamePanel.SCREEN_HEIGHT);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        GamePanel panel = new GamePanel();   //aggiunge pannello
        frame.add(panel);
        frame.pack();

        frame.setVisible(true);
    }
}