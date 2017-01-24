package code.app.brickbreaker;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * This is the main application class
 */
public class Main extends Application {

    private static MainFrame mainFrame;

    /**
     * The main entry point to the application
     * 
     * @param args
     *            Command-line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

    /**
     * Retrieve the main application frame
     * 
     * @return
     *         The main application frame
     */
    public static MainFrame getMainFrame() {
        return mainFrame;
    }

    /**
     * This method starts the application
     */
    @Override
    public void start(Stage stage) {
        Config.initialize();

        final Group root = new Group();
        mainFrame = new MainFrame(root);

        stage.setTitle("Brick Breaker");
        stage.setResizable(false);
        stage.setWidth(Config.SCREEN_WIDTH + (2 * Config.WINDOW_BORDER));
        stage.setHeight(Config.SCREEN_HEIGHT + (2 * Config.WINDOW_BORDER) + Config.TITLE_BAR_HEIGHT);

        final Scene scene = new Scene(root);
        scene.setFill(Color.BLACK);

        stage.setScene(scene);

        mainFrame.changeState(MainFrame.SPLASH);

        stage.show();
    }
}