package PongV2;

import java.awt.*;
import java.util.Scanner;

public class Scorecard {
    private int score = 0;

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void incrementScore() {
        this.score += 1;
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.drawString("Score: " + score, 300, 100);
    }
    private int highScore = 0;
    private int prevScore = 0;
    public int getPrevScore() {
        return this.prevScore;
    }
    public void setPrevScore() {
        this.prevScore = score;
    }
    public int getHighScore() {
        return this.highScore;
    }
    public void setHighScore(int prevScore) {
        if (prevScore > highScore) {
            this.highScore = prevScore;
        }
    }
    public void drawHighScore(Graphics g) {
        g.drawString("High Score: " + highScore, 300, 400);
    }

}

