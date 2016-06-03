package boozeFighter.gameObjects;

import boozeFighter.constants.Constants;
import boozeFighter.contracts.*;
import boozeFighter.core.GameEngine;
import boozeFighter.gameObjects.Boosters.Booster;
import boozeFighter.gameObjects.Boozes.Booze;
import boozeFighter.gameObjects.Weapons.Weapon;
import boozeFighter.graphics.Assets;

import java.awt.*;
import java.util.*;

public class Player {
    private static final int DEFAULT_STARTING_HEALTH = 50;
    private static final int MAX_HEALTH = 100;
    private static final int MAX_ENERGY = 100;

    private static final int DEFAULT_SHIELD_TIME = 6;
    private static final int SHIELD_ENERGY_COST = 30;

    private static final int DEFAULT_VELOCITY = 6;

    private String name;
    private int x;
    private int y;
    private int velocity;
    private Rectangle boundingBox;

    private int health;
    private int energy;

    private Stack<Booster> foodInventory;
    private Stack<Booze> boozeInventory;
    private Weapon weapon;

    private int walkingImageIndex;
    private int dancingImageIndex;
    private long timeShieldActivated;
    private boolean isPointingRight;

    public boolean goingUp;
    public boolean goingDown;

    public boolean goingLeft;
    public boolean goingRight;
    public boolean isAlive;

    public boolean fightModeOn;
    public boolean shieldModeOn;
    public boolean gameWon;

    public Player(String name) {
        this(name, 200, 300, false);
    }

    public Player(String name, int x, int y, boolean isPointingRight) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.health = DEFAULT_STARTING_HEALTH;
        this.velocity = DEFAULT_VELOCITY;
        this.boundingBox = new Rectangle(Constants.PLAYER_WIDTH, Constants.PLAYER_HEIGHT);
        this.foodInventory = new Stack<>();
        this.boozeInventory = new Stack<>();
        this.isAlive = true;
        this.isPointingRight = isPointingRight;

        this.weapon = new Weapon();

        goingUp = false;
        goingDown = false;
        goingLeft = false;
        goingRight = false;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        if (health > MAX_HEALTH) {
            this.health = MAX_HEALTH;
            return;
        } else if (health <= 0) {
            this.health = 0;
            this.isAlive = false;
            this.y += Constants.PLAYER_HEIGHT / 2;
            return;
        }

