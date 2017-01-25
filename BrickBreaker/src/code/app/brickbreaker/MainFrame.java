
package code.app.brickbreaker;

import javafx.scene.Group;

/**
 * This is the main 'frame' that displays the application user interface
 * 
 * Takes the states and Splash class to display the side bar during game play.
 */
public class MainFrame {

    // Instance of scene root node
    private final Group root;

    // Instance of splash (if exists)
    private Splash splash;

    // Instance of level (if exists)
    private Level level;

    // Number of lives
    private int lifeCount;

    // Current score
    private int score;

    // Current state of the game. The next values are available
    // 0 - Splash
    public static final int SPLASH = 0;

    // 1..Level.LEVEL_COUNT - Level
    private int state = SPLASH;

    /**
     * Non-default constructor
     * 
     * @param root
     *            The root group
     */
    public MainFrame(Group root) {
        this.root = root;
    }

    /**
     * Retrieve the game state
     * 
     * @return
     *         The game state
     */
    public int getState() {
        return state;
    }

    /**
     * Retrieve the game score
     * 
     * @return
     *         The game score
     */
    public int getScore() {
        return score;
    }

    /**
     * Set the game score
     * 
     * @param score
     *            The game score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Retrieve the life count
     * 
     * @return
     *         The life count
     */
    public int getLifeCount() {
        return lifeCount;
    }

    /**
     * Increase the life count
     */
    public void increaseLives() {
        lifeCount = Math.min(lifeCount + 1, Config.MAX_LIVES);
    }

    /**
     * Decrease the life count
     */
    public void decreaseLives() {
        lifeCount--;
    }

    /**
     * Initializes game (lives, scores etc)
     */
    public void startGame() {
        lifeCount = 3;
        score = 0;
        changeState(1);
    }

    /**
     * Change the game state
     * 
     * @param newState
     *            The new game state
     */
    public void changeState(int newState) {
        state = newState;

        if (splash != null) {
            splash.stop();
        }

        if (level != null) {
            level.stop();
        }

        if ((state < 1) || (state > LevelData.getLevelsCount())) {
            root.getChildren().remove(level);
            level = null;
            splash = new Splash();
            root.getChildren().add(splash);
            splash.start();
        } else {
            root.getChildren().remove(splash);
            splash = null;
            level = new Level(state);
            root.getChildren().add(level);
            level.start();
        }
    }
}