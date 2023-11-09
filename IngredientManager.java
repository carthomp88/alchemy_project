import java.io.FileNotFoundException;

public class IngredientManager {
    private INode ingredientTableHead;
    private INode cursorINode;
    private String filename;

    public IngredientManager() {
        ingredientTableHead = new INode();
        filename = "./files/ingredients.csv";
        cursorINode = ingredientTableHead;
        // ingredients.csv format:
        // ID of ingredient, name of ingredient, monetary base value, image file name,
        // brief description
        // ex: 0,Red,15,./images/Red.png,The Color Red
    }

    public void makeTable() throws FileNotFoundException {
        // have a CSV with potential recipes be read in here
        csvReader reader = new csvWrapper();
        String[] lines = reader.readFile(filename);
        for (String line : lines) {
            if (line != null) {
                String[] data = line.split(",");
                cursorINode.addNode(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]), data[3], data[4]);
                cursorINode = cursorINode.getNext();
            }
        }
    }

    public Resource cloneResource(int id) {
        Resource output;
        INode targetNode = search(id);
        if (targetNode != null) {
            output = new Ingredient(targetNode.getName(), targetNode.getID(), targetNode.getVal(), targetNode.getImg(),
                    targetNode.toString());
            return output;
        }
        return null;
    }

    public INode search(int id) {
        cursorINode = ingredientTableHead.getNext();
        while (cursorINode != null) {
            if (cursorINode.getID() == id)
                return cursorINode;
            else
                cursorINode = cursorINode.getNext();
        }
        return null;
    }
}

/*
 * private String name;
 * private int id;
 * private int value;
 * private String description;
 * private String imgFileName;
 */