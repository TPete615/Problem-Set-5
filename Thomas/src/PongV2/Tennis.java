package PongV2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

public class Tennis extends JFrame implements Runnable, KeyListener {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char s, m;
        long start,end;
        double t1;
        System.out.println("Choose your Character ** CPU or Player 1 **: ");
        s =sc.next().charAt(0);
        start=System.currentTimeMillis();
        System.out.println("Type any letter or number to start the game: ");
        m =sc.next().charAt(0);
        end=System.currentTimeMillis();
        t1=(end-start)/1000.0;
        System.out.println(t1);
        Tennis game = new Tennis();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    final int WIDTH = 700, HEIGHT = 500;
    Thread thread;
    HumanPaddle p1;
    Ball b1;
    AIPaddle p2;
    Scorecard scorecard;
    boolean gameStart;
    Graphics gfx;
    Image img;
    public Tennis() {
        this.setSize(WIDTH, HEIGHT);
        gameStart=false;
        this.addKeyListener(this);
        this.setTitle("Pong Game");
        this.setVisible(true);
        b1 = new Ball();
        p1 = new HumanPaddle(1);
        p2 = new AIPaddle(2, b1);
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
            gfx.drawString("Game Over", 350, 250);
            scorecard.prevScore();
            scorecard.prevScore();
            scorecard.getHighScore();
            scorecard.setHighScore(int prevScore);
            scorecard.drawHighScore(g);
        }
        else {
            p1.draw(gfx);
            b1.draw(gfx);
            p2.draw(gfx);
            scorecard.draw(gfx);
        }
        if (!gameStart){
            gfx.setColor(Color.white);
            gfx.drawString("Tennis",340,200);
            gfx.drawString("Press enter to begin . .", 310,230);
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
        }
    }
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            p1.setUpAccel(false);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            p1.setDownAccel(false);
        } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            gameStart = true;
        }
    }
    public void keyTyped(KeyEvent arg0){

    }
}


