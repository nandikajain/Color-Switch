package obstacles;

import javafx.scene.Group;

public abstract class Obstacle {
    public Obstacle()
    {

    }
    public abstract Group generateObstacle();
    public abstract double getStarPositionY();

}
