package managers;

import models.child.Child;
import models.room.Room;
import models.toys.Car;
import models.toys.Color;
import models.toys.Toy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class RoomManager {
    public static Room createRoom(int amountOfToys, double allocatedMoney) {
        Room newRoom = Room.getInstance(amountOfToys, allocatedMoney);

        return newRoom;
    }

    public static void addToy(Toy toy, Room room) {
        if (room == null) room = Room.getInstance();
        if (room.getToys().size() < room.getAmountOfToys() && !room.getToys().contains(toy)) {
            if (toy.getCost() <= room.leftMoney()) {
                room.getToys().add(toy);
            }
        }
    }

    public static void removeToy(Toy toy, Room room) {
        if (room == null || !room.getToys().contains(toy)) return;

        room.getToys().remove(toy);
    }

    public static void addChild(Child children, Room room) {
        if (room == null) room = Room.getInstance();
        if (room.getChild().contains(children)) return;
        if (room.getChild().size() < room.getChildrenCapacity()) {
            room.getChild().add(children);
        }
    }

    public static void clearRoom_Child(Room room) {
        if (room == null) return;
        room.setChildren(new ArrayList<Child>());
    }

    public static void clearRoom_Toys(Room room) {
        if (room == null) return;
        room.setToys(new ArrayList<Toy>());
    }

    public static void clearRoom(Room room) {
        if (room == null) return;

        clearRoom_Child(room);
        clearRoom_Toys(room);
    }

    public static boolean removeChild(Child children, Room room) {
        if (room == null || !room.getChild().contains(children)) return false;

        return room.getChild().remove(children);
    }

    public static ArrayList<Toy> getToys(Room room) {
        return room.getToys();
    }

    public static ArrayList<Car> getCars(Room room) {
        ArrayList<Car> cars = new ArrayList<Car>();
        for (Toy toy : room.getToys()) {
            if (toy.getClass() == Car.class) cars.add((Car) toy);
        }

        return cars;
    }

    public static List<Toy> toysOfColor(Color color, Room room) {
        ArrayList<Toy> toys = new ArrayList<>();
        room.getToys().stream().filter(t -> t.getColor().equals(color)).map(toys::add);

        return toys;
    }

    public static List<Toy> getCostLessAndColor(double cost, Color color, Room room) {
        ArrayList<Toy> toys = new ArrayList<>();
        room.getToys().stream().filter(t -> t.getColor().equals(color) && t.getCost() < cost).map(toys::add);

        return toys;
    }

    public static void sortToysByPrice(Room room) {
        room.getToys().sort(new Comparator<Toy>() {
            @Override
            public int compare(Toy o1, Toy o2) {
                return Double.compare(o1.getCost(), o2.getCost());
            }
        });
    }

    public static void sortToysByName(Room room) {
        room.getToys().sort(new Comparator<Toy>() {
            @Override
            public int compare(Toy o1, Toy o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }
}
