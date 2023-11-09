import java.io.FileNotFoundException;
import java.util.ArrayList;

public class RecipeManager {
    private RNode recipeTableHead;
    private String filename;
    private RNode cursorRNode;
    private IngredientManager im;

    public RecipeManager() throws FileNotFoundException {
        recipeTableHead = new RNode();
        filename = "./files/recipes.csv";
        cursorRNode = recipeTableHead;
        im = new IngredientManager();
        im.makeTable();
        // recipes.csv format:
        // ID of ingredient produced, number of combinations that produce it, those
        // combinations as IDs, quantities for each combo
        // ex: 3,2,1:2,3,2:1
    }

    public IngredientManager imAccesser() {
        return im;
    }

    public void makeTable() throws FileNotFoundException {
        // have a CSV with potential recipes be read in here
        cursorRNode = recipeTableHead;
        csvReader reader = new csvWrapper();
        String[] lines = reader.readFile(filename);
        for (String line : lines) {
            if (line != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                int combos = Integer.parseInt(data[1]);
                String[] componentNames = new String[combos];
                for (int i = 0; i < combos; i++) {
                    componentNames[i] = data[2 + i];
                }
                int qCount = 0;
                String[] qStrings = data[data.length - 1].split(":");
                for (String compName : componentNames) {
                    String[] s = compName.split(":");
                    Resource[] r = new Resource[s.length];
                    for (int i = 0; i < s.length; i++) {
                        r[i] = im.cloneResource(Integer.parseInt(s[i]));
                    }
                    cursorRNode.addNode(id, r, Integer.parseInt(qStrings[qCount]));
                    qCount++;
                    cursorRNode = cursorRNode.getNext();
                }
            }
        }
    }
}
