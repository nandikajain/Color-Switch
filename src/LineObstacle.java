import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class LineObstacle extends Obstacle implements Serializable {
    private final static long serialVersionUID = 78393;
    double centerY;
    transient ArrayList<Shape> shapes;
    transient Line line1, line2, line3, line4, line5;

    //Change values here in order to get line obstacles with different parameters
    public LineObstacle(double cY)
        {
            centerY = cY;
        }

    @Override
    public Group generateObstacle() {
        shapes= new ArrayList<Shape>();
        Group group = new Group();
        //Line Obstacle Creation
        LineComponent l1 = new LineComponent(0, centerY, 100, centerY, Color.CYAN, 15);
        line1 = l1.returnLineComponent();
        group.getChildren().addAll(line1);
        LineComponent l2 = new LineComponent(100, centerY, 200, centerY, Color.PURPLE, 15);
        line2 = l2.returnLineComponent();
        group.getChildren().addAll(line2);
        LineComponent l3 = new LineComponent(200, centerY, 300, centerY, Color.YELLOW, 15);
        line3 = l3.returnLineComponent();
        group.getChildren().addAll(line3);
        LineComponent l4 = new LineComponent(300, centerY, 400, centerY, Color.RED, 15);
        line4 = l4.returnLineComponent();
        group.getChildren().addAll(line4);
        LineComponent l5 = new LineComponent(400, centerY, 500, centerY, Color.CYAN, 15);
        line5 = l5.returnLineComponent();
        group.getChildren().addAll(line5);
        shapes.add(line1);
        shapes.add(line2);
        shapes.add(line3);
        shapes.add(line4);
        shapes.add(line5);

        //Color.CYAN,Color.PURPLE,Color.YELLOW,Color.RED;
        new Timer().schedule(
                new TimerTask() {

                    @Override
                    public void run() {
                        if (line1.getStroke() == Color.CYAN)
                            line1.setStroke(Color.RED);
                        else if (line1.getStroke() == Color.PURPLE)
                            line1.setStroke(Color.CYAN);
                        else if (line1.getStroke() == Color.YELLOW)
                            line1.setStroke(Color.PURPLE);
                        else if (line1.getStroke() == Color.RED)
                            line1.setStroke(Color.YELLOW);
                        if (line2.getStroke() == Color.CYAN)
                            line2.setStroke(Color.RED);
                        else if (line2.getStroke() == Color.PURPLE)
                            line2.setStroke(Color.CYAN);
                        else if (line2.getStroke() == Color.YELLOW)
                            line2.setStroke(Color.PURPLE);
                        else if (line2.getStroke() == Color.RED)
                            line2.setStroke(Color.YELLOW);
                        if (line3.getStroke() == Color.CYAN)
                            line3.setStroke(Color.RED);
                        else if (line3.getStroke() == Color.PURPLE)
                            line3.setStroke(Color.CYAN);
                        else if (line3.getStroke() == Color.YELLOW)
                            line3.setStroke(Color.PURPLE);
                        else if (line3.getStroke() == Color.RED)
                            line3.setStroke(Color.YELLOW);
                        if (line4.getStroke() == Color.CYAN)
                            line4.setStroke(Color.RED);
                        else if (line4.getStroke() == Color.PURPLE)
                            line4.setStroke(Color.CYAN);
                        else if (line4.getStroke() == Color.YELLOW)
                            line4.setStroke(Color.PURPLE);
                        else if (line4.getStroke() == Color.RED)
                            line4.setStroke(Color.YELLOW);
                        if (line5.getStroke() == Color.CYAN)
                            line5.setStroke(Color.RED);
                        else if (line5.getStroke() == Color.PURPLE)
                            line5.setStroke(Color.CYAN);
                        else if (line5.getStroke() == Color.YELLOW)
                            line5.setStroke(Color.PURPLE);
                        else if (line5.getStroke() == Color.RED)
                            line5.setStroke(Color.YELLOW);

                    }
                }, 0, 1000);

        return group;
    }
    @Override
    public double getStarPositionY()
    {
        return centerY-40;
    }
    @Override
    public double getColorSwitcherPositionY(){
        return centerY - 120;
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
        line5.setLayoutY(line5.getLayoutY()+ 5);
        centerY+=5;

    }
    @Override
    public double getCenterY() {
        return centerY;
    }

    public void setCenterY(double centerY) {
        this.centerY = centerY;
    }




}
