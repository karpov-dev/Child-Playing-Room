package managers;

import models.child.Child;
import models.child.BaseChild;

import java.util.ArrayList;

public class ChildManager {
    private static BaseChild baseChild;

    public static void add(Child children) {
        if (baseChild == null) baseChild = BaseChild.getInstance();

        if (!baseChild.getChildren().contains(children)) {
            baseChild.getChildren().add(children);
        }
    }

    public static void remove(Child children) {
        if (baseChild == null || !baseChild.getChildren().contains(children))
            return;
        baseChild.getChildren().remove(children);
    }

    public static ArrayList<Child> getAll() {
        if (baseChild == null) baseChild = BaseChild.getInstance();

        return baseChild.getChildren();
    }

    public static boolean fillBase(String path) {
        Boolean isFilled = null;

        try {
            isFilled = baseChild.fillBaseFromFile(path);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        return isFilled;
    }

    public static Child getById(int id) {
        if (baseChild == null) baseChild = BaseChild.getInstance();
        for (Child children : baseChild.getChildren()) {
            if (children.getId() == id) return children;
        }

        return null;
    }

    public static void clear() {
        if (baseChild == null) baseChild = BaseChild.getInstance();
        baseChild.setChildren(new ArrayList<Child>());
    }
}
