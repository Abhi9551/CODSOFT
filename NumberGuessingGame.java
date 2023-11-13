import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int numberOfAttempts = 5;
        int userScore = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        
        while (true) {
            int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("I've generated a number between " + minRange + " and " + maxRange + ". Can you guess it?");

            while (attempts < numberOfAttempts) {
                System.out.print("Enter your guess (" + (numberOfAttempts - attempts) + " attempts remaining): ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You've guessed the correct number: " + generatedNumber);
                    userScore++;
                    hasGuessedCorrectly = true;
                    break;
                } else if (userGuess < generatedNumber) {
                    System.out.println("Your guess is too low. Try again.");
                } else {
                    System.out.println("Your guess is too high. Try again.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("You've run out of attempts. The correct number was: " + generatedNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next();

            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("Thanks for playing! Your score: " + userScore);
        scanner.close();
    }
}
