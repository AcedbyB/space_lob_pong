/*
 *btran8
 *Project 4 - Canvas class
 *Lab section: 9:40 - 10:55 TR
 *TA: Rahaf AlQarni
 *I did not collaborate with anyone on this assignment
 */

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class Canvas extends JPanel {
    double pongX, pongY;
    int time = 10;
    double x1 = 280, x2 = 420;
    int score = 0;
    int vx = 0;
    int life = 3;
    int curLevel = 1;
    double Passing = 0;
    boolean stopTimer = false;
    Frame fake;
    Sun[] s = new Sun[4];
    BufferedImage img, pong, tram, GO, LvlUp, Ship, theme, sun;

    public Canvas(Frame F) {
        fake = F;
        for (int i = 0; i < 3; i++) s[i] = new Sun();
    }


    public void paintComponent(Graphics G) {
        G.drawImage(theme, 0, 0, 800, 800, this);
        if (Passing > 0.01) {
            Passing -= 0.01;
            G.drawImage(LvlUp, 250, 250, 180, 100, this);
            Pong.reset();
            return;
        }
        if (life == 0) {
            stopTimer = true;
            G.drawImage(GO, 220, 250, 240, 120, this);
            return;
        }
        G.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        G.setColor(Color.RED);
        G.drawString("LEVEL: " + curLevel, 180, 25);
        G.drawString("SCORE: " + score, 400, 25);
        G.drawString(Integer.toString(time), 650, 20);
        for (int i = 0; i < 3; i++) if (s[i].show == true) G.drawImage(sun, s[i].x - 30, (600-s[i].y - 30), 60, 60, this);
        for (int i = 0; i < 3; i++)
            if (s[i].show == true) {
                if (s[i].x - 30 < (int) pongX && (int) pongX < s[i].x + 30 && s[i].y - 30 < (int) pongY && (int) pongY < s[i].y + 30) {
                    s[i].show = false;
                    score += 5;
                }
            }
        x1 += 0.01 * vx;
        x1 = Math.max(x1, 0);
        x1 = Math.min(x1, 560);
        x2 += 0.01 * vx;
        x2 = Math.max(x2, 140);
        x2 = Math.min(x2, 700);
        G.drawImage(Ship, fake.SpaceShip, 90, 180, 80, this);
        G.drawImage(pong, (int) pongX - 15, 600 - (int) pongY, 40, 40, this);
        G.drawImage(tram, (int) x1, 600, 140, 40, this);
        for (int i = 0; i < life; i++) G.drawImage(img, 2 + i * 25, 5, 20, 20, this);
    }
}
