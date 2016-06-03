package boozeFighter.gameObjects.Weapons;

import boozeFighter.constants.Constants;
import boozeFighter.contracts.Collidable;
import boozeFighter.contracts.Damagable;
import boozeFighter.contracts.Renderable;
import boozeFighter.contracts.Tickable;
import boozeFighter.core.GameEngine;
import boozeFighter.graphics.Assets;

import java.awt.*;

public class Bullet implements Damagable, Collidable, Tickable, Renderable {
    private static final int DAMAGE = 10;
    private int x;
    private int y;
    private int velocity;

    private boolean firedRight;

    private boolean targetHit;

    private Rectangle boundingBox;

    public Bullet(int x, int y, boolean firedRight) {
        this.x = x;
        this.y = y;
        this.boundingBox = new Rectangle(this.x, this.y, Constants.BULLET_WIDTH, Constants.BULLET_HEIGHT);
        this.velocity = 30;
        this.setFiredRight(firedRight);
    }

    public void setFiredRight(boolean firedRight) {
        this.firedRight = firedRight;
    }

    public boolean isVisible() {
        boolean isVisibleX = this.x >= -20 && this.x <= Constants.SCREEN_WIDTH;

        return isVisibleX && !this.targetHit;
    }

    @Override
    public int getDamage() {
        return DAMAGE;
    }

    @Override
    public Rectangle getBoundingBox() {
        return this.boundingBox;
    }

    @Override
    public void tick() {
        this.boundingBox.setBounds(this.x, this.y, Constants.BULLET_WIDTH, Constants.BULLET_HEIGHT);

        if (this.firedRight) {
            this.x += this.velocity;
            this.handleCollisions();
        } else {
            this.x -= this.velocity;
            this.handleCollisions();
        }
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.bullet, this.x, this.y, Constants.BULLET_WIDTH, Constants.BULLET_HEIGHT, null);
    }

    private void handleCollisions() {
        int firstPlayerX = (int) GameEngine.firstPlayer.getBoundingBox().getX();
        int firstPlayerY = (int) GameEngine.firstPlayer.getBoundingBox().getY();
        int secondPlayerX = (int) GameEngine.secondPlayer.getBoundingBox().getX();
        int secondPlayerY = (int) GameEngine.secondPlayer.getBoundingBox().getY();

        if (this.boundingBox.intersects(firstPlayerX + 60, firstPlayerY, 20, 128)) {
            if (!GameEngine.firstPlayer.shieldModeOn) {
                GameEngine.firstPlayer.setHealth(GameEngine.firstPlayer.getHealth() - DAMAGE);
            }

            this.targetHit = true;
        } else if (this.boundingBox.intersects(secondPlayerX + 60, secondPlayerY, 20, 128)) {
            if (!GameEngine.secondPlayer.shieldModeOn) {
                GameEngine.secondPlayer.setHealth(GameEngine.secondPlayer.getHealth() - DAMAGE);
            }

            this.targetHit = true;
        } else if (this.boundingBox.intersects(GameEngine.rightWall.getBoundingBox())) {
            this.targetHit = true;
        } else if (this.boundingBox.intersects(GameEngine.leftWall.getBoundingBox())) {
            this.targetHit = true;
        }
    }
}
