//public class Ball {
//    private int curBallColor; // 0-Red 1-Yellow 2-LightBlue 3-Purple?
//    private int positionY;
//    private int distance;
//    private boolean hasCollided;
//    private int speed;
//
//    public Ball(int initPos, int initColor, int speed){
//
//    }
//
//    public void moveUp(){
//
//    }
//
//    public int getCurBallColor() {
//        return curBallColor;
//    }
//
//    public void setCurBallColor(int curBallColor) {
//        this.curBallColor = curBallColor;
//    }
//
//    public int getPositionY() {
//        return positionY;
//    }
//
//    public void setSpeed(int speed) {
//        this.speed = speed;
//    }
//
//    public boolean getHasCollided(){
//        return this.hasCollided;
//    }
//
//    public void setHasCollided(boolean hasCollided) {
//        this.hasCollided = hasCollided;
//    }
//}

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import common.PVector;

public class Ball extends Region{
    PVector location;
    PVector velocity;
    PVector userVelocity;
    PVector acceleration;

    Node view;

    double width = 20;
    double height = width;
    double centerX = width / 2.0;
    double centerY = height / 2.0;
    double radius = width / 2.0;

    double maxSpeed = 100;

    Pane layer = null;

    public Ball(Pane layer, PVector location, PVector velocity, PVector acceleration){
        this.layer = layer;
        this.location = location;
        this.velocity = velocity;
        this.acceleration = acceleration;

        this.userVelocity = new PVector(0,-12);

        Circle circle = new Circle(radius);
        circle.setCenterX(radius);
        circle.setCenterY(radius);

        circle.setFill(Color.RED);

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
        }
    }

    public void display(){
        relocate(location.x - centerX, location.y - centerY);
    }

}
