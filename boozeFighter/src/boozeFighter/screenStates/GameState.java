package boozeFighter.screenStates;

import boozeFighter.constants.Constants;
import boozeFighter.factories.BoosterFactory;
import boozeFighter.core.GameEngine;
import boozeFighter.factories.BoozeFactory;
import boozeFighter.gameObjects.Boosters.Booster;
import boozeFighter.gameObjects.Boozes.Booze;
import boozeFighter.graphics.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GameState extends State {
    private BufferedImage background;

    private BoosterFactory boosterFactory;
    private List<Booster> availableFood;
    private Set<Integer> foodIndexesToRemove;

    private BoozeFactory boozeFactory;
    private List<Booze> availableBooze;
    private Set<Integer> boozeIndexesToRemove;

    private long gameStartedTime;
    private long timeNow;
    private long timePassedSinceProduced;
    private int itemsProduced;

    private int firstPlayerYFoodOffset;
    private int secondPlayerYFoodOffset;

    public GameState() {
        this.background = Assets.background;

        this.boosterFactory = new BoosterFactory();
        this.availableFood = new ArrayList<>();
        this.foodIndexesToRemove = new HashSet<>();

        this.boozeFactory = new BoozeFactory();
        this.availableBooze = new ArrayList<>();
        this.boozeIndexesToRemove = new HashSet<>();

        this.gameStartedTime = System.currentTimeMillis() / 1000;
    }

    @Override
    public void tick() {
        this.timeNow = System.currentTimeMillis() / 1000;
        boolean fightStarted = this.timeNow - this.gameStartedTime > Constants.SECONDS_UNTIL_FIGHT;

        if (!fightStarted) {
            this.produceItems(Constants.PREFIGHT_ITEMS_TIME);
        } else {
            this.produceItems(Constants.POSTFIGHT_ITEMS_TIME);

            if (!GameEngine.firstPlayer.fightModeOn) {
                GameEngine.firstPlayer.fightModeOn = true;
                GameEngine.secondPlayer.fightModeOn = true;
            }
        }

        // checking if a player is colliding with some food on the screen
        this.handleCollisionsWithItems();
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(this.background, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
        GameEngine.rightWall.render(graphics);
        GameEngine.leftWall.render(graphics);

        this.renderItems(graphics);

        this.renderPlayers(graphics);

        this.renderInventories(graphics);
    }

    // producing new item every 2 seconds
    private void produceItems(int secondsBetweenItems) {
            if (timeNow % secondsBetweenItems == 0 && timeNow != timePassedSinceProduced) {
                if (this.itemsProduced % 3 != 2) {
                    Booster foodToAdd = this.boosterFactory.produce();
                    this.availableFood.add(foodToAdd);
                } else {
                    Booze boozeToAdd = this.boozeFactory.produce();
                    this.availableBooze.add(boozeToAdd);
                }

                this.timePassedSinceProduced = timeNow;
                this.itemsProduced++;
        }
    }

    private void handleCollisionsWithItems() {
        for (Booster currentFood : availableFood) {
            if (GameEngine.firstPlayer.getFoodInventory().size() < Constants.INVENTORY_CAPACITY) {
                if (GameEngine.firstPlayer.intersects(currentFood.getBoundingBox())) {
                    currentFood.setX(Constants.SCREEN_WIDTH - Constants.ITEM_WIDTH);
                    GameEngine.firstPlayer.addFood(currentFood);
                    this.foodIndexesToRemove.add(availableFood.indexOf(currentFood));
                }
            }
        }

        this.removeTakenItems();

        for (Booster currentFood : availableFood) {
            if (GameEngine.secondPlayer.getFoodInventory().size() < Constants.INVENTORY_CAPACITY) {
                if (GameEngine.secondPlayer.intersects(currentFood.getBoundingBox())) {
                    currentFood.setX(0);
                    GameEngine.secondPlayer.addFood(currentFood);
                    this.foodIndexesToRemove.add(availableFood.indexOf(currentFood));
                }
            }
        }

        this.removeTakenItems();

        for (Booze currentBooze : availableBooze) {
            if (GameEngine.firstPlayer.getBoozeInventory().size() < Constants.INVENTORY_CAPACITY) {
                if (GameEngine.firstPlayer.intersects(currentBooze.getBoundingBox())) {
                    GameEngine.firstPlayer.addBooze(currentBooze);
                    this.boozeIndexesToRemove.add(availableBooze.indexOf(currentBooze));
                }
            }
        }

        this.removeTakenItems();

        for (Booze currentBooze : availableBooze) {
            if (GameEngine.secondPlayer.getBoozeInventory().size() < Constants.INVENTORY_CAPACITY) {
                if (GameEngine.secondPlayer.intersects(currentBooze.getBoundingBox())) {
                    GameEngine.secondPlayer.addBooze(currentBooze);
                    this.boozeIndexesToRemove.add(availableBooze.indexOf(currentBooze));
                }
            }
        }

        this.removeTakenItems();
    }

    private void removeTakenItems() {
        for (Integer indexToRemove : foodIndexesToRemove) {
            availableFood.remove((int) indexToRemove);
        }

        for (Integer indexToRemove : boozeIndexesToRemove) {
            availableBooze.remove((int) indexToRemove);
        }

        foodIndexesToRemove.clear();
        boozeIndexesToRemove.clear();
    }

    private void renderItems(Graphics graphics) {
        for (Booster booster : availableFood) {
            booster.render(graphics);
        }

        for (Booze booze : availableBooze) {
            booze.render(graphics);
        }
    }

    private void renderPlayers(Graphics graphics) {
        GameEngine.firstPlayer.render(graphics);
        GameEngine.secondPlayer.render(graphics);

        if (this.timeNow - this.gameStartedTime < Constants.SECONDS_UNTIL_FIGHT) {
            long secondsElapsed = this.timeNow - this.gameStartedTime;
            graphics.setColor(Color.darkGray);
            graphics.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
            graphics.drawString("0:" + Long.toString(Constants.SECONDS_UNTIL_FIGHT - secondsElapsed), Constants.SCREEN_WIDTH / 2 - 50, 40);
        } else if (this.timeNow - this.gameStartedTime < Constants.SECONDS_UNTIL_FIGHT + 5) {
            graphics.setFont(new Font("Comic Sans MS", Font.BOLD, 80));
            graphics.setColor(Color.RED);
            graphics.drawString("FIGHT!!!", Constants.SCREEN_WIDTH / 2 - 150, 100);
        }

        if (!GameEngine.firstPlayer.isAlive || !GameEngine.secondPlayer.isAlive) {
            graphics.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
            graphics.setColor(Color.RED);
            if (GameEngine.firstPlayer.isAlive) {
                graphics.drawString(GameEngine.firstPlayer.getName() + " WINS!", Constants.SCREEN_WIDTH / 2 - 150, Constants.INGAME_MESSAGES_Y);
                GameEngine.firstPlayer.gameWon = true;

            } else if (GameEngine.secondPlayer.isAlive) {
                graphics.drawString(GameEngine.secondPlayer.getName() + " WINS!", Constants.SCREEN_WIDTH / 2 - 200, Constants.INGAME_MESSAGES_Y);
                GameEngine.secondPlayer.gameWon = true;

            } else {
                graphics.drawString("Well... it's a draw :/", Constants.SCREEN_WIDTH / 2 - 300, Constants.INGAME_MESSAGES_Y);
            }
        }

    }

    private void renderInventories(Graphics graphics) {
        graphics.drawImage(Assets.grid, 0, 0, null);
        graphics.drawImage(Assets.grid, Constants.SCREEN_WIDTH - Constants.ITEM_WIDTH - 4, 0, null);

        this.firstPlayerYFoodOffset = 0;
        List<Booster> firstPlayerReversedFood = GameEngine.firstPlayer.getFoodInventory().stream().collect(Collectors.toList());
        for (int currentBooster = firstPlayerReversedFood.size() - 1; currentBooster >= 0; currentBooster--) {
            firstPlayerReversedFood.get(currentBooster).setY(this.firstPlayerYFoodOffset + 4);
            this.firstPlayerYFoodOffset += Constants.ITEM_HEIGHT;
            firstPlayerReversedFood.get(currentBooster).render(graphics);
        }

        this.secondPlayerYFoodOffset = 0;
        List<Booster> secondPlayerReversedFood = GameEngine.secondPlayer.getFoodInventory().stream().collect(Collectors.toList());
        for (int currentBooster = secondPlayerReversedFood.size() - 1; currentBooster >= 0; currentBooster--) {
            secondPlayerReversedFood.get(currentBooster).setY(this.secondPlayerYFoodOffset + 4);

            this.secondPlayerYFoodOffset += Constants.ITEM_HEIGHT;
            secondPlayerReversedFood.get(currentBooster).render(graphics);
        }

        graphics.drawImage(
                Assets.whiskey,
                Constants.SCREEN_WIDTH - Constants.ITEM_WIDTH * 3,
                0,
                Constants.WHISKEY_WIDTH,
                Constants.WHISKEY_HEIGHT,
                null);

        graphics.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
        graphics.setColor(Color.BLUE);
        graphics.drawString(
                "x" + GameEngine.firstPlayer.getBoozeInventory().size(),
                Constants.SCREEN_WIDTH - Constants.ITEM_WIDTH * 2 - 7,
                60);

        graphics.drawImage(
                Assets.whiskey,
                Constants.ITEM_WIDTH + 8,
                0,
                Constants.WHISKEY_WIDTH,
                Constants.WHISKEY_HEIGHT,
                null);

        graphics.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
        graphics.setColor(Color.BLUE);
        graphics.drawString(
                "x" + GameEngine.secondPlayer.getBoozeInventory().size(),
                Constants.ITEM_WIDTH * 2,
                60);
    }
}