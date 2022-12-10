/**********************************************************************
 * @file Tennis.java
 *
 *
 * @author Sam Rausch, Thomas Peterson, Quincy Williams, Nick Kozlov
 * @date: 11/30/22
 * @acknowledgement: Group Part
 ***********************************************************************/

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
    public void setNewScore(int score) {
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
    public void setHighScore(int prevScore) {
        if (prevScore > highScore) {
            this.highScore = prevScore;
        }
    }
    public void drawHighScore(Graphics g) {
        getHighScore();
        setHighScore(score);
        g.drawString("High Score: " + highScore, 300, 400);
    }
    public int scoreReset(int score) {
        setNewScore(score);
        getScore();
        return score;
    }

}

