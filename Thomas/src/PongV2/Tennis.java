/**********************************************************************
 * @file Tennis.java
 *
 *
 * @author Sam Rausch, Thomas Peterson, Quincy Williams, Nick Kozlov
 * @date: 11/30/22
 * @acknowledgement: Classwork
 ***********************************************************************/

package PongV2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

public class Tennis extends JFrame implements Runnable, KeyListener {
    public static void main(String[] args) {
        Tennis game = new Tennis();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    final int WIDTH = 700, HEIGHT = 500;
    Thread thread;
    HumanPaddle p1;
    Ball b1;
    HumanPaddle p2;
    AIPaddle p3;
    Scorecard scorecard;
    boolean gameStart;
    boolean twoPlayerStart;
    Graphics gfx;
    Image img;
    public Tennis() {
        this.setSize(WIDTH, HEIGHT);
        gameStart=false;
        twoPlayerStart=false;
        this.addKeyListener(this);
        this.setTitle("Pong Game");
        this.setVisible(true);
        b1 = new Ball();
        p1 = new HumanPaddle(1);
        p2 = new HumanPaddle(2);
        p3 = new AIPaddle(3, b1);
        scorecard = new Scorecard();
        img = createImage(WIDTH,HEIGHT);
        gfx = img.getGraphics();
        thread = new Thread(this);
        thread.start();
    }
    public void paint(Graphics g) {
        gfx.setColor(Color.black);
        gfx.fillRect(0, 0, WIDTH, HEIGHT);
        if (b1.getX() < -10 || b1.getX() > 710) {
            gfx.setColor(Color.red);
            gfx.drawString("Game Over", 300, 280);
            scorecard.scoreReset(0);
        }
        else {
            p3.draw(gfx);
            p1.draw(gfx);
            p2.draw(gfx);
            b1.draw(gfx);
            scorecard.draw(gfx);
            scorecard.drawHighScore(gfx);
        }
        if (!gameStart && !twoPlayerStart){
            gfx.setColor(Color.white);
            gfx.setFont(new Font("Arial", Font.BOLD, 50));
            gfx.drawString("Tennis",270,200);
            gfx.setFont(new Font("Arial", Font.PLAIN, 20));
            gfx.drawString("Press enter for 1 player", 250,300);
            gfx.drawString("Press space for 2 players", 250,320);
        }
        g.drawImage(img,0,0,this);
    }
    public void updates(Graphics g){
        paint(g);
    }
    public void run(){
        for(;;){
            if (gameStart) {
                p1.move();
                p3.move();
                b1.move();
                b1.checkPaddleCollision(p1, p3, scorecard);
            }
            else if(twoPlayerStart){
                p1.move();
                p2.move();
                b1.move();
                b1.checkPaddleCollision(p1, p2, scorecard);
            }
            repaint();
            try {
                Thread.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() ==KeyEvent.VK_UP){
            p1.setUpAccel(true);
        }
        else if(e.getKeyCode() ==KeyEvent.VK_DOWN){
            p1.setDownAccel(true);
        }if (e.getKeyCode() ==KeyEvent.VK_W){
            p2.setUpAccel(true);
        }
        else if(e.getKeyCode() ==KeyEvent.VK_S){
            p2.setDownAccel(true);
        }
    }
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            p1.setUpAccel(false);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            p1.setDownAccel(false);
        }if (e.getKeyCode() == KeyEvent.VK_W) {
                p2.setUpAccel(false);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
                p2.setDownAccel(false);
        } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            gameStart = true;
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE){
            twoPlayerStart=true;
        }
    }
    public void keyTyped(KeyEvent arg0){

    }
}
