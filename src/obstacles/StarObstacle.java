package obstacles;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class StarObstacle extends Obstacle  {
    double centerX;
    double centerY;
    double length;
    boolean isRotate;

    //Change values here in order to get star obstacles with different parameters
    public StarObstacle(double cX, double cY, double l, boolean isR)
    {
        centerX = cX;
        centerY = cY;
        length = l;
        isRotate= isR;
    }
    @Override
    public Group generateObstacle()
    {
        Group group= new Group();
        //Star Obstacle Creation
        LineComponent l1 = new LineComponent(centerX, centerY, centerX, centerY-length,Color.CYAN, 17 );
        Line line1 = l1.returnLineComponent();
        group.getChildren().addAll(line1);
        LineComponent l2 = new LineComponent(centerX, centerY, centerX-length, centerY,Color.PURPLE, 17 );
        Line line2 = l2.returnLineComponent();
        group.getChildren().addAll(line2);
        LineComponent l3 = new LineComponent(centerX, centerY, centerX, centerY+length,Color.YELLOW, 17 );
        Line line3 = l3.returnLineComponent();
        group.getChildren().addAll(line3);
        LineComponent l4 = new LineComponent(centerX, centerY, centerX+length, centerY,Color.RED, 17 );
        Line line4 = l4.returnLineComponent();
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
