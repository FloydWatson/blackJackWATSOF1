package nz.ac.eit;

import java.util.Random;

public class Dice {
    private int max = 6;
    private Random rand;

    public Dice(){
        rand = new Random();
    }

    public int getRoll(){
        return rand.nextInt(max) + 1;
    }

}
