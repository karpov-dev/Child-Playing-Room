package models.toys;

import base.constants.NumberConstants;
import base.constants.StringConstants;

public abstract class Toy {
    private static int idCounter = NumberConstants.TOY_ID_COUNTER_START;
    private int id;
    private double cost;
    private String name;
    private Color color;
    private boolean isBusy;

    public Toy() {
        id = idCounter++;
        cost = NumberConstants.DEFAULT_TOY_COST;
        name = StringConstants.DEFAULT_TOY_NAME;
        color = Color.UNDEFINED;
        isBusy = false;
    }

    public Toy(double cost) {
        id = idCounter++;
        setCost(cost);
        name = StringConstants.DEFAULT_TOY_NAME;
        color = Color.UNDEFINED;
        isBusy = false;
    }

    public Toy(String name) {
        id = idCounter++;
        cost = NumberConstants.DEFAULT_TOY_COST;
        setName(name);
        color = Color.UNDEFINED;
        isBusy = false;
    }

    public Toy(Color color) {
        id = idCounter++;
        cost = NumberConstants.DEFAULT_TOY_COST;
        name = StringConstants.DEFAULT_TOY_NAME;
        setColor(color);
        isBusy = false;
    }

    public Toy(double cost, String name, Color color) {
        id = idCounter++;
        setCost(cost);
        setName(name);
        setColor(color);
        isBusy = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (this.id == 0) this.id = id;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        if (cost < 0) cost = 1;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty()) name = StringConstants.DEFAULT_NAME;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Toy: \"" + getName().toString() + "\"\nColor: " + getColor().toString() + "\nCost: " + String.valueOf(getCost());
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(getId());
    }

    @Override
    public boolean equals(Object obj) {
        obj = (Toy) obj;
        return ((Toy) obj).getId() == getId();
    }
}
