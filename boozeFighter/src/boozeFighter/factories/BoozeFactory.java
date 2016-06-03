package boozeFighter.factories;

import boozeFighter.core.RandomGenerator;
import boozeFighter.gameObjects.Boozes.Booze;
import boozeFighter.gameObjects.Boozes.Whiskey;

public class BoozeFactory {
    public Booze produce() {
        int x = RandomGenerator.GetRandomX();
        int y = RandomGenerator.GetRandomY();
        Booze result = new Whiskey(x, y);

        return result;
    }
}