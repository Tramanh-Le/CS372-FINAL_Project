package code.app.brickbreaker;

import javafx.scene.Parent;
import javafx.scene.image.ImageView;

/**
 * This class represents a 'ball' in the game
 */
public class Ball extends Parent {

    public static final int DEFAULT_SIZE = 2;

    public static final int MAX_SIZE = 5;

    private int size;

    private int diameter;

    private final ImageView imageView;

    /**
     * Default constructor
     */
    public Ball() {
        imageView = new ImageView();

        getChildren().add(imageView);
        changeSize(DEFAULT_SIZE);
        setMouseTransparent(true);
    }

    /**
     * Retrieve the size of the ball
     * 
     * @return
     *         The size of the ball
     */
    public int getSize() {
        return size;
    }

    /**
     * Retrieve the diameter of the ball
     * 
     * @return
     *         The diameter of the ball
     */
    public int getDiameter() {
        return diameter;
    }

    /**
     * Change the size of the ball
     * 
     * @param newSize
     *            The new size of the ball
     */
    public void changeSize(int newSize) {
        size = newSize;

        imageView.setImage(Config.getImages().get(Config.IMAGE_BALL_0 + size));
        diameter = (int) imageView.getImage().getWidth() - Config.SHADOW_WIDTH;
    }
}