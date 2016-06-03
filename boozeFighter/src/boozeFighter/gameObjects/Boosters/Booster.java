package boozeFighter.gameObjects.Boosters;

import boozeFighter.contracts.Collidable;
import boozeFighter.contracts.Eatable;
import boozeFighter.contracts.Renderable;
import boozeFighter.contracts.Tickable;

import java.awt.*;

public abstract class Booster implements Eatable, Renderable, Collidable {
    private int healthPoints;
    private int x;
    private int y;

    private Rectangle boundingBox;

    protected Booster(int healthPoints, int x, int y) {
        this.healthPoints = healthPoints;
        this.x = x;
        this.y = y;
    }

    @Override
    public int getHealthPoints() {
        return healthPoints;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public Rectangle getBoundingBox() {
        return boundingBox;
    }

    public void setBoundingBox(Rectangle boundingBox) {
        this.boundingBox = boundingBox;
    }
}