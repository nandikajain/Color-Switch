package obstacles;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class LineComponent {
    double startX;
    double startY;
    double endY;
    double endX;
    Color c;
    double width;
    LineComponent(double sX, double sY, double eX, double eY, Color C, double w)
    {
        startX = sX;
        startY = sY;
        endY = eY;
        endX = eX;
        c = C;
        width = w;
    }
    Line returnLineComponent()
    {
        Line line = new Line();
        line.setStartX(startX);
        line.setStartY(startY);
        line.setEndX(endX);
        line.setEndY(endY);
        line.setStroke(c);
        line.setStrokeWidth(width);
        return line;

    }

}
