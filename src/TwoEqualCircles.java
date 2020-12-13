//import javafx.scene.Group;
//import obstacles.CircleObstacle;
//import obstacles.Obstacle;
//
//public class TwoEqualCircles extends Obstacle {
//    double centerX;
//    double centerY;
//    double r1;
//    double r2;
//
//    public TwoEqualCircles(double cX, double cY, double radius1, double radius2)
//    {
//        centerX=cX;
//        centerY= cY;
//        r1= radius1;
//        r2= radius2;
//    }
//    @Override
//    public Group generateObstacle(){
//        Group group= new Group();
//        CircleObstacle c1= new CircleObstacle(centerX, centerY, r1, false);
//        CircleObstacle c2= new CircleObstacle(centerX, centerY, r2, true);
//        Group g1= c1.generateObstacle();
//        Group g2= c2.generateObstacle();
//        group.getChildren().addAll(g1);
//        group.getChildren().addAll(g2);
//        return group;
//    }
//    @Override
//    public double getStarPositionY()
//    {return  centerY;}
//
//    public double getCenterX() {
//        return centerX;
//    }
//
//    public void setCenterX(double centerX) {
//        this.centerX = centerX;
//    }
//
//    public double getCenterY() {
//        return centerY;
//    }
//
//    public void setCenterY(double centerY) {
//        this.centerY = centerY;
//    }
//
//    public double getR1() {
//        return r1;
//    }
//
//    public void setR1(double r1) {
//        this.r1 = r1;
//    }
//
//    public double getR2() {
//        return r2;
//    }
//
//    public void setR2(double r2) {
//        this.r2 = r2;
//    }
//
//
//}
