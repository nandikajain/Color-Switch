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

public class Ball extends Region{

    double positionY;
    double velocity;
    double userVelocity;
    double acceleration;

    double width = 20;
    double height = width;
    double centerX = width / 2.0;
    double centerY = height / 2.0;
    double radius = width / 2.0;

    double maxSpeed = 100;

    Node view;
    Pane layer = null;

    public Ball(Pane layer, double positionY){
        this.layer = layer;
        this.positionY = positionY;
        this.velocity = 0;
        this.acceleration = 0;

        this.userVelocity = -12;

        Circle circle = new Circle(radius);
        circle.setCenterX(radius);
        circle.setCenterY(radius);

        circle.setFill(Color.RED);

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

}
