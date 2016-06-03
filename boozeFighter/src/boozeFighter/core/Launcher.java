package boozeFighter.core;

import boozeFighter.constants.Constants;

public class Launcher {

    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine("BoozerFighters", Constants.SCREEN_WIDTH,Constants.SCREEN_HEIGHT);
        gameEngine.start();
    }
}
