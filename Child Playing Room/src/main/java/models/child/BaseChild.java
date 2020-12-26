package models.child;

import base.interfaces.IDataBase;
import base.exceptions.DataBaseException;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class BaseChild implements IDataBase {
    private static BaseChild instance;
    private List<Child> children;

    public static BaseChild getInstance() {
        if (instance == null) {
            instance = new BaseChild();
            instance.children = new ArrayList<>();
        }

        return instance;
    }

    public ArrayList<Child> getChildren() {
        return (ArrayList<Child>) children;
    }

    public void setChildren(ArrayList<Child> children) {
        this.children = children;
    }

    @Override
    public boolean fillBaseFromFile(String path) throws DataBaseException {
        if (!children.isEmpty()) throw new DataBaseException("Base is not empty!");

        File file = new File(path);
        if (!file.exists()) return false;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            children = (ArrayList<Child>) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }

        return true;
    }
}
