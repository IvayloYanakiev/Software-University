package boozeFighter.core;

import boozeFighter.display.Display;
import boozeFighter.enums.GameStateType;
import boozeFighter.screenStates.StateManager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {

    public InputHandler(Display display) {
        display.getCanvas().addKeyListener(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (GameEngine.firstPlayer.isAlive && GameEngine.secondPlayer.isAlive) {
            if (keyCode == KeyEvent.VK_UP) {
                GameEngine.firstPlayer.goingUp = true;
            }
            if (keyCode == KeyEvent.VK_DOWN) {
                GameEngine.firstPlayer.goingDown = true;
            }
            if (keyCode == KeyEvent.VK_LEFT) {
                GameEngine.firstPlayer.goingLeft = true;
            }
            if (keyCode == KeyEvent.VK_RIGHT) {
                GameEngine.firstPlayer.goingRight = true;
            }
            if (keyCode == KeyEvent.VK_NUMPAD1) {
                GameEngine.firstPlayer.eat();
            }
            if (keyCode == KeyEvent.VK_NUMPAD2) {
                GameEngine.firstPlayer.drink();
            }
            if (keyCode == KeyEvent.VK_NUMPAD0) {
                GameEngine.firstPlayer.fire();
            }
            if (keyCode == KeyEvent.VK_NUMPAD3) {
                GameEngine.firstPlayer.activateShield();
            }


            if (keyCode == KeyEvent.VK_W) {
                GameEngine.secondPlayer.goingUp = true;
            }
            if (keyCode == KeyEvent.VK_S) {
                GameEngine.secondPlayer.goingDown = true;
            }
            if (keyCode == KeyEvent.VK_A) {
                GameEngine.secondPlayer.goingLeft = true;
            }
            if (keyCode == KeyEvent.VK_D) {
                GameEngine.secondPlayer.goingRight = true;
            }
            if (keyCode == KeyEvent.VK_1) {
                GameEngine.secondPlayer.eat();
            }
            if (keyCode == KeyEvent.VK_2) {
                GameEngine.secondPlayer.drink();
            }
            if (keyCode == KeyEvent.VK_CONTROL) {
                GameEngine.secondPlayer.fire();
            }
            if (keyCode == KeyEvent.VK_3) {
                GameEngine.secondPlayer.activateShield();
            }
        }

        if (keyCode == KeyEvent.VK_ENTER) {
            StateManager.setState(GameStateType.GAME);
        }

        if (keyCode == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_UP) {
            GameEngine.firstPlayer.goingUp = false;
        }
        if (keyCode == KeyEvent.VK_DOWN) {
            GameEngine.firstPlayer.goingDown = false;
        }
        if (keyCode == KeyEvent.VK_LEFT) {
            GameEngine.firstPlayer.goingLeft = false;
        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            GameEngine.firstPlayer.goingRight = false;
        }

        if (keyCode == KeyEvent.VK_W) {
            GameEngine.secondPlayer.goingUp = false;
        }
        if (keyCode == KeyEvent.VK_S) {
            GameEngine.secondPlayer.goingDown = false;
        }
        if (keyCode == KeyEvent.VK_A) {
            GameEngine.secondPlayer.goingLeft = false;
        }
        if (keyCode == KeyEvent.VK_D) {
            GameEngine.secondPlayer.goingRight = false;
        }

    }
}