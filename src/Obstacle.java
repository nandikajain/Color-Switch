import javafx.scene.Group;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

public abstract class Obstacle {
    double positionY;
    double velocity;
    double userVelocity;
    double acceleration;
    double width = 20;
    double height = width;

    public Obstacle()
    {
        userVelocity=5;
    }
    public abstract Group generateObstacle();
    public abstract double getStarPositionY();
    public abstract double getColorSwitcherPositionY();
    public void userMove() {
        velocity=0;
        acceleration=0;
        positionY+=userVelocity;
    }
    public abstract void display();
    public abstract ArrayList<Shape> getShapesList();

}
