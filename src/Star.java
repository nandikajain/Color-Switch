import javafx.scene.image.ImageView;

public class Star {
    double positionY;
    double velocity;
    double userVelocity;
    double acceleration;
    double width = 20;
    double height = width;
    boolean hasCollected;
    ImageView starImg;

    public Star(double initPosition, ImageView img){
        positionY =initPosition;
        starImg = img;
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


    public double getPositionY() {
        return positionY;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }
}
