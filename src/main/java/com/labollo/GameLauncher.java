package com.labollo;

import javax.swing.*;

public class GameLauncher {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Tomb of the mask"); // Window title
        frame.setSize(GamePanel.SCREEN_WIDTH, GamePanel.SCREEN_HEIGHT); // Window size
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Default close operation
        frame.setLocationRelativeTo(null); // Center window

        GamePanel panel = new GamePanel();
        frame.add(panel); // Add a GamePanel object to the window
        frame.pack(); // Adjust the window dimensions

        frame.setVisible(true); // Set the window to visible
    }
}