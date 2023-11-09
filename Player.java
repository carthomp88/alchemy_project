import java.io.FileNotFoundException;

public class Player {
    private Inventory inv;

    public Player() throws FileNotFoundException {
        inv = new Inventory();
        inv.addItem(0, 1);
        inv.addItem(1, 1);
        inv.addItem(6, 1);
    }

    public Inventory getInv() {
        return inv;
    }
}
