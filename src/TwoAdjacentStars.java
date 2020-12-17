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

public class TwoAdjacentStars extends Obstacle implements Serializable {
    private final static long serialVersionUID = 6828392;
    double centerXa;
    double centerY;
    double length;
    double speed;
    double centerXb;
    transient ArrayList<Shape> shapes;
    transient Line line1, line2, line3, line4, line1a, line1b, line1c, line1d;
    public TwoAdjacentStars(double Xa, double cY,  double len, double s)
    {
        speed = s;

        centerXa= Xa;
        centerXb= Xa+ 2*len;
        centerY= cY;
        length= len;
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
        shapes= new ArrayList<Shape>();
        Group group = new Group();
       // StarObstacle s1= new StarObstacle(centerXa, centerY, length, false);
        //Group g1= s1.generateObstacle();
        Group g1= new Group();
        //Star Obstacle Creation
        LineComponent l1a = new LineComponent(centerXa, centerY, centerXa, centerY-length,Color.CYAN, 17 );
        line1a = l1a.returnLineComponent();
        g1.getChildren().addAll(line1a);
        LineComponent l2a = new LineComponent(centerXa, centerY, centerXa-length, centerY,Color.PURPLE, 17 );
        line1b = l2a.returnLineComponent();
        g1.getChildren().addAll(line1b);
        LineComponent l3a = new LineComponent(centerXa, centerY, centerXa, centerY+length,Color.YELLOW, 17 );
        line1c = l3a.returnLineComponent();
        g1.getChildren().addAll(line1c);
        LineComponent l4a = new LineComponent(centerXa, centerY, centerXa+length, centerY,Color.RED, 17 );
        line1d = l4a.returnLineComponent();
        g1.getChildren().addAll(line1d);
        shapes.add(line1a);
        shapes.add(line1b);
        shapes.add(line1c);
        shapes.add(line1d);
        //rotation
        RotateTransition rot= new RotateTransition();
        rot.setAxis(Rotate.Z_AXIS);
        rot.setByAngle(360);
        rot.setCycleCount(10000);
        rot.setDuration(Duration.millis(speed));
        rot.setInterpolator(Interpolator.LINEAR);
        rot.setNode(g1);
        rot.setAutoReverse(false);
        rot.play();
        group.getChildren().addAll(g1);
        Group g2= new Group();
        //Star Obstacle Creation
        LineComponent l1 = new LineComponent(centerXb, centerY, centerXb, centerY-length, Color.YELLOW, 17 );
        line1 = l1.returnLineComponent();
        g2.getChildren().addAll(line1);
        LineComponent l2 = new LineComponent(centerXb, centerY, centerXb-length, centerY,Color.RED, 17 );
        line2 = l2.returnLineComponent();
        g2.getChildren().addAll(line2);
        LineComponent l3 = new LineComponent(centerXb, centerY, centerXb, centerY+length,Color.CYAN, 17 );
        line3 = l3.returnLineComponent();
        g2.getChildren().addAll(line3);
        LineComponent l4 = new LineComponent(centerXb, centerY, centerXb+length, centerY,Color.PURPLE, 17 );
        line4 = l4.returnLineComponent();
        g2.getChildren().addAll(line4);
        shapes.add(line1);
        shapes.add(line2);
        shapes.add(line3);
        shapes.add(line4);
        //rotation
        RotateTransition rotate = new RotateTransition();
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(360);
        rotate.setCycleCount(10000);
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
    { return centerY-length;}
    @Override
    public double getColorSwitcherPositionY(){
        return centerY - length - 100;
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
        line1a.setLayoutY(line1a.getLayoutY()+5);
        line1b.setLayoutY(line1b.getLayoutY()+5);
        line1c.setLayoutY(line1c.getLayoutY()+5);
        line1d.setLayoutY(line1d.getLayoutY()+ 5);
        centerY+=5;
    }

    public double getCenterXa() {
        return centerXa;
    }
    public void setCenterXa(double centerXa) {
        this.centerXa = centerXa;
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
    public double getCenterXb() {
        return centerXb;
    }
    public void setCenterXb(double centerXb) {
        this.centerXb = centerXb;
    }

}
