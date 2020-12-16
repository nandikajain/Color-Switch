import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.io.Serializable;

public class LineComponent implements Serializable {
    private final static long serialVersionUID = 65174;
    double startX;
    double startY;
    double endY;
    double endX;
    transient Color c;
    double width;
    public LineComponent(double sX, double sY, double eX, double eY, Color C, double w)
    {
        startX = sX;
        startY = sY;
        endY = eY;
        endX = eX;
        c = C;
        width = w;
    }
    public Line returnLineComponent()
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
