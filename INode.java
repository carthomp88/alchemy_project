public class INode {
    private int id;
    private int value;
    private String name;
    private String imgFilename;
    private String description;

    private INode next;

    public void addNode(int id, String name, int val, String desc, String imgFile) {
        next = new INode();
        next.setID(id);
        next.setName(name);
        next.setVal(val);
        next.setImg(imgFile);
        next.setDesc(desc);
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVal(int val) {
        value = val;
    }

    public void setImg(String imgFile) {
        imgFilename = imgFile;
    }

    public void setDesc(String desc) {
        description = desc;
    }

    public int getID() {
        return id;
    }

    public String getImg() {
        return imgFilename;
    }

    public INode getNext() {
        return next;
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

}
