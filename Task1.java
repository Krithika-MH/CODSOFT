import java.util.*;

class Task1
{
    public static void main(String[] args)
    {
        // Create a Random object for generating random numbers
        Random r = new Random();
        // Create a Scanner object for user input
        Scanner sc = new Scanner(System.in);

        // Display the introduction and rules of the game
        System.out.println("\n\t\t\t\t\tGUESS THE NUMBER GAME");
        System.out.println("You have 5 rounds with 3 chances each to guess the right number");

        // Variables to track the number of correct guesses and rounds won
        int right = 0, win = 0;

        // Loop through 5 rounds of the game
        for (int i = 1; i <= 5; i++) {
            // Display the current round
            System.out.println("\t\t\t\t\t\tROUND " + i);
            // Prompt the user to enter the lower bound of the range
            System.out.println("Enter the lower bound : ");
            int lb = sc.nextInt();
            // Prompt the user to enter the upper bound of the range
            System.out.println("Enter the upper bound : ");
            int ub = sc.nextInt();
            // Generate a random number within the specified range
            int x = r.nextInt(ub) + lb;

            // Loop through 3 chances for each round
            for (int j = 1; j <= 3; j++) {
                // Prompt the user to enter their guess
                System.out.println("\nEnter your guess " + j + " : ");
                int guess = sc.nextInt();

                // Compare the user's guess with the generated number
                if (guess == x) {
                    // If the guess is correct, congratulate the user and update variables
                    System.out.println("Congratulations! Your guess is correct!");
                    right = 1;
                    win++;
                    // Exit the loop since the correct guess is found
                    break;
                } else if (guess < x) {
                    // If the guess is too low, provide feedback
                    System.out.println("Your guess is too low !");
                } else {
                    // If the guess is too high, provide feedback
                    System.out.println("Your guess is too high!");
                }
            }

            // If the user runs out of chances without guessing the correct number, notify them
            if (right != 1) {
                System.out.println("Sorry! You Lost Round" + i);
            }
        }

        // Display the user's final score
        System.out.println("\nYour Score is " + win + "/5");
    }
}