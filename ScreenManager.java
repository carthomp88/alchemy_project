import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScreenManager extends Application {
    public static Player player;

    public static enum screenName {
        MAINMENU, CENTER, SHOP, MINE, FOREST, DISTILLERY, DUNGEON
    };

    private Stage stage;

    @Override
    public void start(Stage stage) {
        stage.setResizable(false);
        this.stage = stage;
        changeScreen(ScreenManager.screenName.DISTILLERY);
    }

    public void changeScreen(ScreenManager.screenName name) {
        switch (name) {
            case MAINMENU:
                Screen mainMenu = new MainMenu();
                mainMenu.generate();
                Scene mmScene = new Scene(mainMenu.getPane(), 1280, 720);
                stage.setTitle("Main Menu");
                stage.setScene(mmScene);
                stage.show();
                break;

            case CENTER:
                break;

            case SHOP:
                break;

            case MINE:
                break;

            case FOREST:
                break;

            case DISTILLERY:
                Screen distillery = new Distillery(player);
                distillery.generate();
                Scene disScene = new Scene(distillery.getPane(), 1280, 720);
                stage.setTitle("Distillery");
                stage.setScene(disScene);
                stage.show();
                break;

            case DUNGEON:
                break;
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        player = new Player();
        launch();
    }
}