package PongV2;

import java.awt.*;

public class AIPaddle implements Paddle {
    double y, yVel;
    boolean upAccel, downAccel;
    final double GRAVITY=0.94;
    int player, x;
    int players;
    Ball b1=new Ball();

    public AIPaddle(int player, Ball b){
        upAccel=false; downAccel=false;
        players=player;
        b1=b;
        y=210;yVel=0;
        if(player==1){
            x=20;
        } else {
            x=660;
        }
    }

    public void draw(Graphics g) {
            g.setColor(Color.yellow);
        g.fillRect(x,(int)y,20,80);

    }
    public void move() {
        y = b1.getY() -40;
        if(y<0){
            y=0;
        }
        if(y>420){
            y=420;
        }
    }
    public void destroy(Graphics g){
        g.setColor(Color.black);
        g.fillRect(x,(int)y,20,8000);
    }
    public int getY() {
        return (int) y;

    }
}

