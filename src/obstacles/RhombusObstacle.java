package obstacles;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class RhombusObstacle {
        double centerX;
        double centerY;
        double length;
        boolean isRotate;
        public RhombusObstacle(double cX, double cY, double l, boolean rot) {
                centerX = cX;
                centerY = cY;
                length = l;
                isRotate = rot;
        }
        public Group returnRhombusObstacle() {
                Group group= new Group();
                double temp1= (Math.sqrt(3) / (double) 2) * (double) length;
                double temp2= length/2;
                LineComponent l1 = new LineComponent(centerX- temp1, centerY, centerX, centerY- temp2,Color.CYAN, 15);
                LineComponent l2 = new LineComponent(centerX, centerY- temp2, centerX+ temp1, centerY, Color.PURPLE, 15);
                LineComponent l3 = new LineComponent(centerX+ temp1, centerY, centerX, centerY+ temp2, Color.YELLOW, 15);
                LineComponent l4 = new LineComponent(centerX, centerY+temp2, centerX- temp1, centerY,Color.RED, 15);
                Line line1 = l1.returnLineComponent();
                Line line2 = l2.returnLineComponent();
                Line line3 = l3.returnLineComponent();
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

    }
