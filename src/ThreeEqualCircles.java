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

public class ThreeEqualCircles extends Obstacle implements Serializable {
    private final static long serialVersionUID = 3448354;
    double centerX;
    double centerY;
    double r1;
    double r2;
    double speed;
    double r3;
    transient ArrayList<Shape> shapes;

    transient Arc arc1, arc2, arc3, arc4, arc1b, arc2b,arc3b, arc4b, arc1q, arc2q, arc3q, arc4q;

    public ThreeEqualCircles(double cX, double cY, double radius1, double radius2, double radius3, double s)
    {
        speed =s;
        centerX=cX;
        centerY= cY;
        r1= radius1;
        r2= radius2;
        r3= radius3;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public Group generateObstacle(){
        shapes = new ArrayList<Shape>();
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
        rotate.setAutoReverse(true);
        rotate.play();

        group.getChildren().addAll(g2);


        Group g3 = new Group();
        //Circle Obstacle Creation
        ArcComponent a1q= new ArcComponent(centerX, centerY, r3, r3, 0, 90, Color.PURPLE, 10);
        ArcComponent a2q= new ArcComponent(centerX , centerY, r3, r3, 90, 90, Color.CYAN, 10);
        ArcComponent a3q= new ArcComponent(centerX , centerY, r3, r3, 180, 90, Color.YELLOW, 10);
        ArcComponent a4q= new ArcComponent(centerX , centerY, r3, r3, 270, 90, Color.RED, 10);
        arc1q = a1q.returnArc();
        arc2q = a2q.returnArc();
        arc3q = a3q.returnArc();
        arc4q = a4q.returnArc();
        g3.getChildren().addAll(arc1q);
        g3.getChildren().addAll(arc2q);
        g3.getChildren().addAll(arc3q);
        g3.getChildren().addAll(arc4q);
        shapes.add(arc1q);
        shapes.add(arc2q);
        shapes.add(arc3q);
        shapes.add(arc4q);


        //rotation
        RotateTransition rotate1 = new RotateTransition();
        rotate1.setAxis(Rotate.Z_AXIS);
        rotate1.setByAngle(360);
        rotate1.setCycleCount(50000);
        rotate1.setDuration(Duration.millis(speed));
        rotate1.setInterpolator(Interpolator.LINEAR);
        rotate1.setNode(g3);
        rotate1.setAutoReverse(false);
        rotate1.play();

        group.getChildren().addAll(g3);
        return group;
    }
    @Override
    public double getStarPositionY()
    {
        return centerY;
    }
    @Override
    public double getColorSwitcherPositionY(){
        return centerY - r3 - 95;
    }
    @Override
    public ArrayList<Shape> getShapesList(){
        return shapes;
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
        arc1q.setLayoutY(arc1q.getLayoutY()+5);
        arc2q.setLayoutY(arc2q.getLayoutY()+5);
        arc3q.setLayoutY(arc3q.getLayoutY()+5);
        arc4q.setLayoutY(arc4q.getLayoutY()+ 5);
        centerY+=5;
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

    public double getR3() {
        return r3;
    }

    public void setR3(double r3) {
        this.r3 = r3;
    }


}
