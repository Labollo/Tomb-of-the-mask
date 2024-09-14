package com.labollo;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class KeyHandler implements KeyListener {
    private final GamePanel gp;

    public boolean upPressed = false, downPressed = false, rightPressed = false, leftPressed = false;

    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }


    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (this.gp.gameState == GamePanel.MENU_STATE)
            menuState(key);
        else if (this.gp.gameState == GamePanel.PLAY_STATE)
            playState(key);
    }

    private void menuState(int key) {
        if (key == KeyEvent.VK_UP)
            this.gp.userInterface.commandNum = (this.gp.userInterface.commandNum - 1 + 2) % 2;
        else if (key == KeyEvent.VK_DOWN)
            this.gp.userInterface.commandNum = (this.gp.userInterface.commandNum + 1) % 2;
        else if (key == KeyEvent.VK_ENTER) {
            if (this.gp.userInterface.commandNum == 0)
                this.gp.gameState = GamePanel.PLAY_STATE;
            else if (this.gp.userInterface.commandNum == 1)
                System.exit(0);
        }
    }

    private void playState(int key) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
