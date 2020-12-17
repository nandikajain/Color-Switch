import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.Serializable;

public class Ball implements Serializable {

    private final static long serialVersionUID = 657;
    transient Circle circle;
    double positionY;
    double velocity;
    double userVelocity;
    double acceleration;
    transient Color ballColor;
    double width = 20;
    double height = width;
    double centerX = width / 2.0;
    double centerY = height / 2.0;
    double radius = width / 2.0;
    double maxSpeed = 100;

    transient Node view;
    transient Pane layer = null;

    public Ball(Pane layer, double positionY, Color color){
        this.layer = layer;
        this.positionY = positionY;
        this.velocity = 0;
        this.acceleration = 0;
        this.ballColor= color;
        this.userVelocity = -5;

        circle = new Circle(radius);
        circle.setCenterX(centerX);
        circle.setCenterY(centerY);
        circle.setFill(ballColor);
        circle.setLayoutX(240);
        this.view = circle;
        layer.getChildren().add(view);
        circle.setLayoutY(positionY);
        this.display();
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
        if (positionY > layer.getHeight() - radius ) {
            velocity *= 0;
            positionY = layer.getHeight() - radius;
        }
    }
    public boolean isBottom()
    {
        if (positionY >= layer.getHeight() -radius){
            return true;
        }
        return false;
    }

    public void display(){
        circle.setLayoutY(positionY);
    }
    public double getLocation(){
        return positionY-centerY;
    }
    public double getLocationCollision(){
        return positionY;
    }
    public Circle getCircle(){return  circle;}
    public Color getBallColor() {
        return (Color) circle.getFill();
    }

    public void setBallColor(Color ballColor) {
        circle.setFill(ballColor);
    }

    public void setup(){
        circle.setCenterX(centerX);
        circle.setCenterY(centerY);
    }

    public double getPositionY() {
        return positionY;
    }
    public void setPositionY(double s){this.positionY = s;}

    public void makeInvisible() {
        circle.setVisible(false);
    }

}
