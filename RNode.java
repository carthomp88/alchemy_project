public class RNode {
    private int outputID;
    private Resource[] components;
    private int quantity;

    private RNode next;

    public void addNode(int id, Resource[] comps, int quantity) {
        next = new RNode();
        next.setID(id);
        next.setComponents(comps);
        next.setQuantity(quantity);
    }

    public void setID(int id) {
        outputID = id;
    }

    public void setComponents(Resource[] components) {
        this.components = components;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getID() {
        return outputID;
    }

    public Resource[] getComps() {
        return components;
    }

    public int getQuantity() {
        return quantity;
    }

    public RNode getNext() {
        return next;
    }
}
