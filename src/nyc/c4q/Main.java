package nyc.c4q;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean notDone = true;
        while (notDone) {
            Hangman hangman = new Hangman();
            while (hangman.getMisses() < 5) {
                hangman.printCurrentWord();
                hangman.promptPlayer("Enter a letter: ");
                hangman.readLetter();
                hangman.checkLetter();
                if (hangman.guessedSuccessfully()) {
                    break;
                }
                System.out.println(Drawing.get(hangman.getMisses()));
                System.out.println("Misses -> " + hangman.getMisses());
            }
            if (hangman.guessedSuccessfully()) {
                System.out.println("Success");
            } else {
                System.out.println("The answer was " + hangman.getSecretWord());
            }
            System.out.println("Do you want to play again?"); // prompt("Do you want to play again?");
            /*************************************/
            boolean isValidInput;
            do {
                Scanner answer = new Scanner(System.in);
                String userAnswer = answer.next();
                userAnswer = userAnswer.toLowerCase();
                if (userAnswer.equals("yes") || userAnswer.equals("y")) {
                    isValidInput = true;
                    notDone = true;
                } else if (userAnswer.equals("no") || userAnswer.equals("n")) {
                    isValidInput = true; // consider doing the replay of hangman in this part of the loop
                    notDone = false;
                } else {
                    isValidInput = false;
                    System.out.println("Sorry, I didn't understand that. Could you please try again."); // prompt("Try again.")
                }
            } while (!isValidInput);
            /*************************************/
        }

    }
}
