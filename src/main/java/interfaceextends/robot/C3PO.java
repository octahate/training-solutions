package interfaceextends.robot;

import java.util.ArrayList;
import java.util.List;

public class C3PO implements MoveableRobot{

    Point position;
    int angle;
    List<Point> path = new ArrayList<>();

    public Point getPosition() {
        return position;
    }

    public int getAngle() {
        return angle;
    }

    public C3PO(Point position) {
        this.position = position;
        angle = 0;
    }

    @Override
    public void moveTo(Point position) {
        this.position = position;
        path.add(position);

    }

    @Override
    public void fastMoveTo(Point position) {
        moveTo(position);
    }

    @Override
    public void rotate(int angle) {
        this.angle = angle;
    }

    @Override
    public List<Point> getPath() {
        return path;
    }
}
