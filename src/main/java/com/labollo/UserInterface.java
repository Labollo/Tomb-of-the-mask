package com.labollo;

import java.awt.*;

public class UserInterface {
    private GamePanel gp;

    public  int commandNum = 0;

    public UserInterface(GamePanel gp) {
        this.gp = gp;
    }

    public void draw(Graphics g) {
        if (gp.gameState == GamePanel.MENU_STATE) {
            drawMenu(g);
        }
        if (gp.gameState == GamePanel.PLAY_STATE) {
            drawPlay(g);
        }
    }

    private void drawMenu(Graphics g) {
        String title = " Tomb-Of-The-Mask";
        String buttonPlay = "Play";
        String quit = "Quit";
        Color darkGreen = new Color(0,100,0);

        // Title
        g.setFont(new Font("Agency FB", Font.BOLD, 60));
        g.setColor(darkGreen);
        g.drawString(title, GamePanel.SCREEN_WIDTH / 2 - g.getFontMetrics().stringWidth(title) / 2 + 6, 160 + 6);
        g.setColor(Color.GREEN);
        g.drawString(title, GamePanel.SCREEN_WIDTH / 2 - g.getFontMetrics().stringWidth(title) / 2, 160);
        //------------------------------
        // Play button
        g.setFont(new Font("Agency FB", Font.BOLD, 55));
        g.setColor(darkGreen);
        g.drawString(buttonPlay, GamePanel.SCREEN_WIDTH / 2 - g.getFontMetrics().stringWidth(buttonPlay) / 2 + 4,350 + 5);
        g.setColor(Color.GREEN);
        g.drawString(buttonPlay, GamePanel.SCREEN_WIDTH / 2 - g.getFontMetrics().stringWidth(buttonPlay) / 2,350);
        //------------------------------
        // Quit button
        g.setColor(darkGreen);
        g.drawString(quit, GamePanel.SCREEN_WIDTH / 2 - g.getFontMetrics().stringWidth(quit) / 2 + 4,420 + 5);
        g.setColor(Color.GREEN);
        g.drawString(quit, GamePanel.SCREEN_WIDTH / 2 - g.getFontMetrics().stringWidth(quit) / 2,420);
        //------------------------------
        // Quit button
        g.setColor(darkGreen);
        if (commandNum == 0) {
            //if 0 play
            g.setColor(darkGreen);
            g.drawString(">", GamePanel.SCREEN_WIDTH / 2 - g.getFontMetrics().stringWidth(">") / 2 - 70,350);
            g.setColor(Color.GREEN);
            g.drawString(">", GamePanel.SCREEN_WIDTH / 2 - g.getFontMetrics().stringWidth(">") / 2 + 4 - 70,350 + 5);
        }else if (commandNum == 1) {
            //if 1 quit
            g.setColor(darkGreen);
            g.drawString(">", GamePanel.SCREEN_WIDTH / 2 - g.getFontMetrics().stringWidth(">") / 2 - 70,420);
            g.setColor(Color.GREEN);
            g.drawString(">", GamePanel.SCREEN_WIDTH / 2 - g.getFontMetrics().stringWidth(">") / 2 + 4 - 70,420 + 5);
        }
        System.out.println(commandNum);
        //------------------------------
    }

    private void drawPlay(Graphics g) {

    }
}
