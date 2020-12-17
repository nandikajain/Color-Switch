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

public class RhombusObstacle extends Obstacle implements Serializable {
        private final static long serialVersionUID = 653192354;
        double centerX;
        double centerY;
        double length;
        double speed;
        boolean isRotate;
        transient ArrayList<Shape> shapes;
        transient Line line1, line2, line3, line4;
        public RhombusObstacle(double cX, double cY, double l, boolean rot , double s) {

                centerX = cX;
                centerY = cY;
                length = l;
                isRotate = rot;
                speed = s;
        }

        public double getSpeed() {
                return speed;
        }

        public void setSpeed(double speed) {
                this.speed = speed;
        }

        @Override
        public Group generateObstacle() {
                shapes= new ArrayList<Shape>();
                Group group= new Group();
                double temp1= (Math.sqrt(3) / (double) 2) * (double) length;
                double temp2= length/2;
                LineComponent l1 = new LineComponent(centerX- temp1, centerY, centerX, centerY- temp2,Color.CYAN, 15);
                LineComponent l2 = new LineComponent(centerX, centerY- temp2, centerX+ temp1, centerY, Color.PURPLE, 15);
                LineComponent l3 = new LineComponent(centerX+ temp1, centerY, centerX, centerY+ temp2, Color.YELLOW, 15);
                LineComponent l4 = new LineComponent(centerX, centerY+temp2, centerX- temp1, centerY,Color.RED, 15);
                line1 = l1.returnLineComponent();
                line2 = l2.returnLineComponent();
                line3 = l3.returnLineComponent();
                line4 = l4.returnLineComponent();
                shapes.add(line1);
                shapes.add(line2);
                shapes.add(line3);
                shapes.add(line4);
                group.getChildren().addAll(line1);
                group.getChildren().addAll(line2);
                group.getChildren().addAll(line3);
                group.getChildren().addAll(line4);
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
        public double getStarPositionY(){
                return centerY;
        }
        @Override
        public double getColorSwitcherPositionY(){
                return centerY - length-75;
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
