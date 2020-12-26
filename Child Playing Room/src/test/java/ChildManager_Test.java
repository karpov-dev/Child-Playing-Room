import factories.ChildFactory;
import managers.ChildManager;
import models.child.Child;
import models.child.Gender;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChildManager_Test {
    private Child testChild1;
    private Child testChild2;
    private Child testChild3;

    @Before
    public void setup() {
        testChild1 = ChildFactory.getChild(13, Gender.FEMALE, "Test1");
        testChild2 = ChildFactory.getChild(12, Gender.FEMALE, "Test2");
        testChild3 = ChildFactory.getChild(19, Gender.MALE, "Test3");

        ChildManager.clear();
    }

    @Test
    public void fillingBase_Test() {
        boolean filed = ChildManager.fillBase("path.txt");

        Assert.assertFalse(filed);
    }

    @Test
    public void add_Test() {
        ChildManager.add(testChild1);
        ChildManager.add(testChild2);
        ChildManager.add(testChild3);
        ChildManager.add(testChild1);

        Assert.assertEquals(3, ChildManager.getAll().size());
    }

    @Test
    public void remove_Test() {
        ChildManager.add(testChild1);
        ChildManager.add(testChild2);
        ChildManager.add(testChild3);
        ChildManager.remove(testChild2);

        Assert.assertEquals(2, ChildManager.getAll().size());
        Assert.assertNull(ChildManager.getById(testChild2.getId()));
    }

    @Test
    public void getById_Test() {
        ChildManager.add(testChild1);

        Assert.assertNull(ChildManager.getById(testChild2.getId()));
        Assert.assertSame(ChildManager.getById(testChild1.getId()), testChild1);
    }
}
