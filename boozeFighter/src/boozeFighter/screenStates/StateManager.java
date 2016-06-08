package boozeFighter.screenStates;

import boozeFighter.enums.GameStateType;

public class StateManager {
    //It will hold what state we currently want to tick() and render()
    private static State gameState;
    private static State menuState = new MenuState();
    private static State settingsState = new SettingsState();

    private static State currentState = null;

    //Changes the current state of the core
    public static void setState(GameStateType stateType) {
        switch (stateType) {
            case MENU:
                currentState = menuState;
                break;
            case GAME:
                if (gameState == null) {
                    gameState = new GameState();
                    currentState = gameState;
                } else {
                    currentState = gameState;
                }
                break;
        }
    }

    //Gets the current state of the core
    public static State getState() {
        return currentState;
    }
}
