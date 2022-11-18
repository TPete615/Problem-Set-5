package PongV2;

public class Ball {
    double xVel, yVel, x, y;

    public Ball() {
        x = 350;
        y = 250;
        xVel = -2;
        yVel = 1;
    }

    public int getX() {
        return (int)x;
    }

    public int getY() {
        return (int)y;
    }
}
