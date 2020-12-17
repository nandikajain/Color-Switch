import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.io.Serializable;

public class Star implements Serializable {
    private final static long serialVersionUID = 656211;
    double positionY;
    double velocity;
    double userVelocity;
    double acceleration;
    double width = 20;
    double height = width;
    double centerX = width / 2.0;
    double centerY = height / 2.0;
    double radius = width / 2.0;
    double maxSpeed = 100;
    boolean hasCollected;
    transient ImageView starImg;
    String imagePath;

    public boolean isHasCollected() {
        return hasCollected;
    }

    public void setHasCollected(boolean hasCollected) {
        this.hasCollected = hasCollected;
    }

    public Star(double initPosition, ImageView img){
        positionY =initPosition;
        starImg = img;
        hasCollected= false;
        userVelocity=5;
        imagePath= starImg.getImage().getUrl();
    }

    public void userMove() {
        velocity=0;
        acceleration=0;
        positionY+=userVelocity;
    }
    public void display()
    {
        starImg.setLayoutY(starImg.getLayoutY()+5);

    }
    public ImageView getStarImg() {
        return starImg;
    }

    public void setStarImg(ImageView starImg) {
        this.starImg = starImg;
    }

    public double getLocation(){
        return positionY;
    }

    public double getPositionY() {
        return positionY;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
