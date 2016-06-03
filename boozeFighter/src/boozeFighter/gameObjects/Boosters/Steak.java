package boozeFighter.gameObjects.Boosters;

import boozeFighter.constants.Constants;
import boozeFighter.graphics.Assets;

import java.awt.*;

public class Steak extends Booster {
    private static final int DEFAULT_HEALTH_POINTS = 15;

    public Steak(int x, int y) {
        super(DEFAULT_HEALTH_POINTS, x, y);
        this.setBoundingBox(new Rectangle(x, y, Constants.ITEM_WIDTH, Constants.ITEM_HEIGHT));
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.steak, this.getX(), this.getY(), Constants.ITEM_WIDTH, Constants.ITEM_HEIGHT, null);
    }
}
