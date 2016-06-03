package boozeFighter.gameObjects;

import boozeFighter.constants.Constants;
import boozeFighter.contracts.Collidable;
import boozeFighter.contracts.Renderable;
import boozeFighter.graphics.Assets;

import java.awt.*;

public class Wall implements Renderable, Collidable {
    private int x;
    private int y;
    private Rectangle boundingBox;

    public Wall(int x, int y) {
        this.x = x;
        this.y = y;
        this.boundingBox = new Rectangle(this.x, this.y, 20, 80);
    }

    @Override
    public Rectangle getBoundingBox() {
        return boundingBox;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.wall, this.x, this.y, Constants.WALL_WIDTH, Constants.WALL_HEIGHT, null);
    }
}
