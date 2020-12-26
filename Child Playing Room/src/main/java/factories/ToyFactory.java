package factories;
import base.constants.NumberConstants;
import models.toys.*;

public class ToyFactory {
    private static int idCounter = NumberConstants.TOY_ID_COUNTER_START;

    public static SoftToy getSoftToy(double cost, String name, Color color) {
        SoftToy softToy = new SoftToy(cost, name, color);
        softToy.setId(idCounter++);

        return softToy;
    }

    public static Car getCar(double cost, String name, Color color) {
        Car car = new Car(cost, name, color);
        car.setId(idCounter++);

        return car;
    }

    public static Ball getBall(double cost, String name, Color color) {
        Ball ball = new Ball(cost, name, color);
        ball.setId(idCounter++);

        return ball;
    }

    public static Doll getDoll(double cost, String name, Color color) {
        Doll doll = new Doll(cost, name, color);
        doll.setId(idCounter++);

        return doll;
    }

    public static Cube getCube(double cost, String name, Color color) {
        Cube cube = new Cube(cost, name, color);
        cube.setId(idCounter++);

        return cube;
    }
}
