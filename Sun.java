/*
 *btran8
 *Project 4 - Sun/Bonus class
 *Lab section: 9:40 - 10:55 TR
 *TA: Rahaf AlQarni
 *I did not collaborate with anyone on this assignment
 */

import java.util.Random;

public class Sun {
    boolean show = true;
    int x,y;
    Random Rand = new Random();

    public Sun() {
        show = true;
        x = Rand.nextInt(670) + 1;
        y = Rand.nextInt(500) + 1;
    }
}

