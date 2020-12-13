import javafx.scene.Group;

public abstract class Obstacle {
    double positionY;
    double velocity;
    double userVelocity;
    double acceleration;
    double width = 20;
    double height = width;

    public Obstacle()
    {

    }
    public abstract Group generateObstacle();
    public abstract double getStarPositionY();
    public void userMove() {
        velocity=0;
        acceleration=0;
        positionY+=userVelocity;
    }
    public abstract void display();

}
