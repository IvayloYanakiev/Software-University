package boozeFighter.graphics;

import boozeFighter.constants.Constants;

import java.awt.image.BufferedImage;

public class Assets {
    public static BufferedImage background;
    public static BufferedImage menuBackground;

    public static BufferedImage playerLeft;
    public static BufferedImage playerRight;
    public static BufferedImage[] walkingRightStickman = new BufferedImage[11];
    public static BufferedImage[] walkingLeftStickman = new BufferedImage[11];
    public static BufferedImage[] winningDance = new BufferedImage[2];
    public static BufferedImage deadPlayer;
    public static BufferedImage shield;
    public static BufferedImage bullet;

    public static BufferedImage leftPistol;
    public static BufferedImage rightPistol;

    public static BufferedImage steak;
    public static BufferedImage ham;
    public static BufferedImage chicken;
    public static BufferedImage sandwich;

    public static BufferedImage whiskey;
    public static BufferedImage wall;
    public static BufferedImage grid;

    //Loads every resource needed for the core
    public static void init() {
        menuBackground = ImageLoader.loadImage("/textures/menuBackground.jpg");
        background = ImageLoader.loadImage("/textures/grass.jpg");

        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/Stickman.png"));
        playerLeft = sheet.crop(2 * Constants.PLAYER_WIDTH, 10 * Constants.PLAYER_HEIGHT, Constants.PLAYER_WIDTH, Constants.PLAYER_HEIGHT);
        playerRight = sheet.crop(0, 5 * Constants.PLAYER_HEIGHT, Constants.PLAYER_WIDTH, Constants.PLAYER_HEIGHT);
        deadPlayer = ImageLoader.loadImage("/textures/deadPlayer.png");
        shield = ImageLoader.loadImage("/textures/shield.png");

        winningDance[0] = sheet
                .crop(Constants.PLAYER_WIDTH, 9 * Constants.PLAYER_HEIGHT, Constants.PLAYER_WIDTH, Constants.PLAYER_HEIGHT);
        winningDance[1] = sheet
                .crop(Constants.PLAYER_WIDTH, 10 * Constants.PLAYER_HEIGHT, Constants.PLAYER_WIDTH, Constants.PLAYER_HEIGHT);

        for (int i = 0; i < 11; i++) {
            walkingRightStickman[i] = sheet
                    .crop(i * Constants.PLAYER_WIDTH, 1 * Constants.PLAYER_HEIGHT, Constants.PLAYER_WIDTH, Constants.PLAYER_HEIGHT);
            walkingLeftStickman[i] = sheet
                    .crop(i * Constants.PLAYER_WIDTH, 6 * Constants.PLAYER_HEIGHT, Constants.PLAYER_WIDTH, Constants.PLAYER_HEIGHT);

        }

        wall = ImageLoader.loadImage("/textures/wall.png");
        grid = ImageLoader.loadImage("/textures/grid.png");

        leftPistol = ImageLoader.loadImage("/textures/pistol.png");
        rightPistol = ImageLoader.loadImage("/textures/rightPistol.png");
        bullet = ImageLoader.loadImage("/textures/bullet.png");

        steak = ImageLoader.loadImage("/textures/steak.png");
        chicken = ImageLoader.loadImage("/textures/chicken.png");
        sandwich = ImageLoader.loadImage("/textures/sandwich.png");
        ham = ImageLoader.loadImage("/textures/ham.png");

        whiskey = ImageLoader.loadImage("/textures/whiskey.png");
    }
}