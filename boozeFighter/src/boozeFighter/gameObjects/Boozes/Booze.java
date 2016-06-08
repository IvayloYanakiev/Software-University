package boozeFighter.gameObjects.Boozes;

import boozeFighter.contracts.Collidable;
import boozeFighter.contracts.Consumable;
import boozeFighter.contracts.Renderable;
import boozeFighter.contracts.Tickable;

import java.awt.*;

public abstract class Booze implements Consumable, Tickable, Renderable, Collidable {
    private int energyPoints;
    private int x;
    private int y;
    private Rectangle boundingBox;


    protected Booze(int energyPoints, int x, int y) {
        this.energyPoints = energyPoints;
        this.x = x;
        this.y = y;
    }

    @Override
    public int getEnergyPoints() {
        return energyPoints;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public Rectangle getBoundingBox() {
        return boundingBox;
    }

    public void setBoundingBox(Rectangle boundingBox) {
        this.boundingBox = boundingBox;
    }
}