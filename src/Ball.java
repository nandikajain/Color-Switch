import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball extends Region{

    double positionY;
    double velocity;
    double userVelocity;
    double acceleration;
    Color ballColor;
    double width = 20;
    double height = width;
    double centerX = width / 2.0;
    double centerY = height / 2.0;
    double radius = width / 2.0;

    double maxSpeed = 100;

    Node view;
    Pane layer = null;

    public Ball(Pane layer, double positionY, Color color){
        this.layer = layer;
        this.positionY = positionY;
        this.velocity = 0;
        this.acceleration = 0;
        this.ballColor= color;

        this.userVelocity = -12;

        Circle circle = new Circle(radius);
        circle.setCenterX(radius);
        circle.setCenterY(radius);

        circle.setFill(ballColor);

        this.view = circle;
        getChildren().add(view);
        layer.getChildren().add(this);

    }

    public void applyForce() {
        double gravity = 0.3;
        acceleration+=gravity;
    }


    public void move() {
        velocity+=acceleration;
        positionY+=velocity;
        acceleration=0;
    }

    public void userMove() {
        velocity=0;
        acceleration=0;
        positionY+=userVelocity;
    }

    public void checkBottom(){
        if (positionY > layer.getHeight() - 80 - radius) {
            velocity *= 0;
            positionY = layer.getHeight() - 80 - radius;
        }
    }

    public void display(){
        relocate(240, positionY - centerY);
    }
    public Color getBallColor() {
        return ballColor;
    }

    public void setBallColor(Color ballColor) {
        this.ballColor = ballColor;
    }

}
