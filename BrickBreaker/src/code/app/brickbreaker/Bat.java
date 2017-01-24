package code.app.brickbreaker;

import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This class represents a 'bat' in the game
 */
public class Bat extends Parent {

    public static final int DEFAULT_SIZE = 2;

    public static final int MAX_SIZE = 7;

    private static final Image LEFT = Config.getImages().get(Config.IMAGE_BAT_LEFT);

    private static final Image CENTER = Config.getImages().get(Config.IMAGE_BAT_CENTER);

    private static final Image RIGHT = Config.getImages().get(Config.IMAGE_BAT_RIGHT);

    private int size;

    private int width;

    private final int height;

    private final ImageView leftImageView;

    private final ImageView centerImageView;

    private final ImageView rightImageView;

    /**
     * Default constructor
     */
    public Bat() {
        height = (int) CENTER.getHeight() - Config.SHADOW_HEIGHT;

        final Group group = new Group();

        leftImageView = new ImageView();
        leftImageView.setImage(LEFT);

        centerImageView = new ImageView();
        centerImageView.setImage(CENTER);
        centerImageView.setTranslateX(LEFT.getWidth());

        rightImageView = new ImageView();
        rightImageView.setImage(RIGHT);

        changeSize(DEFAULT_SIZE);
        group.getChildren().addAll(leftImageView, centerImageView, rightImageView);
        getChildren().add(group);
        setMouseTransparent(true);
    }

    /**
     * Retrieve the size of the bat
     * 
     * @return
     *         The size of the bat
     */
    public int getSize() {
        return size;
    }

    /**
     * Retrieve the width of the bat
     * 
     * @return
     *         The width of the bat
     */
    public int getWidth() {
        return width;
    }

    /**
     * Retrieve the height of the bat
     * 
     * @return
     *         The height of the bat
     */
    public int getHeight() {
        return height;
    }

    /**
     * Change the size of the bat
     * 
     * @param newSize
     *            The new size of the bat
     */
    public void changeSize(int newSize) {
        size = newSize;
        width = (size * 12) + 45;

        final double rightWidth = RIGHT.getWidth() - Config.SHADOW_WIDTH;
        final double centerWidth = width - LEFT.getWidth() - rightWidth;

        centerImageView.setViewport(new Rectangle2D((CENTER.getWidth() - centerWidth) / 2, 0, centerWidth, CENTER.getHeight()));
        rightImageView.setTranslateX(width - rightWidth);
    }
}