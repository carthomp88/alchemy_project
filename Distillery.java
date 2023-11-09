import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Distillery implements Screen {
    private Pane pane;
    private Pane alchemyMenuPane;
    private Player player;

    private EventHandler<WindowEvent> alcMenuClose;

    public Distillery(Player p) {
        player = p;
    }

    public void generate() {
        Circle bottle = new Circle();
        bottle.setFill(Color.ALICEBLUE);
        bottle.setRadius(200);
        pane = new StackPane(bottle);
        alchemyMenuPane = new Pane(player.getInv().getPane());

        EventHandler<MouseEvent> bottleClick = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Stage alchemyMenu = new Stage();
                Scene alchemyScene = new Scene(alchemyMenuPane, 600, 600);
                alchemyMenu.setScene(alchemyScene);
                alchemyMenu.setTitle("Distilling");
                alchemyMenu.show();
            }
        };

        bottle.setOnMouseClicked(bottleClick);

    }

    public Pane getPane() {
        return pane;
    }

    public EventHandler<WindowEvent> getAlcMenuCloseEvent() {
        return alcMenuClose;
    }
}
