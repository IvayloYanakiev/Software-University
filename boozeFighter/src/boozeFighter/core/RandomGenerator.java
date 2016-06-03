package boozeFighter.core;

import boozeFighter.constants.Constants;
import boozeFighter.enums.BoosterType;
import boozeFighter.gameObjects.Boosters.Booster;

import java.util.Random;

public class RandomGenerator {
    private static Random random = new Random();

    public static int GetRandomX() {
        int resultX = random.nextInt(Constants.SCREEN_WIDTH - Constants.ITEM_WIDTH * 2);
        while (resultX < Constants.ITEM_WIDTH) {
            resultX = random.nextInt(Constants.SCREEN_WIDTH - Constants.ITEM_WIDTH * 2);
        }

        return resultX;
    }

    public static int GetRandomY() {
        int resultY = random.nextInt(Constants.SCREEN_HEIGHT - Constants.WHISKEY_HEIGHT);
        while (resultY < Constants.WHISKEY_HEIGHT * 2) {
            resultY = random.nextInt(Constants.SCREEN_HEIGHT - Constants.WHISKEY_HEIGHT);
        }

        return resultY;
    }

    public static BoosterType getRandomBoosterType() {
        int randomIndex = random.nextInt(BoosterType.values().length);
        BoosterType result = BoosterType.getTypeByIndex(randomIndex);

        return result;
    }
}
