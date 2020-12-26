package managers;

import models.toys.BaseToy;
import models.toys.Toy;
import base.exceptions.DataBaseException;

import java.io.File;
import java.util.ArrayList;

public class ToyManager {

    private static BaseToy toysBase;

    public static void addToy(Toy toy) {
        if (toysBase == null) toysBase = BaseToy.getInstance();
        if (toysBase.getToys().contains(toy)) return;

        toysBase.getToys().add(toy);
    }

    public static void removeToy(Toy toy) {
        if (toysBase == null || !toysBase.getToys().contains(toy)) return;

        toysBase.getToys().remove(toy);
    }

    public static boolean fillBase(String path) {
        File file = new File(path);
        if (!file.exists()) return false;

        try {
            toysBase.fillBaseFromFile(path);
        } catch (DataBaseException dbe) {
            System.out.println(dbe.getMessage());
            return false;
        }

        return true;
    }

    public static ArrayList<Toy> getAllToys() {
        if (toysBase == null) toysBase = BaseToy.getInstance();

        return toysBase.getToys();
    }

    public static Toy getToy(int id) {
        if (toysBase == null) toysBase = BaseToy.getInstance();

        for (Toy toy : toysBase.getToys()) {
            if (toy.getId() == id) return toy;
        }

        return null;
    }
}
