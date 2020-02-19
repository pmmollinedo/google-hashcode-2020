package app.model;

import java.util.List;

public class MyInputFile {

    private int maxSlices;
    private int numberOfPizzas;
    private List<Pizza> pizzas;

    public MyInputFile() {}

    public int getMaxSlices() {
        return this.maxSlices;
    }

    public void setMaxSlices(int maxSlices) {
        this.maxSlices = maxSlices;
    }

    public int getNumberOfPizzas() {
        return this.numberOfPizzas;
    }

    public void setNumberOfPizzas(int numberOfPizzas) {
        this.numberOfPizzas = numberOfPizzas;
    }

    public List<Pizza> getPizzas() {
        return this.pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    @Override
    public String toString() {
        return "MyInputFile = {" +
            " maxSlices='" + getMaxSlices() + "'" +
            ", numberOfPizzas='" + getNumberOfPizzas() + "'" +
            ", pizzas='" + getPizzas() + "'" +
            "}";
    }
}