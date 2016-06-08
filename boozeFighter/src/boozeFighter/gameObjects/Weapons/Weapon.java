package boozeFighter.gameObjects.Weapons;

import boozeFighter.graphics.Assets;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Weapon {
    int x;
    int y;

    private boolean bulletFired;
    private int firedBulletsCount;
    private long timeNow;
    private long startedReloadingTime;

    private List<Bullet> clip;
    private List<Integer> indexesOfBulletsToRemove;

    public Weapon() {
        this.clip = new ArrayList<>();
        this.indexesOfBulletsToRemove = new ArrayList<>();
    }

    public void fire(boolean fireRight) {
        if (!this.isReloading()) {
            this.bulletFired = true;
            if (fireRight) {
                this.clip.add(new Bullet(this.x + 77, this.y, fireRight));
            } else {
                this.clip.add(new Bullet(this.x - 5, this.y, fireRight));

            }

            this.firedBulletsCount++;
        }
    }

    public void tick(int x, int y, boolean isPointingRight, boolean isMoving) {
        this.timeNow = System.currentTimeMillis() / 1000;

        if (isMoving && isPointingRight) {
            this.x = x + 8;
            this.y = y + 48;
        }
        else if (isMoving) {
            this.x = x + 15;
            this.y = y + 48;
        }
        else if (isPointingRight) {
            this.x = x + 24;
            this.y = y + 38;
        } else {
            this.x = x + 3;
            this.y = y + 41;
        }

        for (Bullet bullet : this.clip) {
            bullet.tick();
        }

        for (Bullet bullet : clip) {
            if (!bullet.isVisible()) {
                this.indexesOfBulletsToRemove.add(clip.indexOf(bullet));
            }
        }

        for (Integer indexOfBulletToRemove : this.indexesOfBulletsToRemove) {
            this.clip.remove((int)indexOfBulletToRemove);
        }

        this.indexesOfBulletsToRemove.clear();
    }

    public void render(Graphics graphics, boolean pointingRight) {
        if (pointingRight) {
            graphics.drawImage(Assets.rightPistol, this.x + 68, this.y, null);
        } else {
            graphics.drawImage(Assets.leftPistol, this.x, this.y, null);
        }

        if (this.isReloading()) {
            graphics.setColor(Color.YELLOW);
            graphics.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
            graphics.drawString("Reloading...", this.x, this.y + 40);
        }

        this.clip.forEach(b -> b.render(graphics));
    }

    private boolean isReloading() {
        if (this.firedBulletsCount == 5) {
            this.startedReloadingTime = this.timeNow;
            this.firedBulletsCount = 0;
        }

        if (startedReloadingTime != 0 && this.timeNow - this.startedReloadingTime < 5) {
            return true;
        }

        return false;
    }
}