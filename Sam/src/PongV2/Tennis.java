package PongV2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Tennis extends JFrame implements Runnable, KeyListener {
    final int WIDTH = 700, HEIGHT = 500;
    Thread thread;
    HumanPaddle p1;
    public void Tennis (){
        this.setSize(WIDTH, HEIGHT);

        this.addKeyListener(this);
        p1 = new HumanPaddle(1);
        thread = new Thread(this);
        thread.start();
    }
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0,0, WIDTH, HEIGHT);
        p1.draw(g);
    }
    public void update(Graphics g) {
        paint(g);

    }
    public void run() {
        for(;;) {

            p1.move();

            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            p1.setUpAccel(true);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            p1.setDownAccel(true);
        }
    } public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            p1.setUpAccel(false);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            p1.setDownAccel(false);
        }

    }
}

