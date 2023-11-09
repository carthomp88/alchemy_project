import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Inventory {
    private RecipeManager rm;
    private InvNode[] inventory;
    private Pane inventoryDisplay;
    private GridPane inventorySlots;
    private GridPane[] inventoryRows;

    public Inventory() throws FileNotFoundException {
        rm = new RecipeManager();
        rm.makeTable();

        inventory = new InvNode[15];
        for (int i = 0; i < 15; i++) {
            inventory[i] = new InvNode();
            inventory[i].setQuantity(0);
            inventory[i].setResource(null);
        }

        inventorySlots = new GridPane();
        inventoryDisplay = new Pane();
        inventoryRows = new GridPane[3];
        for (int i = 0; i < 3; i++) {
            inventoryRows[i] = new GridPane();
            inventoryRows[i].setHgap(10);
        }
        populateDisplay();
        for (int i = 0; i < 3; i++) {
            inventorySlots.addRow(i, inventoryRows[i]);
        }
        inventorySlots.setVgap(20);
        inventoryDisplay = new Pane(inventorySlots);
        inventoryDisplay
                .setBackground(new Background(new BackgroundFill(Color.BROWN, new CornerRadii(0), new Insets(0))));
    }

    public void addItem(int id, int quantity) throws FileNotFoundException {
        for (int i = 0; i < 15; i++) {
            if (inventory[i].getResource() == null) {
                inventory[i].setResource(rm.imAccesser().cloneResource(id));
                inventory[i].setQuantity(quantity);
                break;
            }
        }
        updateDisplay();
    }

    public void cleanInventory() {
        for (InvNode slot : inventory) {
            if (slot.getQuantity() <= 0)
                slot.setResource(null);
        }
    }

    public boolean hasSpaceRemaining() {
        return false;
    }

    public void populateDisplay() throws FileNotFoundException {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                inventoryRows[i].addColumn(j, inventory[i * 5 + j].getImgNode());
            }
        }
    }

    public void updateDisplay() throws FileNotFoundException {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                inventoryRows[i].add(inventory[i * 5 + j].getImgNode(), j, 0);
            }
        }
    }

    public void removeItem(int id, int quantity) {

    }

    public int itemInInventory(int id) {
        int itemIndex = -1;
        return itemIndex;
    }

    public RecipeManager rmAccesser() {
        return rm;
    }

    public Pane getPane() {
        return inventoryDisplay;
    }
}