        this.health = health;
    }

    public int getEnergy() {
        return this.energy;
    }

    public void setEnergy(int energy) {
        if (energy > MAX_ENERGY) {
            this.energy = MAX_ENERGY;
            return;
        }

        this.energy = energy;
    }

    public Rectangle getBoundingBox() {
        return boundingBox;
    }

    public Stack<Booze> getBoozeInventory() {
        return this.boozeInventory;
    }

    public Stack<Booster> getFoodInventory() {
        return this.foodInventory;
    }

    public void addFood(Booster food) {
        if (this.foodInventory.size() < Constants.INVENTORY_CAPACITY) {
            this.foodInventory.add(food);
        }
    }

    public void addBooze(Booze booze) {
        if (this.boozeInventory.size() < Constants.INVENTORY_CAPACITY) {
            this.boozeInventory.add(booze);
        }
    }

    public void eat() {
        if (this.foodInventory.size() <= 0) {
            return;
        }

        Eatable foodToEat = this.foodInventory.pop();
        this.setHealth(this.getHealth() + foodToEat.getHealthPoints());
    }

    public void drink() {
        if (this.boozeInventory.size() <= 0) {
            return;
        }

        Consumable boozeToDrink = this.boozeInventory.pop();
        this.setEnergy(this.getEnergy() + boozeToDrink.getEnergyPoints());
    }

    //Checks if the firstPlayer intersects with something
    public boolean intersects(Rectangle rectangle) {
        if (this.boundingBox.intersects(rectangle) || rectangle.intersects(this.boundingBox)) {
            return true;
        }

        return false;
    }

    public void fire() {
        if (this.fightModeOn) {
            this.weapon.fire(this.isPointingRight);
        }
    }

    public void activateShield () {
        if (this.energy >= SHIELD_ENERGY_COST) {
            this.shieldModeOn = true;
            this.energy -= SHIELD_ENERGY_COST;
            this.timeShieldActivated = System.currentTimeMillis() / 1000;
        }
    }

    //Update the movement of the firstPlayer
    public void tick() {
        //Update the bounding box's position
        this.boundingBox.setBounds(this.x, this.y, Constants.PLAYER_WIDTH, Constants.PLAYER_HEIGHT);

        // Petyo -added boundaries of the screen for the players
        if (goingUp) {
            this.y -= this.velocity;

            if (this.y <= 55) {
                this.y = 55;
            }
        }

        if (goingDown) {
            this.y += this.velocity;

            if (this.y >= Constants.SCREEN_HEIGHT - Constants.PLAYER_WIDTH) {
                y = Constants.SCREEN_HEIGHT - Constants.PLAYER_WIDTH;
            }
        }

        if (goingLeft) {
            this.x -= this.velocity;
            this.isPointingRight = false;

            if (this.x <= -7) {
                this.x = -7;
            }

            boolean hittingRightWall = this.x < GameEngine.rightWall.getBoundingBox().getX() &&
                    this.x > GameEngine.rightWall.getBoundingBox().getX() - 10 &&
                    this.intersects(GameEngine.rightWall.getBoundingBox());
            boolean hittingLeftWall = this.x < GameEngine.leftWall.getBoundingBox().getX() &&
                    this.x > GameEngine.leftWall.getBoundingBox().getX() - 10 &&
                    this.intersects(GameEngine.leftWall.getBoundingBox());
            if (hittingLeftWall || hittingRightWall) {
                this.x += this.velocity;
            }
        }

        if (goingRight) {
            this.x += this.velocity;
            this.isPointingRight = true;

            if (this.x >= Constants.SCREEN_WIDTH - Constants.PLAYER_WIDTH) {
                x = Constants.SCREEN_WIDTH - Constants.PLAYER_WIDTH;
            }

            boolean hittingRightWall = this.x + Constants.PLAYER_WIDTH - 20 > GameEngine.rightWall.getBoundingBox().getX() &&
                    this.x + Constants.PLAYER_WIDTH - 30 < GameEngine.rightWall.getBoundingBox().getX() &&
                    this.intersects(GameEngine.rightWall.getBoundingBox());
            boolean hittingLeftWall = this.x + Constants.PLAYER_WIDTH - 20 > GameEngine.leftWall.getBoundingBox().getX() &&
                    this.x + Constants.PLAYER_WIDTH - 30 < GameEngine.leftWall.getBoundingBox().getX() &&
                    this.intersects(GameEngine.leftWall.getBoundingBox());
            if (hittingLeftWall || hittingRightWall) {
                this.x -= this.velocity;
            }
        }

        if (this.shieldModeOn && System.currentTimeMillis() / 1000 - this.timeShieldActivated > DEFAULT_SHIELD_TIME) {
            this.shieldModeOn = false;
        }

        boolean isMoving = this.goingDown || this.goingUp || this.goingRight || this.goingLeft;
        this.weapon.tick(this.x, this.y, this.isPointingRight, isMoving);
    }

    public void render(Graphics graphics) {
        boolean isMoving = this.goingDown || this.goingUp || this.goingRight || this.goingLeft;
        if (!this.isAlive) {
            graphics.drawImage(Assets.deadPlayer, this.x, this.y, null);
            return;
        }

        graphics.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        graphics.setColor(Color.black);
        graphics.drawString(this.name, this.x + 30, this.y - 25);

        if (this.gameWon) {
                graphics.drawImage(Assets.winningDance[this.dancingImageIndex], this.x, this.y, null);
            if (System.currentTimeMillis() / 100 - this.timeShieldActivated > 5) {
                this.dancingImageIndex = (this.dancingImageIndex + 1) % 2;
                this.timeShieldActivated = System.currentTimeMillis() / 100;
            }
            return;
        }

        if (isMoving) {
            if (this.isPointingRight) {
                graphics.drawImage(Assets.walkingRightStickman[this.walkingImageIndex], this.x, this.y, null);
                this.walkingImageIndex = (this.walkingImageIndex + 1) % 11;
            } else {
                graphics.drawImage(Assets.walkingLeftStickman[this.walkingImageIndex], this.x, this.y, null);
                this.walkingImageIndex = (this.walkingImageIndex + 1) % 11;
            }
        } else {
            if (!isPointingRight) {
                graphics.drawImage(Assets.playerLeft, this.x, this.y, null);
            } else {
                graphics.drawImage(Assets.playerRight, this.x, this.y, null);
//                graphics.drawImage(Assets.player, this.x, this.y, null);
            }

            this.walkingImageIndex = 0;
        }

        if (this.shieldModeOn) {
            graphics.drawImage(Assets.shield, this.x, this.y, Constants.PLAYER_WIDTH, Constants.PLAYER_HEIGHT, null);
        }

        if (System.currentTimeMillis() / 1000 - this.timeShieldActivated < 3) {
            graphics.setColor(Color.YELLOW);
            graphics.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
            graphics.drawString("Shield activated!", this.x - 20, this.y + Constants.PLAYER_HEIGHT);

        }

        weapon.render(graphics, this.isPointingRight);

        graphics.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        graphics.setColor(Color.red);
        graphics.drawString(((Integer) this.health).toString(), this.x + 35, this.y);

        graphics.setColor(Color.blue);
        graphics.drawString(((Integer) this.energy).toString(), this.x + 75, this.y);
    }
}