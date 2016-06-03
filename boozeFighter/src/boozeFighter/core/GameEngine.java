package boozeFighter.core;

import boozeFighter.constants.Constants;
import boozeFighter.contracts.Tickable;
import boozeFighter.display.*;
import boozeFighter.enums.GameStateType;
import boozeFighter.gameObjects.Player;
import boozeFighter.gameObjects.Wall;
import boozeFighter.screenStates.*;
import boozeFighter.graphics.Assets;
import boozeFighter.graphics.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class GameEngine implements Runnable, Tickable {
    private Display display;
    private int width, height;
    private String title;

    private boolean running = false;
    private Thread thread;

    private InputHandler inputHandler;
    private BufferStrategy bufferStrategy;
    private Graphics graphics;

    public static Player firstPlayer;
    public static Player secondPlayer;

    public static Wall rightWall;
    public static Wall leftWall;

    public GameEngine(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    //Iliyan: I don't understand how this method is invoked when it has no refferences in the project.
    //Implementing the interface's method
    @Override
    public void run() {
        init();

        //Sets the frames per seconds
        int fps = 30;
        //1 000 000 000 nanoseconds in a second. Thus we measure time in nanoseconds
        //to be more specific. Maximum allowed time to run the tick() and render() methods
        double timePerTick = 1_000_000_000.0 / fps;
        //How much time we have until we need to call our tick() and render() methods
        double delta = 0;
        //The current time in nanoseconds
        long now;
        //Returns the amount of time in nanoseconds that our computer runs.
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (running) {
            //Sets the now variable to the current time in nanoseconds
            now = System.nanoTime();
            //Amount of time passed divided by the max amount of time allowed.
            delta += (now - lastTime) / timePerTick;
            //Adding to the timer the time passed
            timer += now - lastTime;
            //Setting the lastTime with the values of now time after we have calculated the delta
            lastTime = now;

            //If enough time has passed we need to tick() and render() to achieve 60 fps
            if (delta >= 1) {
                tick();
                render();
                //Reset the delta
                ticks++;
                delta--;
            }

            if (timer >= 1_000_000_000) {
                ticks = 0;
                timer = 0;
            }
        }

        //Calls the stop method to ensure everything has been stopped
        stop();
    }

    //Initializes all the graphics and it will get
    //everything ready for our core
    private void init() {
        //Initializing a new display.Display object
        display = new Display(this.title, this.width, this.height);

        this.inputHandler = new InputHandler(this.display);
        Assets.init();

        //Setting the currentState to gameState because we do not have
        //any more states set up
        StateManager.setState(GameStateType.MENU);

        firstPlayer = new Player("Jorji", Constants.SCREEN_WIDTH - Constants.SCREEN_WIDTH / 4, Constants.SCREEN_HEIGHT / 2 - 64, false);
        secondPlayer = new Player("Goshko", Constants.SCREEN_WIDTH / 4, Constants.SCREEN_HEIGHT / 2 - 64, true);

        rightWall = new Wall(Constants.RIGHT_WALL_X, Constants.RIGHT_WALL_Y);
        leftWall = new Wall(Constants.LEFT_WALL_X, Constants.LEFT_WALL_Y);
    }

    //The method that will update all the variables
    @Override
    public void tick() {
        //Checks if a State exists and tick()
        if (StateManager.getState() != null) {
            StateManager.getState().tick();
        }

        firstPlayer.tick();
        secondPlayer.tick();
    }

    //The method that will draw everything on the canvas
    public void render() {
        //Setting the bufferStrategy to be the one used in our canvas
        //Gets the number of buffers that the canvas should use.
        this.bufferStrategy = display.getCanvas().getBufferStrategy();

        //If our bufferStrategy doesn't know how many buffers to use
        //we create some manually
        if (bufferStrategy == null) {
            //Create 2 buffers
            display.getCanvas().createBufferStrategy(2);
            //returns out of the method to prevent errors
            return;
        }

        //Instantiates the graphics related to the bufferStrategy
        graphics = bufferStrategy.getDrawGraphics();

        //Clear the screen at every frame
        graphics.clearRect(0, 0, this.width, this.height);

        //Checks if a State exists and render()
        if (StateManager.getState() != null) {
            StateManager.getState().render(this.graphics);
        }
        //End of drawing objects

        //Enables the buffer
        bufferStrategy.show();

        //Shows everything stored in the Graphics object
        graphics.dispose();
    }

    //Creating a start method for the Thread to start our core
    //Synchronized is used because our method is working with threads
    //so we ensure ourselves that nothing will go bad
    public synchronized void start() {
        //If the core is running exit the method
        //This is done in order to prevent the core to initialize
        //more than enough threads
        if (running) {
            return;
        }
        //Setting the while-core-loop to run
        running = true;
        //Initialize the thread that will work with "this" class (core.Game)
        thread = new Thread(this);
        //The start method will call start the new thread and it will call
        //the run method in our class
        thread.start();
    }

    //Creating a stop method for the Thread to stop our core
    public synchronized void stop() {
        //If the core is not running exit the method
        //This is done to prevent the core from stopping a
        //non-existing thread and cause errors
        if (!running) {
            return;
        }

        running = false;

        //The join method stops the current method from executing and it
        //must be surrounded in try-catch in order to work
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}