package week08d01;

public class Robot {

    private int x;
    private int y;

    public Robot() {
        this.x = 0;
        this.y = 0;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Robot moveUp() {
        y++;
        return this;
    }

    public Robot moveDown() {
        y--;
        return this;
    }

    public Robot moveRight() {
        x++;
        return this;
    }

    public Robot moveLeft() {
        x--;
        return this;
    }

    public boolean isItLegalMove(char movement){
        if (movement != 'F' && movement != 'L' && movement != 'J' && movement != 'B'){
            throw new IllegalArgumentException("Illegal movement!");
        }
        return true;
    }

    @Override
    public String toString() {
        return "Robot position:" +
                "x=" + x +
                ", y=" + y;
    }

    public String move(String coordinates){
        for (int i = 0; i < coordinates.length(); i++) {
            isItLegalMove(coordinates.charAt(i));
            switch (coordinates.charAt(i)) {
                case 'F' -> moveUp();
                case 'L' -> moveDown();
                case 'J' -> moveRight();
                case 'B' -> moveLeft();
            }
        } return toString();
    }

    public void  reset(){
        x=0;
        y=0;
    }
}
