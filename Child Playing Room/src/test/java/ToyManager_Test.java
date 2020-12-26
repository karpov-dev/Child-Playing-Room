import factories.ToyFactory;
import models.toys.*;
import managers.ToyManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ToyManager_Test {
    private Toy toy1;
    private Toy toy2;
    private Toy toy3;

    @Before
    public void setup() {
        toy1 = ToyFactory.getCar(3, "Car", Color.UNDEFINED);
        toy2 = ToyFactory.getBall(2, "Ball", Color.UNDEFINED);
        toy3 = ToyFactory.getCube(1, "Cube", Color.UNDEFINED);
    }

    @Test
    public void fillingBase_Test() {
        boolean filed = ToyManager.fillBase("path.txt");

        Assert.assertFalse(filed);
    }

    @Test
    public void addingChildren_Test() {
        ToyManager.addToy(toy1);
        ToyManager.addToy(toy2);
        ToyManager.addToy(toy3);
        ToyManager.addToy(toy1);

        Assert.assertEquals(3, ToyManager.getAllToys().size());
    }

    @Test
    public void removeChildren_Test() {
        ToyManager.addToy(toy1);
        ToyManager.addToy(toy2);
        ToyManager.addToy(toy3);
        ToyManager.removeToy(toy2);

        Assert.assertNull(ToyManager.getToy(toy2.getId()));
    }

    @Test
    public void getChildren_Test() {
        ToyManager.addToy(toy1);

        Assert.assertTrue(ToyManager.getToy(toy2.getId()) == null && ToyManager.getToy(toy1.getId()) == toy1);
    }
}
