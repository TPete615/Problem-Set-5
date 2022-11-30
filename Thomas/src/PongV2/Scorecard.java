package PongV2;

import java.awt.*;

public class Scorecard {
    private int score = 0;

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setScore2(int score) {
        this.score = 0;
    }

    public void incrementScore() {
        this.score += 1;
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.drawString("Score: " + score, 300, 100);
    }
    private int highScore = 0;


    public int getHighScore() {
        return this.highScore;
    }
    public void setHighScore(int score) {
        getScore();
        setScore(score);
        if (score > highScore) {
            this.highScore = score;
        }
    }
    public void drawHighScore(Graphics g) {
        getHighScore();
        setHighScore(score);
        g.drawString("High Score: " + highScore, 300, 400);
    }
    public int scoreReset(int score) {
        setScore2(score);
        getScore();
        return score;
    }

}

