package objectz.testedObjects;

import java.util.Random;

public class RandomNumber {

    // New Random Object Declaration
    Random rand = new Random();
    
    public int randNumberGen() {
        //  How to get random Number --> rand.nextInt((maxNumber - minNumber) + 1) - minNumber;
        int randomNum = rand.nextInt((10 - 1) + 1) + 1;
        
        return randomNum;
    }
}
