public class Ingredient implements Resource {
    private String name;
    private int id;
    private int value;
    private String description;
    private String imgFileName;

    public Ingredient(String name, int id, int basevalue, String description, String imgFileName) {
        this.name = name;
        this.id = id;
        value = basevalue;
        this.description = description;
        this.imgFileName = imgFileName;
    }

    @Override
    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getVal() {
        return value;
    }

    @Override
    public String toString() {
        return description;
    }

    public String getImgName() {
        return imgFileName;
    }
}
