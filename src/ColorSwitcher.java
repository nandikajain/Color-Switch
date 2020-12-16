import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.io.Serializable;
import java.util.Random;

public class ColorSwitcher implements Serializable {
    private final static long serialVersionUID = 6413344;
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
    transient Random random;

    public ColorSwitcher(double initPosition, ImageView img){
        userVelocity= 5;
        positionY =initPosition;
        starImg = img;
        hasCollected= false;
        random= new Random();

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
    public void changeColor(Ball b)
    {
        Color c = b.getBallColor();
        if(c== Color.YELLOW)
        {
            int int_random = random.nextInt(3);
            //0-> RED
            //1 -> CYAN
            //2-> PURPLE
            if(int_random==0)
                b.setBallColor(Color.RED);
            else if (int_random==1)
                b.setBallColor(Color.CYAN);
            else
                b.setBallColor(Color.PURPLE);

        }
        else if (c==Color.CYAN)
        {
            int int_random = random.nextInt(3);
            //0-> RED
            //1 -> YELLOW
            //2-> PURPLE
            if(int_random==0)
                b.setBallColor(Color.RED);
            else if (int_random==1)
                b.setBallColor(Color.YELLOW);
            else
                b.setBallColor(Color.PURPLE);
        }
        else if(c== Color.RED)
        {
            int int_random = random.nextInt(3);
            //0-> YELLOW
            //1 -> CYAN
            //2-> PURPLE
            if(int_random==0)
                b.setBallColor(Color.YELLOW);
            else if (int_random==1)
                b.setBallColor(Color.CYAN);
            else
                b.setBallColor(Color.PURPLE);

        }
        else{
            int int_random = random.nextInt(3);
            //0-> RED
            //1 -> CYAN
            //2-> YELLOW
            if(int_random==0)
                b.setBallColor(Color.RED);
            else if (int_random==1)
                b.setBallColor(Color.CYAN);
            else
                b.setBallColor(Color.YELLOW);

        }
        return ;

    }

    public boolean isHasCollected() {
        return hasCollected;
    }

    public void setHasCollected(boolean hasCollected) {
        this.hasCollected = hasCollected;
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

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    public double getPositionY() {
        return positionY;
    }
}
