package boozeFighter.gameObjects.Boosters;

import boozeFighter.constants.Constants;
import boozeFighter.graphics.Assets;

import java.awt.*;

public class Sandwich extends Booster {
    private static final int DEFAULT_HEALTH_POINTS = 9;

    public Sandwich(int x, int y) {
        super(DEFAULT_HEALTH_POINTS, x, y);
        this.setBoundingBox(new Rectangle(x, y, Constants.ITEM_WIDTH, Constants.ITEM_HEIGHT));
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.sandwich, this.getX(), this.getY(), Constants.ITEM_WIDTH, Constants.ITEM_HEIGHT, null);
    }
}
