package models.room;

import base.constants.NumberConstants;
import models.child.Child;
import models.toys.Toy;

import java.util.ArrayList;

public class Room {
    private static Room instance;
    private double allocatedMoney;
    private int amountOfToys = NumberConstants.DEFAULT_AMOUNT_OF_TOYS;
    private int childrenCapacity;
    private ArrayList<Toy> toys;
    private ArrayList<Child> children;

    private Room() {
        childrenCapacity = NumberConstants.DEFAULT_CHILD_CAPACITY;
        allocatedMoney = NumberConstants.DEFAULT_ALLOCATE_MONEY;
        setToys(new ArrayList<Toy>());
        setChildren(new ArrayList<Child>());
    }

    private Room(int amountOfToys, double allocatedMoney) {
        setAllocatedMoney(allocatedMoney);
        setChildrenCapacity(NumberConstants.DEFAULT_CHILD_CAPACITY);
        setAmountOfToys(amountOfToys);
        setToys(new ArrayList<Toy>());
        setChildren(new ArrayList<Child>());
    }

    public static Room getInstance() {
        if (instance == null) instance = new Room();

        return instance;
    }

    public static Room getInstance(int amountOfToys, double allocatedMoney) {
        if (instance == null) instance = new Room(amountOfToys, allocatedMoney);

        return instance;
    }

    public double getAllocatedMoney() {
        return allocatedMoney;
    }

    public void setAllocatedMoney(double allocatedMoney) {
        if (allocatedMoney < 0) allocatedMoney = NumberConstants.DEFAULT_ALLOCATE_MONEY;
        this.allocatedMoney = allocatedMoney;
    }

    public int getAmountOfToys() {
        return amountOfToys;
    }

    public void setAmountOfToys(int amountOfToys) {
        if (this.amountOfToys == -1) {
            if (amountOfToys < 0) amountOfToys = NumberConstants.DEFAULT_AMOUNT_OF_TOYS;
            this.amountOfToys = amountOfToys;
        }
    }

    public int getChildrenCapacity() {
        return childrenCapacity;
    }

    public void setChildrenCapacity(int childrenCapacity) {
        if (childrenCapacity < 0) childrenCapacity = NumberConstants.DEFAULT_AMOUNT_OF_TOYS;
        this.childrenCapacity = childrenCapacity;
    }

    public ArrayList<Toy> getToys() {
        return toys;
    }

    public void setToys(ArrayList<Toy> toys) {
        this.toys = toys;
    }

    public ArrayList<Child> getChild() {
        return children;
    }

    public void setChildren(ArrayList<Child> children) {
        this.children = children;
    }

    public double leftMoney() {
        double money = 0;
        for (Toy toy : getToys()) {
            money += toy.getCost();
        }

        return getAllocatedMoney() - money;
    }
}
