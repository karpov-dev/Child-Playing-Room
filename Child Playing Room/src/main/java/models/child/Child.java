package models.child;

import base.constants.NumberConstants;
import base.constants.StringConstants;
import models.room.Room;
import models.toys.Toy;

import java.util.ArrayList;

public class Child {
    private int id;
    private int age;
    private String name;
    private Gender gender;
    private ArrayList<Toy> usedToys;

    public Child(int age, Gender gender, String name) {
        setAge(age);
        setGender(gender);
        setName(name);
        setUsedToys(new ArrayList<Toy>());
    }

    public void enterRoom(Room room) {
        room.getChild().add(this);
    }

    public void leaveRoom(Room room) {
        room.getChild().remove(this);
    }

    public void play(Toy toy) {
        if (!toy.isBusy() && !getUsedToys().contains(toy)) {
            toy.setBusy(true);
            getUsedToys().add(toy);
        }
    }

    public void stopPlay(Toy toy) {
        if (getUsedToys().contains(toy)) {
            getUsedToys().remove(toy);
            toy.setBusy(false);
        }
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) age = NumberConstants.DEFAULT_CHILD_AGE;

        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty()) name = StringConstants.DEFAULT_NAME;

        this.name = name;
    }

    public void setId(int id) {
        if (this.id == 0) this.id = id;
    }

    public ArrayList<Toy> getUsedToys() {
        return usedToys;
    }

    public void setUsedToys(ArrayList<Toy> usedToys) {
        this.usedToys = usedToys;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + "\nAge: " + String.valueOf(getAge()) + "\nGender: " + getGender().toString();
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(getId());
    }

    @Override
    public boolean equals(Object obj) {
        obj = (Child) obj;

        return ((Child) obj).getId() == getId();
    }
}
