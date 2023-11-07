public class Item implements Resource {
    private String name;
    private int value;
    private int id;
    private int uses;
    private String description;
    private String imgFileName;

    public Item(String name, int id, int basevalue, int uses, String description, String imgFileName) {
        this.name = name;
        this.id = id;
        this.uses = uses;
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

    public int getUsesRemaining() {
        return uses;
    }

    public void use() {
        uses--;
    }

    @Override
    public String toString() {
        return description;
    }

    public String getImgName() {
        return imgFileName;
    }
}
