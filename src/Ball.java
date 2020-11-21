public class Ball {
    private int curBallColor; // 0-Red 1-Yellow 2-LightBlue 3-Purple?
    private int positionY;
    private int distance;
    private boolean hasCollided;
    private int speed;

    public Ball(int initPos, int initColor, int speed){

    }

    public void moveUp(){

    }

    public int getCurBallColor() {
        return curBallColor;
    }

    public void setCurBallColor(int curBallColor) {
        this.curBallColor = curBallColor;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean getHasCollided(){
        return this.hasCollided;
    }

    public void setHasCollided(boolean hasCollided) {
        this.hasCollided = hasCollided;
    }
}
