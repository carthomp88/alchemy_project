import javafx.scene.layout.Pane;

public interface Screen {
    public abstract Pane getPane();

    public abstract void generate();
}
