import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.io.Serializable;
import java.util.ArrayList;


public class TwoEqualCircles extends Obstacle implements Serializable {
    private final static long serialVersionUID = 62323954;
    double centerX;
    double centerY;
    double r1;
    double r2;
    double speed;
    transient ArrayList<Shape>shapes;
    transient Arc arc1, arc2, arc3, arc4, arc1b, arc2b,arc3b, arc4b;

    public TwoEqualCircles(double cX, double cY, double radius1, double radius2, double s)
    {
        centerX=cX;
        centerY= cY;
        r1= radius1;
        r2= radius2;
        speed = s;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public Group generateObstacle(){
        shapes= new ArrayList<Shape>();
        Group group= new Group();

        Group g1 = new Group();
        //Circle Obstacle Creation
        ArcComponent a1b= new ArcComponent(centerX, centerY, r1, r1, 0, 90, Color.PURPLE, 10);
        ArcComponent a2b= new ArcComponent(centerX, centerY, r1, r1, 90, 90, Color.CYAN, 10);
        ArcComponent a3b= new ArcComponent(centerX, centerY,  r1, r1, 180, 90, Color.YELLOW, 10);
        ArcComponent a4b= new ArcComponent(centerX, centerY,  r1, r1, 270, 90, Color.RED, 10);
        arc1b = a1b.returnArc();
        arc2b = a2b.returnArc();
        arc3b = a3b.returnArc();
        arc4b = a4b.returnArc();
        g1.getChildren().addAll(arc1b);
        g1.getChildren().addAll(arc2b);
        g1.getChildren().addAll(arc3b);
        g1.getChildren().addAll(arc4b);
        shapes.add(arc1b);
        shapes.add(arc2b);
        shapes.add(arc3b);
        shapes.add(arc4b);
        //rotation
        RotateTransition rot = new RotateTransition();
        rot.setAxis(Rotate.Z_AXIS);
        rot.setByAngle(360);
        rot.setCycleCount(50000);
        rot.setDuration(Duration.millis(speed));
        rot.setInterpolator(Interpolator.LINEAR);
        rot.setNode(g1);
        rot.setAutoReverse(false);
        rot.play();
        group.getChildren().addAll(g1);

        Group g2 = new Group();
        //Circle Obstacle Creation
        ArcComponent a1= new ArcComponent(centerX, centerY, r2, r2, 0, 90, Color.PURPLE, 10);
        ArcComponent a2= new ArcComponent(centerX , centerY, r2, r2, 90, 90, Color.CYAN, 10);
        ArcComponent a3= new ArcComponent(centerX , centerY, r2, r2, 180, 90, Color.YELLOW, 10);
        ArcComponent a4= new ArcComponent(centerX , centerY, r2, r2, 270, 90, Color.RED, 10);
        arc1 = a1.returnArc();
        arc2 = a2.returnArc();
        arc3 = a3.returnArc();
        arc4 = a4.returnArc();
        g2.getChildren().addAll(arc1);
        g2.getChildren().addAll(arc2);
        g2.getChildren().addAll(arc3);
        g2.getChildren().addAll(arc4);
        shapes.add(arc1);
        shapes.add(arc2);
        shapes.add(arc3);
        shapes.add(arc4);

        //rotation
        RotateTransition rotate = new RotateTransition();
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(360);
        rotate.setCycleCount(50000);
        rotate.setDuration(Duration.millis(speed));
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setNode(g2);
        rotate.setAutoReverse(false);
        rotate.play();

        group.getChildren().addAll(g2);
        return group;
    }
    @Override
    public double getStarPositionY()
    {return  centerY;}
    @Override
    public double getColorSwitcherPositionY(){
        return centerY - r1 - 100;
    }
    @Override
    public ArrayList<Shape> getShapesList(){
        return shapes;
    }

    public double getCenterX() {
        return centerX;
    }

    public void setCenterX(double centerX) {
        this.centerX = centerX;
    }

    @Override
    public double getCenterY() {
        return centerY;
    }

    public void setCenterY(double centerY) {
        this.centerY = centerY;
    }

    public double getR1() {
        return r1;
    }

    public void setR1(double r1) {
        this.r1 = r1;
    }

    public double getR2() {
        return r2;
    }

    public void setR2(double r2) {
        this.r2 = r2;
    }
    @Override
    public void display()
    {
        arc1.setLayoutY(arc1.getLayoutY()+5);
        arc2.setLayoutY(arc2.getLayoutY()+5);
        arc3.setLayoutY(arc3.getLayoutY()+5);
        arc4.setLayoutY(arc4.getLayoutY()+ 5);
        arc1b.setLayoutY(arc1b.getLayoutY()+5);
        arc2b.setLayoutY(arc2b.getLayoutY()+5);
        arc3b.setLayoutY(arc3b.getLayoutY()+5);
        arc4b.setLayoutY(arc4b.getLayoutY()+ 5);
        centerY+=5;
    }



}
