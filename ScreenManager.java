import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScreenManager extends Application {
    public static enum screenName {
        MAINMENU, CENTER, SHOP, MINE, FOREST, DISTILLERY, DUNGEON
    };

    private Stage stage;

    @Override
    public void start(Stage stage) {
        stage.setResizable(false);
        this.stage = stage;
        changeScreen(ScreenManager.screenName.MAINMENU);
    }

    public void changeScreen(ScreenManager.screenName name) {
        switch (name) {
            case MAINMENU:
                Screen mainMenu = new MainMenu();
                mainMenu.generate();
                Scene scene = new Scene(mainMenu.getPane(), 1280, 720);
                stage.setScene(scene);
                stage.show();
                break;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        RecipeManager rm = new RecipeManager();
        rm.makeTable();
        System.out.println(rm.getIngredients(2));
        launch();
    }
}