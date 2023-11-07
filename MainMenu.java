import javafx.scene.layout.Pane;

public class MainMenu implements Screen {
    private Pane pane;

    public Pane getPane() {
        return pane;
    }

    public void generate() {
        pane = new Pane();
    }
}
