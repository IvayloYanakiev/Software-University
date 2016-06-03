package boozeFighter.factories;

import boozeFighter.core.RandomGenerator;
import boozeFighter.enums.BoosterType;
import boozeFighter.gameObjects.Boosters.*;

import java.awt.dnd.InvalidDnDOperationException;

public class BoosterFactory {

    public Booster produce() {
        int x = RandomGenerator.GetRandomX();
        int y = RandomGenerator.GetRandomY();

        BoosterType randomBoosterType = RandomGenerator.getRandomBoosterType();

        Booster result;
        switch (randomBoosterType) {
            case Chicken:
                result = new Chicken(x, y);
                break;
            case Ham:
                result = new Ham(x, y);
                break;
            case Sandwich:
                result = new Sandwich(x, y);
                break;
            case Steak:
                result = new Steak(x, y);
                break;
            default:
                throw new InvalidDnDOperationException("BoosterType not supported.");
        }

        return result;
    }
}