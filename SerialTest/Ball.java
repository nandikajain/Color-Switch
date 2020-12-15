import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import common.PVector;

import java.io.Serializable;

public class Ball extends Region implements Serializable {
    PVector location;
    PVector velocity;
    PVector userVelocity;
    PVector acceleration;

    transient Node view;

    double width = 20;
    double height = width;
    double centerX = width / 2.0;
    double centerY = height / 2.0;
    double radius = width / 2.0;

    double maxSpeed = 100;

    transient Pane layer = null;

    public Ball(Pane layer, PVector location, PVector velocity, PVector acceleration){
        this.layer = layer;
        this.location = location;
        this.velocity = velocity;
        this.acceleration = acceleration;

        this.userVelocity = new PVector(0,-8);

        Circle circle = new Circle(radius);
        circle.setCenterX(radius);
        circle.setCenterY(radius);

        circle.setFill(Color.BLUE.deriveColor(1, 1, 1, 0.3));

        this.view = circle;
        getChildren().add(view);
        layer.getChildren().add(this);

    }

    public void applyForce() {
        PVector gravity = new PVector(0,0.3);
        acceleration.add(gravity);
    }


    public void move() {
        velocity.add(acceleration);
        velocity.limit(maxSpeed);
        location.add(velocity);
        acceleration.mult(0);
    }

    public void userMove() {
        velocity.mult(0);
        acceleration.mult(0);
        location.add(userVelocity);
    }

    public void checkBounds(){
        if (location.y > layer.getHeight() - radius) {
            velocity.y *= 0;
            location.y = layer.getHeight() - radius;
            //return true;
            //System.out.println("Collision");
        }
    }

    public void display(){
        relocate(location.x - centerX, location.y - centerY);
    }

    public double getLocation() {
        return location.y-centerY;
    }

    public double getLocationCollision(){
        return location.y;
    }
}
