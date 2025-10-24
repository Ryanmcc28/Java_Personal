import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class Guessing_Game
{
    String response = "y";
    int secretNumber = 1234;
    final int MAX_GUESSES = 6;
    final int LOWER_BOUND = 0;
    final int UPPER_BOUND = 100;
    int guesses = MAX_GUESSES;
    int guess;

    private void start()
    {
        String input;
        var scan = new Scanner(System.in);
        var rng = new Random();
        secretNumber = rng.nextInt(UPPER_BOUND);
        System.out.println(secretNumber);

        System.out.println("Do you want to play a game (y/n) ?");
        response = scan.next();
        System.out.println("You choose: " + response);
        do
        {
            System.out.println("Enter guess:");
            guess = Integer.parseInt(scan.next());
            guesses--;
        }
        while (guess != secretNumber && guesses > 0);
        if (guess == secretNumber)
        {
            System.out.println("VICTORY!!!!!!");
        }
        else
        {
            System.out.println("YOU LOSE!!!!!");
        }
    }

    public static void main(String[] args)
    {
        var hiLo = new Guessing_Game();
        hiLo.start();
    }
}
