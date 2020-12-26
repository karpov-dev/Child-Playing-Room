package factories;

import base.constants.NumberConstants;
import models.child.Child;
import models.child.Gender;

public class ChildFactory {
    public static int idCounter = NumberConstants.CHILD_ID_COUNTER_START;

    public static Child getChild(int age, Gender gender, String name) {
        Child children = new Child(age, gender, name);
        children.setId(idCounter++);

        return children;
    }
}
