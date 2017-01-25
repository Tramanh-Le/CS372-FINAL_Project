package code.app.brickbreaker;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This class represents a 'bonus' functions and side bar view in the game.
 */
public class Bonus extends Parent {

    public static final int TYPE_SLOW = 0;

    public static final int TYPE_FAST = 1;

    public static final int TYPE_CATCH = 2;

    public static final int TYPE_GROW_BAT = 3;

    public static final int TYPE_REDUCE_BAT = 4;

    public static final int TYPE_GROW_BALL = 5;

    public static final int TYPE_REDUCE_BALL = 6;

    public static final int TYPE_STRIKE = 7;

    public static final int TYPE_LIFE = 8;

    public static final int COUNT = 9;

    public static final String[] NAMES = new String[] {
            "SLOW",
            "FAST",
            "CATCH",
            "GROW BAT",
            "REDUCE BAT",
            "GROW BALL",
            "REDUCE BALL",
            "STRIKE",
            "LIFE",
    };

    private final int type;

    private final int width;

    private final int height;

    private final ImageView content;

    /**
     * Non-default images and the shadow during game.
     * 
     * @param type
     *            The type of bonus
     */
    public Bonus(int type) {
        content = new ImageView();

        getChildren().add(content);
        this.type = type;

        final Image image = Config.getBonusesImages().get(type);
        width = (int) image.getWidth() - Config.SHADOW_WIDTH;
        height = (int) image.getHeight() - Config.SHADOW_HEIGHT;
        content.setImage(image);

        setMouseTransparent(true);
    }

    /**
     * Retrieve the height of the bonus
     * 
     * @return
     *         The height of the bonus
     */
    public int getHeight() {
        return height;
    }

    /**
     * @return width of bonus
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return type of bonus dropped
     */
    public int getType() {
        return type;
    }
}