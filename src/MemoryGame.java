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
        boardValues = new char[ROWS][COLS];
        revealed = new boolean[ROWS][COLS];
        //initialization done
        // 2. Missing some code here
        int pairs = (ROWS * COLS) / 2; //how many pairs of symbols are needed
        char[] pool = new char[ROWS * COLS];//creates a character array called pool that can hold exactly as many characters as needed
        int k = 0;
        for (int p = 0; p < pairs; p++) {
            char sym = (char) ('A' + p);
            pool[k++] = sym;
            pool[k++] = sym;  //loop runs once every pair
        }
        //built pool: A,A,B,B,C,C,....

        // 3. Shuffle pairs into the grid
        for (int i = 0; i < ROWS * COLS; i++) {
            int j = rng.nextInt(i + 1); //picks a random index j between 0 and i (inclusive)
            char tmp = pool[i]; pool[i] = pool[j]; pool[j] = tmp;//swaps the character at position i with the character at position j

        }  //used the fisher-yates shuffle to randomize the contents of the pool

        // 4. Fill the boardValues
        k = 0;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {//two nested loops go through every position in the board, row by row, column by column
                boardValues[r][c] = pool[k++];//takes the next character from the shuffled pool array and places it into the 2D board at position[r][c]
                revealed[r][c] = false;//initializes the state of each cell: false means the card is face down, when the player flips the card it will turn true
            }
        }

        turnsTaken = 0;

    }// Copy shuffled symbols to 2D board; start all hidden

    // === Main game loop ===
    static void playGame() {
        while (!allPairsFound()) {
            printBoard();
            System.out.println("Turns taken: " + turnsTaken);

            // 5. Get first card
            int[] first = promptHiddenCoord("Enter first card (row col): ");//prompt printed for the user
            reveal(first);
            printBoard();//first card done


            // 6. Get second card
            int[] second = promptHiddenCoord("Enter second card (row col): ", first);//Prompts the player again, but this time for the second card
            reveal(second);
            printBoard();//cannot be the same cell and must be hidden

            // 7. Check for match
            if (isMatch(first, second)) {
                System.out.println("It's a match!");
            } else {
                System.out.println("No match… cards will flip back.");
                waitForEnter();
                hide(first);
                hide(second);
            }

            // 8. Increment turns taken
            turnsTaken++; //count turn done

        }

        // Game won
        printBoard();
        System.out.println("\nCongratulations! You found all pairs in " + turnsTaken + " turns!");
    }

    // === 9. Print the grid ===
    static void printBoard() {
        //column headers
        System.out.print("   ");
        for (int c = 0; c < COLS; c++) System.out.print(c + " ");
        System.out.println();

        //Separator
        System.out.print("    ");
        for (int c = 0; c < COLS; c++) System.out.print("- ");
        System.out.println();
        //Rows
        for (int r = 0; r < ROWS; r++) {
            System.out.printf("%2d | ", r);
            for (int c = 0; c < COLS; c++) {
                System.out.print(revealed[r][c] ? (boardValues[r][c] + " ") : "* ");
            }
            System.out.println();
        }

    }//print grid done

    // === 10. Print the solution ===
    // When debugging
    static void printSolution() {
        System.out.print("    ");// Print leading spaces, then column headers (0,1,2,...)
        for (int c = 0; c < COLS; c++) System.out.print(c + " ");
        System.out.println();
        for (int r = 0; r < ROWS; r++) { // Loop through each row of the board
            System.out.printf("%2d | ", r);// Print the row label on the left
            for (int c = 0; c < COLS; c++) System.out.print(boardValues[r][c] + " ");// Print every symbol in this row
            System.out.println();// End the row, move to the next line
        }
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

