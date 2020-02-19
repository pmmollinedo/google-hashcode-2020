package app.model;

public class Pizza {

    private int position;
    private int slices;

    public Pizza() {}

    public Pizza(int position, int slices) {
        this.position = position;
        this.slices = slices;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getSlices() {
        return this.slices;
    }

    public void setSlices(int slices) {
        this.slices = slices;
    }

    @Override
    public String toString() {
        return "Pizza = {" +
            " position='" + getPosition() + "'" +
            ", slices='" + getSlices() + "'" +
            "}";
    }

}