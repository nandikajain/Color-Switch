import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import common.PVector;

public class Obs extends Region{
    PVector location;
    PVector velocity;
    PVector userVelocity;

    Node view;
    Pane layer = null;

    double radius = 50.0;
    double centerX = 50.0;
    double centerY = 50.0;

    public Obs(Pane layer, PVector location, PVector velocity){
        this.layer = layer;
        this.location = location;
        this.velocity = velocity;

        this.userVelocity = new PVector(0,5);

        Circle circle = new Circle(50);
        circle.setCenterX(radius);
        circle.setCenterY(radius);
        circle.setFill(Color.BLUE);

        this.view = circle;
        getChildren().add(view);
        layer.getChildren().add(this);
    }

    public void userMove() {
        velocity.mult(0);
        location.add(userVelocity);
    }

    public void display(){
        relocate(location.x - centerX, location.y - centerY);
    }

}
