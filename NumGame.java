// JAVA PROGRAM - CODSOFT
// TASK 1 - NUMBER GAME

// Importing Scanner and Random classes form util package
import java.util.Scanner;
import java.util.Random;

class NumGame 
{
    public static void main (String args[]) 
    {
        Scanner inp = new Scanner(System.in);
        Random random = new Random();
        
        int rnum, tries;
        // Set scores and levels
        int score = 0, level = 0;
        boolean NxtRound = true;

        System.out.println("\nWelcome to the Number Game!");

        // PlayAgain loop
        while (NxtRound) 
        {
            // Generate random number between 0 and 100
            rnum = random.nextInt(101); 
            // Set attemps
            tries = 10;

            System.out.println("\nNUMBER GAME STARTS NOW!");
            System.out.println("Dear User, Total Chances = 10, ALL THE BEST!");
            System.out.println("Guess any number between 0 and 100");

            // Loop for 10 attemps
            boolean result = false;
            for (int i = 1; i <= tries; i++) 
            {
                System.out.print("\nGuess " + i + ": ");
                int guess = inp.nextInt();

                // Check for correctness
                if (guess == rnum) 
                {
                    System.out.println("Great Job! Your guess is correct! The number is " + rnum);
                    score++;
                    result = true;
                    break;
                } 
                else if (guess < rnum) 
                    System.out.println("Too Low!");
                else 
                    System.out.println("Too High!");
            }
        
            if (!result) 
                System.out.println("\nOops! You lost. The correct number was " + rnum + ". Please Try Again!");

            System.out.println("\nYou've won " + score + " out of " + (level + 1) + " levels.");

            // Next Round
            System.out.println("Play again? (yes/no)");
            NxtRound = inp.next().equalsIgnoreCase("yes");
            level++;
        }
        System.out.println("Exiting the game...............");
        inp.close();
    }
}
