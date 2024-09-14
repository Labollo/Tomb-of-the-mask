package com.labollo;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    private GamePanel gp;

    public boolean upPressed = false, downPressed = false, rightPressed = false, leftPressed = false;

    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_UP -> {
                this.gp.userInterface.commandNum = (this.gp.userInterface.commandNum - 1 + 2) % 2;
            }
            case KeyEvent.VK_DOWN -> {


                this.gp.userInterface.commandNum = (this.gp.userInterface.commandNum + 1) % 2;
            }
            case KeyEvent.VK_ENTER -> {
                switch (this.gp.userInterface.commandNum) {
                    case 0 -> {
                        this.gp.gameState = GamePanel.PLAY_STATE;

                    }
                    case 1-> {
                        System.exit(0);
                    }

                }
            }
        }
    }
}
