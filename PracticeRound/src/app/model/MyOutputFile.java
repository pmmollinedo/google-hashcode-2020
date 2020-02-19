package app.model;

import java.util.List;

public class MyOutputFile {

    private int numberOfOrderedPizzas;
    private List<Integer> pizzaPositionsList;

    public MyOutputFile() {}

    public int getNumberOfOrderedPizzas() {
        return this.numberOfOrderedPizzas;
    }

    public void setNumberOfOrderedPizzas(int numberOfOrderedPizzas) {
        this.numberOfOrderedPizzas = numberOfOrderedPizzas;
    }

    public List<Integer> getPizzaPositionsList() {
        return this.pizzaPositionsList;
    }

    public void setPizzaPositionsList(List<Integer> pizzaPositionsList) {
        this.pizzaPositionsList = pizzaPositionsList;
    }

    @Override
    public String toString() {
        return "MyOutputFile = {" +
            " numberOfOrderedPizzas='" + getNumberOfOrderedPizzas() + "'" +
            ", pizzaPositionsList='" + getPizzaPositionsList() + "'" +
            "}";
    }

    
}