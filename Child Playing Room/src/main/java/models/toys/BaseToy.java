package models.toys;

import base.interfaces.IDataBase;
import base.exceptions.DataBaseException;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class BaseToy implements IDataBase {
    private static BaseToy instance;
    private ArrayList<Toy> toys;

    public static BaseToy getInstance() {
        if (instance == null) {
            instance = new BaseToy();
            instance.setToys(new ArrayList<>());
        }
        return instance;
    }


    public ArrayList<Toy> getToys() {
        return toys;
    }

    public void setToys(ArrayList<Toy> toys) {
        this.toys = toys;
    }

    @Override
    public boolean fillBaseFromFile(String path) throws DataBaseException {
        if (!toys.isEmpty()) throw new DataBaseException("Base is not empty!");
        else {
            try (ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(path))) {
                toys = (ArrayList<Toy>) ois.readObject();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                return false;
            }
        }
        return true;
    }
}
