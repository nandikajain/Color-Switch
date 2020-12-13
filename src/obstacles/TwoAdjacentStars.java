package obstacles;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class TwoAdjacentStars extends  Obstacle{
    double centerXa;
    double centerY;
    double length;
    double centerXb;
    public TwoAdjacentStars(double Xa, double cY,  double len)
    {
        centerXa= Xa;
        centerXb= Xa+ 2*len;
        centerY= cY;
        length= len;
    }
    @Override
    public Group generateObstacle()
    {
        Group group = new Group();
        StarObstacle s1= new StarObstacle(centerXa, centerY, length, false);
        Group g1= s1.generateObstacle();
        group.getChildren().addAll(g1);
        Group g2= new Group();
        //Star Obstacle Creation
        LineComponent l1 = new LineComponent(centerXb, centerY, centerXb, centerY-length, Color.YELLOW, 17 );
        Line line1 = l1.returnLineComponent();
        g2.getChildren().addAll(line1);
        LineComponent l2 = new LineComponent(centerXb, centerY, centerXb-length, centerY,Color.RED, 17 );
        Line line2 = l2.returnLineComponent();
        g2.getChildren().addAll(line2);
        LineComponent l3 = new LineComponent(centerXb, centerY, centerXb, centerY+length,Color.CYAN, 17 );
        Line line3 = l3.returnLineComponent();
        g2.getChildren().addAll(line3);
        LineComponent l4 = new LineComponent(centerXb, centerY, centerXb+length, centerY,Color.PURPLE, 17 );
        Line line4 = l4.returnLineComponent();
        g2.getChildren().addAll(line4);
        //rotation
        RotateTransition rotate = new RotateTransition();
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(360);
        rotate.setCycleCount(50000);
        rotate.setDuration(Duration.millis(3000));
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

    public double getCenterXa() {
        return centerXa;
    }
    public void setCenterXa(double centerXa) {
        this.centerXa = centerXa;
    }
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
