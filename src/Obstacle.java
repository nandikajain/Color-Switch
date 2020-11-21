public class Obstacle {
    int positionX;
    int positionY;
    int periodicSpeed;
    boolean movementDirection;
    double obstacleState;

    public Obstacle(){

    }

    public void shapeSetup(){

    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public void setPeriodicSpeed(int periodicSpeed) {
        this.periodicSpeed = periodicSpeed;
    }

    public void setMovementDirection(boolean movementDirection) {
        this.movementDirection = movementDirection;
    }

    public void setObstacleState(double obstacleState) {
        this.obstacleState = obstacleState;
    }
}
