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
    public void incrementScore() {
        this.score += 1;
    }
    private int prevScore = score;
    private int highScore = 0;
    public void draw(Graphics g){
        g.setColor(Color.white);
        g.drawString("Score: " + score, 300, 200);
        if(prevScore > highScore) {
            highScore = prevScore;
            g.drawString("High Score: " + highScore, 300, 100);
        }
        else if(highScore >= prevScore) {
            g.drawString("High Score: " + highScore, 300, 100);
        }
    }
}

