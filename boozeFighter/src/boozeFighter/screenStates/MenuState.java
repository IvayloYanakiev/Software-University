package boozeFighter.screenStates;

import boozeFighter.constants.Constants;
import boozeFighter.graphics.Assets;

import javax.swing.*;
import java.awt.*;

public class MenuState extends State{

    public MenuState() {
        JTextField field = new JTextField(10);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.background, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
        graphics.setFont(new Font("Comic Sans MS", Font.BOLD, 60));
        graphics.setColor(Color.ORANGE);
        graphics.drawString("press Enter to start", Constants.SCREEN_WIDTH / 2 - 300, Constants.SCREEN_HEIGHT / 2);
    }
}
