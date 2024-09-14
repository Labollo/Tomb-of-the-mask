package com.labollo;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    // Window constants
    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 600;

    // Game state
    public static final int MENU_STATE = 0;
    public static final int PLAY_STATE = 1;
    public int gameState;

    // Game thread
    public Thread gameThread;

    // FPS
    public static final int FPS = 60;

    // Other components
    public KeyHandler keyHandler;
    public UserInterface userInterface;

    public GamePanel() {
       this.keyHandler = new KeyHandler(this);
       this.userInterface = new UserInterface(this);

       super.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT)); // Set size
       super.setBackground(Color.BLACK); // Set background color
       super.addKeyListener(this.keyHandler); // Add key listener
       super.setFocusable(true); // Set focusable state

       // Set some game properties
       this.setup();

       // Start the game loop
       this.startGameThread();
    }

    private void setup() {
        this.gameState = MENU_STATE;
    }

    private void startGameThread() {
        this.gameThread = new Thread(this);
        this.gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = (double) 1000000000 / FPS;
        double delta = 0;
        long lastUpdateTime = System.nanoTime();
        long currentTime;

        while (this.gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastUpdateTime) / drawInterval;
            lastUpdateTime = currentTime;
            while (delta >= 1) {
                repaint();
                delta--;
            }

        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.userInterface.draw(g);

        g.dispose();
    }
}
