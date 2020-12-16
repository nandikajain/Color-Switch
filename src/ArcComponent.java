import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

import java.io.Serializable;

//will return an arc component
public class ArcComponent implements Serializable {

        private final static long serialVersionUID = 656214;
        double centerX;
        double centerY;
        double radiusY;
        double radiusX;
        double startAngle;
        double length;
        transient Color c;
        double strokeWidth;
        public ArcComponent(double X, double Y, double rX, double rY, double start_angle, double l, Color C, double width)
        {
            centerX = X;
            centerY = Y;
            radiusX = rX;
            radiusY = rY;
            startAngle = start_angle;
            length = l;
            c = C;
            strokeWidth= width;
        }
        public Arc returnArc()
        {
            Arc arc1 = new Arc();
            arc1.setCenterX(centerX);
            arc1.setCenterY(centerY);
            arc1.setRadiusX(radiusX);
            arc1.setRadiusY(radiusY);
            arc1.setStartAngle(startAngle);
            arc1.setLength(length);
            arc1.setFill(Color.TRANSPARENT);
            arc1.setStroke(c);
            arc1.setStrokeWidth(strokeWidth);
            arc1.setType(ArcType.OPEN);
            return arc1;
        }
}
