package code.app.brickbreaker;

public class Utils {

    private static final java.util.Random RANDOM = new java.util.Random();

    /**
     * Returns random integer number from 0 to max - 1
     * 
     * @param max
     *            The maximum size of the random number
     * @return Random number
     */
    public static int random(int max) {
        return (int) (RANDOM.nextDouble() * max);
    }

    /**
     * Returns the sign of the value
     * 
     * @param n
     *            value
     * @return sign
     */
    public static int sign(double n) {
        if (n == 0) {
            return 0;
        }

        if (n > 0) {
            return 1;
        } else {
            return -1;
        }
    }
}