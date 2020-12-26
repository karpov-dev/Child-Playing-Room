import factories.ChildFactory;
import factories.ToyFactory;
import managers.RoomManager;
import models.child.Child;
import models.child.Gender;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import models.room.Room;
import models.toys.*;


public class RoomManager_Test {
    private Toy testToy1;
    private Toy testToy2;
    private Toy testToy3;
    private Toy testToy4;
    private Toy testToy5;
    private Child testChild1;
    private Child testChild2;
    private Child testChild3;
    private Room room;

    @Before
    public void setup() {
        testToy1 = ToyFactory.getCar(3, "Car", Color.BLACK);
        testToy2 = ToyFactory.getBall(2, "Ball", Color.BLACK);
        testToy3 = ToyFactory.getCube(1, "Cube", Color.BLACK);
        testToy4 = ToyFactory.getDoll(5, "Doll", Color.GREEN);
        testToy5 = ToyFactory.getSoftToy(10, "SoftToy", Color.RED);
        testChild1 = ChildFactory.getChild(14, Gender.MALE, "Alex");
        testChild2 = ChildFactory.getChild(13, Gender.FEMALE, "Sara");
        testChild3 = ChildFactory.getChild(12, Gender.MALE, "Kris");

        RoomManager.clearRoom(room);

        room = Room.getInstance(4, 15);
    }

    @Test
    public void removeChildrenFromRoom_Test() {
        RoomManager.addChild(testChild1, room);
        RoomManager.addChild(testChild2, room);
        RoomManager.addChild(testChild3, room);

        RoomManager.removeChild(testChild1, room);

        Assert.assertFalse(room.getChild().contains(testChild1));
    }

    @Test
    public void removeToyFromRoom_Test() {
        RoomManager.addToy(testToy1, room);
        RoomManager.addToy(testToy3, room);
        RoomManager.addToy(testToy2, room);
        RoomManager.removeToy(testToy1, room);

        Assert.assertEquals(false, room.getToys().contains(testToy1));
    }

    @Test
    public void correctChildren_Test() {
        RoomManager.addChild(testChild1, room);
        RoomManager.addChild(testChild1, room);
        RoomManager.addChild(testChild2, room);

        Assert.assertEquals(4, room.getChild().size());
    }

    @Test
    public void roomCreate_Test() {
        Room room1 = RoomManager.createRoom(12, 100);

        Assert.assertNotNull(room1);
    }

    @Test
    public void toysOfColor_Test() {
        RoomManager.addToy(testToy1, room);
        RoomManager.addToy(testToy3, room);
        RoomManager.addToy(testToy2, room);
        RoomManager.addToy(testToy4, room);
        RoomManager.addToy(testToy5, room);

        Assert.assertTrue(RoomManager.toysOfColor(Color.BLACK, room).stream().allMatch(t -> t.getColor() == Color.BLACK));
    }

    @Test
    public void toysPriceSort_Test() {
        RoomManager.addToy(testToy1, room);
        RoomManager.addToy(testToy3, room);
        RoomManager.addToy(testToy2, room);
        RoomManager.addToy(testToy4, room);
        RoomManager.addToy(testToy5, room);

        boolean isSorted = true;
        double cost = 0;

        RoomManager.sortToysByPrice(room);

        for (Toy toy : RoomManager.getToys(room)) {
            if (toy.getCost() < cost) {
                isSorted = false;
                break;
            }
            cost = toy.getCost();
        }

        Assert.assertTrue(isSorted);
    }

    @Test
    public void toysLessAndColor_Test() {
        RoomManager.addToy(testToy1, room);
        RoomManager.addToy(testToy3, room);
        RoomManager.addToy(testToy2, room);
        RoomManager.addToy(testToy4, room);
        RoomManager.addToy(testToy5, room);


        Assert.assertTrue(RoomManager.getCostLessAndColor(3, Color.BLACK, room).stream().allMatch(t -> t.getColor() == Color.BLACK && t.getCost() < 3));
    }
}
