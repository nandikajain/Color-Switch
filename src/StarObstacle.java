import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.io.Serializable;
import java.util.ArrayList;

public class StarObstacle extends Obstacle implements Serializable {
    private final static long serialVersionUID = 64441354;
    double centerX;
    double centerY;
    double length;
    boolean isRotate;
    transient ArrayList<Shape> shapes;
    double speed;
    transient Line line1,line2,line3, line4;

    //Change values here in order to get star obstacles with different parameters
    public StarObstacle(double cX, double cY, double l, boolean isR, double s)
    {
        speed= s;

        centerX = cX;
        centerY = cY;
        length = l;
        isRotate= isR;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public Group generateObstacle()
    {
        shapes = new ArrayList<Shape>();
        Group group= new Group();
        //Star Obstacle Creation
        LineComponent l1 = new LineComponent(centerX, centerY, centerX, centerY-length,Color.CYAN, 17 );
        line1 = l1.returnLineComponent();
        group.getChildren().addAll(line1);
        LineComponent l2 = new LineComponent(centerX, centerY, centerX-length, centerY,Color.PURPLE, 17 );
        line2 = l2.returnLineComponent();
        group.getChildren().addAll(line2);
        LineComponent l3 = new LineComponent(centerX, centerY, centerX, centerY+length,Color.YELLOW, 17 );
        line3 = l3.returnLineComponent();
        group.getChildren().addAll(line3);
        LineComponent l4 = new LineComponent(centerX, centerY, centerX+length, centerY,Color.RED, 17 );
        line4 = l4.returnLineComponent();
        group.getChildren().addAll(line4);
        shapes.add(line1);
        shapes.add(line2);
        shapes.add(line3);
        shapes.add(line4);
        //rotation
        RotateTransition rotate = new RotateTransition();
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(360);
        rotate.setCycleCount(50000);
        rotate.setDuration(Duration.millis(speed));
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setNode(group);
        rotate.setAutoReverse(isRotate);
        rotate.play();
        return group;
    }
    @Override
    public double getStarPositionY()
    {
        return centerY - length-10;
    }
    @Override
    public double getColorSwitcherPositionY(){
        return centerY - length - 105;
    }
    @Override
    public ArrayList<Shape> getShapesList(){
        return shapes;
    }
    @Override
    public void display()
    {
        line1.setLayoutY(line1.getLayoutY()+5);
        line2.setLayoutY(line2.getLayoutY()+5);
        line3.setLayoutY(line3.getLayoutY()+5);
        line4.setLayoutY(line4.getLayoutY()+ 5);
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

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public boolean isRotate() {
        return isRotate;
    }

    public void setRotate(boolean rotate) {
        isRotate = rotate;
    }
}
