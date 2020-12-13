package obstacles;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import javafx.scene.paint.Color;

//Change values here in order to get star obstacles with different parameters
public class SquareObstacle extends Obstacle {
    double centerX;
    double centerY;
    double length;
    boolean isRotate;

    public SquareObstacle(double cX, double cY, double l, boolean rot) {
        centerX = cX;
        centerY = cY;
        length = l;
        isRotate = rot;
    }
    @Override
    public Group generateObstacle() {
        Group group= new Group();
        //Square Obstacle Creation
        double temp = length/2;
        LineComponent l1= new LineComponent(centerX- temp, centerY - temp, centerX + temp, centerY - temp, Color.CYAN, 15);
        Line line1 = l1.returnLineComponent();
        LineComponent l2= new LineComponent(centerX+ temp, centerY - temp, centerX+ temp, centerY + temp, Color.PURPLE, 15);
        Line line2 = l2.returnLineComponent();
        LineComponent l3= new LineComponent(centerX+ temp, centerY + temp, centerX- temp, centerY + temp, Color.YELLOW, 15);
        Line line3 = l3.returnLineComponent();
        LineComponent l4= new LineComponent(centerX- temp, centerY + temp, centerX - temp, centerY - temp,Color.RED, 15);
        Line line4 = l4.returnLineComponent();
        group.getChildren().addAll(line1);
        group.getChildren().addAll(line2);
        group.getChildren().addAll(line3);
        group.getChildren().addAll(line4);
        //rotation
        RotateTransition rotate = new RotateTransition();
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(360);
        rotate.setCycleCount(50000);
        rotate.setDuration(Duration.millis(3000));
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setNode(group);
        rotate.setAutoReverse(isRotate);
        rotate.play();

        return group;

    }
    @Override
    public double getStarPositionY()
    {
        return centerY;
    }

    public double getCenterX() {
        return centerX;
    }

    public void setCenterX(double centerX) {
        this.centerX = centerX;
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

    public boolean isRotate() {
        return isRotate;
    }

    public void setRotate(boolean rotate) {
        isRotate = rotate;
    }



}