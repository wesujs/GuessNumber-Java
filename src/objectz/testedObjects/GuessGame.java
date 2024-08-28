package objectz.testedObjects;

import java.util.Scanner;

public class GuessGame {
    
    // Holds randomly Generated Answer
    int answer;

    // Holds strikes number
    int strikes;

    // Title?
    String asciiArt = "              ___           ___           ___           ___           ___                   \n" +
    "         /\\  \\         /\\__\\         /\\  \\         /\\  \\         /\\  \\                  \n" +
    "        /::\\  \\       /:/  /        /::\\  \\       /::\\  \\       /::\\  \\                 \n" +
    "       /:/\\:\\  \\     /:/  /        /:/\\:\\  \\     /:/\\ \\  \\     /:/\\ \\  \\                \n" +
    "      /:/  \\:\\  \\   /:/  /  ___   /::\\~\\:\\  \\   _\\:\\~\\ \\  \\   _\\:\\~\\ \\  \\               \n" +
    "     /:/__/\\_\\:\\__\\ /:/__/  /\\__\\ /:/\\:\\ \\:\\__\\ /\\ \\:\\ \\ \\__\\ /\\ \\:\\ \\ \\__\\              \n" +
    "     \\:\\  /\\ \\/__/ \\:\\  \\ /:/  / \\:\\~\\:\\ \\/__/ \\:\\ \\:\\ \\/__/ \\:\\ \\:\\ \\/__/              \n" +
    "      \\:\\ \\:\\__\\    \\:\\  /:/  /   \\:\\ \\:\\__\\    \\:\\ \\:\\__\\    \\:\\ \\:\\__\\                \n" +
    "       \\:\\/:/  /     \\:\\/:/  /     \\:\\ \\/__/     \\:\\/:/  /     \\:\\/:/  /                \n" +
    "        \\::/  /       \\::/  /       \\:\\__\\        \\::/  /       \\::/  /                 \n" +
    "         \\/__/         \\/__/         \\/__/         \\/__/         \\/__/                  \n" +
    "          ___           ___           ___           ___                                 \n" +
    "         /\\  \\         /\\__\\         /\\  \\         /\\  \\                                \n" +
    "         \\:\\  \\       /:/  /        /::\\  \\        \\:\\  \\                               \n" +
    "          \\:\\  \\     /:/__/        /:/\\:\\  \\        \\:\\  \\                              \n" +
    "          /::\\  \\   /::\\  \\ ___   /::\\~\\:\\  \\       /::\\  \\                             \n" +
    "         /:/\\:\\__\\ /:/\\:\\  /\\__\\ /:/\\:\\ \\:\\__\\     /:/\\:\\__\\                            \n" +
    "        /:/  \\/__/ \\/__\\:\\/:/  / \\/__\\:\\/:/  /    /:/  \\/__/                            \n" +
    "       /:/  /           \\::/  /       \\::/  /    /:/  /                                 \n" +
    "       \\/__/            /:/  /        /:/  /     \\/__/                                  \n" +
    "                       /:/  /        /:/  /                                             \n" +
    "                       \\/__/         \\/__/                                              \n" +
    "          ___           ___           ___           ___           ___           ___     \n" +
    "         /\\__\\         /\\__\\         /\\__\\         /\\  \\         /\\  \\         /\\  \\    \n" +
    "        /::|  |       /:/  /        /::|  |       /::\\  \\       /::\\  \\       /::\\  \\   \n" +
    "       /:|:|  |      /:/  /        /:|:|  |      /:/\\:\\  \\     /:/\\:\\  \\     /:/\\:\\  \\  \n" +
    "      /:/|:|  |__   /:/  /  ___   /:/|:|__|__   /::\\~\\:\\__\\   /::\\~\\:\\  \\   /::\\~\\:\\  \\ \n" +
    "     /:/ |:| /\\__\\ /:/__/  /\\__\\ /:/ |::::\\__\\ /:/\\:\\ \\:|__| /:/\\:\\ \\:\\__\\ /:/\\:\\ \\:\\__\\\n" +
    "     \\/__|:|/:/  / \\:\\  \\ /:/  / \\/__/~~/:/  / \\:\\~\\:\\/:/  / \\:\\~\\:\\ \\/__/ \\/_|::\\/:/  /\n" +
    "          |:/:/  /   \\:\\  /:/  /        /:/  /   \\:\\ \\::/  /   \\:\\ \\:\\__\\      |:|::/  / \n" +
    "          |::/  /     \\:\\/:/  /        /:/  /     \\:\\/:/  /     \\:\\ \\/__/      |:|\\/__/  \n" +
    "          /:/  /       \\::/  /        /:/  /       \\::/__/       \\:\\__\\        |:|  |    \n" +
    "          \\/__/         \\/__/         \\/__/         ~~            \\/__/         \\|__|\n\n\n";


    // New Object Declaration of RandomNumber
    RandomNumber rng = new RandomNumber();

    Scanner scr = new Scanner(System.in);

    public void startGame() throws InterruptedException {
        strikes = 0;
        answer = rng.randNumberGen();

         
        System.out.println(asciiArt);

        

        while (strikes < 3) {
            System.out.print("What will your first guess be?\n");
            int guess = scr.nextInt(); // Guess Scanner to take in user input

            if (guess == answer) {
                System.out.println("Boom! you guessed it right!");
                strikes = 3; // Ends Loop and Program If guess is right
            }

            if (guess < answer) {
                System.out.println("Your guess is lower than the right number.");
            }

            if (guess > answer) {
                System.out.println("Your guess is higher than the right number.");
            }

            strikes = strikes + 1;
            
        }
        System.out.println("Looks like you are out of guesses...\n\n");
        Thread.sleep(1500);
        System.out.println("See ya later...");

    }
}
