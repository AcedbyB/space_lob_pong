/*
 *btran8
 *Project 4 - Main/Frame class
 *Lab section: 9:40 - 10:55 TR
 *TA: Rahaf AlQarni
 *I did not collaborate with anyone on this assignment
 */


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Frame extends JFrame implements KeyListener {
    static Pong myPong = new Pong();
    static Frame myFrame = new Frame();
    static Canvas C1 = new Canvas(myFrame);
    static boolean left, right;
    static int time = 10;
    static int cnt = 0;
    static int SpaceShip = 0;
    static int vspace = 1;

    public void keyTyped(KeyEvent E) {

    }

    public void keyPressed(KeyEvent E) {
        if (E.getKeyCode() == KeyEvent.VK_LEFT) {
            left = true;
        } else {
            right = true;
        }
        update();
    }

    public void keyReleased(KeyEvent E) {
        left = false;
        right = false;
        update();
    }

    public void update() {
        if (left == true) {
            C1.vx = -500;
            return;
        }
        if (right == true) {
            C1.vx = 500;
            return;
        }
        C1.vx = 0;
    }

    protected static class TimerCallback implements ActionListener {
        public void actionPerformed(ActionEvent E) {
            SpaceShip += vspace;
            if(SpaceShip == 520) vspace=-1;
            if(SpaceShip == 0) vspace=1;
            if (C1.Passing > 0.01) {
                myFrame.repaint();
                return;
            }
            Pong.calculate(C1.x1, C1.x2, C1.vx,SpaceShip);
            cnt++;
            cnt %= 100;
            if (cnt == 0) {
                C1.time--;
                if (C1.time == 0) {
                    for(int i=0;i<3;i++) C1.s[i] = new Sun();
                    C1.score += 10;
                    C1.Passing = 2;
                    C1.curLevel++;
                    time += 5;
                    C1.time = time;
                }
            }
            if (Pong.stop == true) {
                C1.life--;
                if (C1.life == 0) Timer.stop();
            }
            C1.pongX = (int) myPong.x;
            C1.pongY = (int) myPong.y;
            myFrame.repaint();
        }
    }


    static Timer Timer = new Timer(10, new TimerCallback());

    public static void main(String[] args) throws IOException {
        String filePath = new File("").getAbsolutePath() + "\\images\\";
        //System.out.println(filePath.concat("\\heart.jpg"));
        BufferedImage img = ImageIO.read(new File(filePath + "heart.jpg"));
        BufferedImage pong = ImageIO.read(new File(filePath + "pong.png"));
        BufferedImage tram = ImageIO.read(new File(filePath + "trampoline.png"));
        BufferedImage GameOver = ImageIO.read(new File(filePath + "GO.png"));
        BufferedImage LvlUp = ImageIO.read(new File(filePath + "LevelUp.png"));
        BufferedImage Ship = ImageIO.read(new File(filePath + "spaceship.png"));
        BufferedImage spacetheme = ImageIO.read(new File(filePath + "spacetheme.jpg"));
        BufferedImage sun = ImageIO.read(new File(filePath + "sun.png"));
        C1.img = img;
        C1.pong = pong;
        C1.tram = tram;
        C1.GO = GameOver;
        C1.LvlUp = LvlUp;
        C1.Ship = Ship;
        C1.theme = spacetheme;
        C1.sun = sun;
        myFrame.addKeyListener(myFrame);
        myFrame.setSize(700, 700);
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myFrame.add(C1);
        Timer.start();
        myFrame.setVisible(true);
    }
}
