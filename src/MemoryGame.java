import java.util.Scanner;
import java.util.Random;

public class MemoryGame {

    // == Global Variables ==
    // 1. Fix these (initialize them)
    static final int ROWS=4; //fixed 4x4 per base spec
    static final int COLS=4;
    static char[][] boardValues; //actual symbols (A,B,C,...)
    static boolean[][] revealed;
    static Scanner scanner = new Scanner(System.in);
    static int turnsTaken;  //increments per turn
    static final boolean DEBUG = false;
    static final Random rng= new Random();

    public static void main(String[] args) {
        initializeGame();
        if (DEBUG) {
            printSolution();
        }
        playGame();
        scanner.close();
    }

    // === Initialize the board with pairs ===
    static void initializeGame() {
        // 2. Missing some code here

        // 3. Shuffle pairs into the grid
        for (int i = 0; i < ROWS * COLS; i++) {

        }

        // 4. Fill the boardValues

    }

    // === Main game loop ===
    static void playGame() {
        while (!allPairsFound()) {
            printBoard();
            System.out.println("Turns taken: " + turnsTaken);

            // 5. Get first card


            // 6. Get second card

            // 7. Check for match

            // 8. Increment turns taken

        }

        // Game won
        printBoard();
        System.out.println("\nCongratulations! You found all pairs in " + turnsTaken + " turns!");
    }

    // === 9. Print the grid ===
    static void printBoard() {

    }

    // === 10. Print the solution ===
    // When debugging
    static void printSolution() {

    }

    // === 11. Get and validate coordinates ===
    static int[] getCoordinates(String prompt) {

        // Missing content in here

        // This is the last line of this method
        return new int[]{row, col};
    }

    // === 12. Check if all pairs are found ===
    static boolean allPairsFound() {

        return true;
    }
}

