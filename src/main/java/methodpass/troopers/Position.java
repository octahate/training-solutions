package methodpass.troopers;

public class Position {
    private double posX;
    private double posY;

    public Position(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public double distanceFrom (Position position){
        double distance = Math.sqrt(Math.pow(2, this.posX - position.getPosX()) + Math.pow(2, this.posY - position.getPosY()));
        return distance;
    }
}
