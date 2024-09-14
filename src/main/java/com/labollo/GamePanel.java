package com.labollo;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    public static final int SCREEN_HEIGHT = 600;
    public static final int SCREEN_WIDTH = 800;

    public static final int FPS = 60;
    public static final int PLAY_STATE = 0;
    public static final int MENU_STATE = 1;
    public int gameState;

    public KeyHandler keyHandler;
    public UserInterface userInterface;

    public Thread gameThread;


    public GamePanel() {
       super.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
       super.setBackground(Color.BLACK);

       this.keyHandler = new KeyHandler(this);
       this.userInterface = new UserInterface(this);
       this.gameState = MENU_STATE;

       super.addKeyListener(this.keyHandler);
       super.setFocusable(true);

       startGameThread();
        repaint();

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

        userInterface.draw(g);
    }
}
