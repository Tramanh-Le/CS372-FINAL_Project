package code.app.brickbreaker;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This class represents a 'brick' in the game
 */
public class Brick extends Parent {

    public static final int TYPE_BLUE = 0;

    public static final int TYPE_BROKEN1 = 1;

    public static final int TYPE_BROKEN2 = 2;

    public static final int TYPE_BROWN = 3;

    public static final int TYPE_CYAN = 4;

    public static final int TYPE_GREEN = 5;

    public static final int TYPE_GREY = 6;

    public static final int TYPE_MAGENTA = 7;

    public static final int TYPE_ORANGE = 8;

    public static final int TYPE_RED = 9;

    public static final int TYPE_VIOLET = 10;

    public static final int TYPE_WHITE = 11;

    public static final int TYPE_YELLOW = 12;

    private int type;

    private final ImageView content;

    /**
     * Non-default constructor
     * 
     * @param type
     *            The type of brick
     */
    public Brick(int type) {
        content = new ImageView();

        getChildren().add(content);
        changeType(type);
        setMouseTransparent(true);
    }

    /**
     * Retrieve the brick type
     * 
     * @return
     *         The type of brick
     */
    public int getType() {
        return type;
    }

    /**
     * Kick the brick
     * 
     * @return
     *         A boolean representing whether the brick was successfully kicked
     */
    public boolean kick() {
        if (type == TYPE_GREY) {
            return false;
        }

        if (type == TYPE_BROKEN1) {
            changeType(TYPE_BROKEN2);
            return false;
        }

        return true;
    }

    /**
     * Change the brick type
     * 
     * @param newType
     *            The new brick type
     */
    private void changeType(int newType) {
        type = newType;

        final Image image = Config.getBricksImages().get(type);

        content.setImage(image);
        content.setFitWidth(Config.FIELD_WIDTH / 15);
    }

    /**
     * Retrieve the type of brick
     * 
     * @param s
     *            Value representing brick type
     * @return
     *         The brick type
     */
    public static int getBrickType(String s) {
        if (s.equals("L")) {
            return TYPE_BLUE;
        } else if (s.equals("2")) {
            return TYPE_BROKEN1;
        } else if (s.equals("B")) {
            return TYPE_BROWN;
        } else if (s.equals("C")) {
            return TYPE_CYAN;
        } else if (s.equals("G")) {
            return TYPE_GREEN;
        } else if (s.equals("E")) {
            return TYPE_GREY;
        } else if (s.equals("M")) {
            return TYPE_MAGENTA;
        } else if (s.equals("O")) {
            return TYPE_ORANGE;
        } else if (s.equals("R")) {
            return TYPE_RED;
        } else if (s.equals("V")) {
            return TYPE_VIOLET;
        } else if (s.equals("W")) {
            return TYPE_WHITE;
        } else if (s.equals("Y")) {
            return TYPE_YELLOW;
        } else {
            System.out.println("Unknown brick type '{s}'");
            return TYPE_WHITE;
        }
    }
}