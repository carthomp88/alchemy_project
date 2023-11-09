import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class InvNode {
    private Resource resourceType;
    private int quantity;

    public Node getImgNode() throws FileNotFoundException {
        ImageView imgView;
        Node imgNode;
        if (resourceType == null) {
            imgView = new ImageView(new Image(new FileInputStream("./images/emptyInvSlot.png")));
            return imgView;
        }
        imgView = new ImageView(new Image(new FileInputStream(((Ingredient) resourceType).getImgName())));
        Text qText = new Text(40, 40, "" + quantity);
        Text pText = new Text(10, 40, "" + ((Ingredient) resourceType).getVal());
        qText.setFill(Color.WHITE);
        pText.setFill(Color.YELLOW);
        qText.setTranslateX(15);
        pText.setTranslateX(-15);
        qText.setTranslateY(35);
        pText.setTranslateY(35);
        qText.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 16));
        pText.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 16));
        imgNode = new StackPane(imgView, qText, pText);
        imgNode.minHeight(60);

        return imgNode;
    }

    public Resource getResource() {
        return resourceType;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isEmpty() {
        if (quantity > 0)
            return false;
        return true;
    }

    public void setResource(Resource resource) {
        resourceType = resource;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
