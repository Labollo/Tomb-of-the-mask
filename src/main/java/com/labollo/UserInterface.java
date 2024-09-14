package com.labollo;

import java.awt.*;

public class UserInterface {
    private GamePanel gp;
    private Graphics2D g2;

    public int commandNum = 0;

    public UserInterface(GamePanel gp) {
        this.gp = gp;
    }

    public void draw(Graphics g) {
        this.g2 = (Graphics2D) g;

        if (gp.gameState == GamePanel.MENU_STATE) {
            drawMenu(g);
        }
        if (gp.gameState == GamePanel.PLAY_STATE) {
            drawPlay(g);
        }
    }

    private void drawMenu(Graphics g) {
        String message;
        int x, y;
        Color darkGreen = new Color(0,100,0);
        g.setFont(new Font("Agency FB", Font.BOLD, 96));

        // Title
        message = "Tomb of the mask";
        x = getXForCenteredText(message);
        y = 120;

        g.setColor(darkGreen);
        g.drawString(message, x + 6, y + 6);

        g.setColor(Color.GREEN);
        g.drawString(message, x, y);
        //------------------------------
        g.setFont(new Font("Agency FB", Font.BOLD, 55));
        // Play button
        message = "Play";
        x = getXForCenteredText(message);
        y += 200;
        g.setColor(darkGreen);
        g.drawString(message, x + 4,y + 5);

        g.setColor(Color.GREEN);
        g.drawString(message, x,y);
        if (commandNum == 0) { // Play
            g.setColor(darkGreen);
            g.drawString(">", x - 70 + 3,y + 3);
            g.setColor(Color.GREEN);
            g.drawString(">", x - 70,y);
        }
        //------------------------------
        // Quit button
        message = "Quit";
        x = getXForCenteredText(message);
        y += 70;
        g.setColor(darkGreen);
        g.drawString(message, x + 4,y + 5);
        g.setColor(Color.GREEN);
        g.drawString(message, x,y);
        if (commandNum == 1) { // Quit
            g.setColor(darkGreen);
            g.drawString(">", x - 70 + 3 ,y + 3);
            g.setColor(Color.GREEN);
            g.drawString(">", x - 70, y);
        }
    }

    private void drawPlay(Graphics g) {

    }

    public int getXForCenteredText(String text) {
        FontMetrics metrics = this.g2.getFontMetrics();
        int length = metrics.stringWidth(text);
        return GamePanel.SCREEN_WIDTH / 2 - length / 2;
    }
}
