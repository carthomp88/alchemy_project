import java.io.FileNotFoundException;
import java.util.ArrayList;

public class RecipeManager {
    private ArrayList<ArrayList<String[]>> recipeTable;
    private int[] idTable;
    private String[] infoTable;
    private String[] outputNames;
    private String filename;

    public RecipeManager() {
        recipeTable = new ArrayList<ArrayList<String[]>>();
        infoTable = new String[10];
        idTable = new int[10];
        for (int i = 0; i < 10; i++)
            idTable[i] = i;
        filename = "./files/recipes.csv";
        outputNames = new String[10];
    }

    public void makeTable() throws FileNotFoundException {
        // have a CSV with potential recipes be read in here
        csvReader reader = new csvWrapper();
        String[] lines = reader.readFile(filename);
        for (String line : lines) {
            if (line != null) {
                String[] components = line.split(",");
                String[] resources = components[0].split(":");
                Integer id = Integer.parseInt(components[1]);
                addRecipe(resources, id.intValue(), components[2], components[3]);
            }
        }
    }

    public void addRecipe(String[] recipeComponents, int id, String description, String name) {
        ArrayList<String[]> currentRecipe = search(id);
        if (currentRecipe == null) { // otherwise there is an existing list of recipes that can be added to, and
                                     // other info is filled in already
            currentRecipe = new ArrayList<String[]>();
            idTable[id] = id;
            infoTable[id] = description;
            outputNames[id] = name;
            recipeTable.add(currentRecipe);
        }
        currentRecipe.add(recipeComponents);
    }

    public ArrayList<String[]> search(int id) {
        if (recipeTable.size() <= id)
            return null;
        else {
            return recipeTable.get(id);
        }
    }

    public void extendTables() {

    }

    public String getOutput(int id) {
        return outputNames[id];
    }

    public String getIngredients(int id) {
        String ingString = "";
        for (String[] ingredientList : recipeTable.get(id)) {
            for (String ingredient : ingredientList)
                ingString += (ingredient + " ");
            ingString += "\n";
        }
        return ingString;
    }
}
