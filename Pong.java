/*
 *btran8
 *Project 4 - Pong/Ball class
 *Lab section: 9:40 - 10:55 TR
 *TA: Rahaf AlQarni
 *I did not collaborate with anyone on this assignment
 */

import java.util.Random;

public class Pong {
    static double x = 350, y = 400, vx = 20, vy = 0, t = 0;
    static Random Rand = new Random();
    static boolean stop = false;

    public static void calculate(double x1, double x2, double tvx, int SpaceShip) {
        if (stop == true) {
            reset();
            return;
        }
        if (y >= 599) {
            vy = -vy;
        }
        if (x <= 21) {
            vx = -vx;
        }
        if (x >= 679) {
            vx = -vx;
        }
        if (-5 < y && y < 21) {
            if (x >= x1 && x <= x2) {
                vy = -vy + 25;
                vx += tvx / 3;
            }
        }
        if (SpaceShip - 10 < x && x < SpaceShip + 180) {
            if (488 < y && y < 492 && vy > 0 || 528 < y && y < 532 && vy < 0) {
                vy = -vy ;
            }
        }
        if (y < -100) {
            stop = true;
        }
        vy -= 7;
        x += vx * 0.01;
        y += vy * 0.01;
        if (SpaceShip - 10 < x && x < SpaceShip + 180) {
            if (489 < y && y < 531) {
                if (vy > 0) {
                    y = 489;
                }
                if (vy < 0) {
                    y = 531;
                    vy = -vy;
                }
            }
        }
    }

    public static void reset() {
        x = 350;
        y = 400;
        vx = Rand.nextDouble() * 200;
        vy = 0;
        stop = false;
    }
}
