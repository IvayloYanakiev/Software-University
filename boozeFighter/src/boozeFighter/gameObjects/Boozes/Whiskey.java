package boozeFighter.gameObjects.Boozes;

import boozeFighter.constants.Constants;
import boozeFighter.graphics.Assets;

import java.awt.*;

public class Whiskey extends Booze {
    private static final int DEFAULT_ENERGY_POINTS = 33;

    public Whiskey(int x, int y) {
        super(DEFAULT_ENERGY_POINTS, x, y);
        this.setBoundingBox(new Rectangle(x, y, Constants.ITEM_WIDTH, Constants.ITEM_HEIGHT));
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.whiskey, this.getX(), this.getY(), Constants.WHISKEY_WIDTH, Constants.WHISKEY_HEIGHT, null);
    }
}
