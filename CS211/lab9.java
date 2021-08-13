import java.util.*;

public class lab9 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        boolean board[][] = new boolean[22][22];
        char nextLoop[][] = new char[22][22]; // Tracks what needs to be done for the next loop
        int maxLoops = scan.nextInt(); // number of loops to do
        scan.nextLine();


        // Setup board using user input
        for (int i = 1; i < 21; i++) { // rows
            String input = scan.nextLine(); // Get row
            for (int j = 1; j < 21; j++) { // col
                char c = input.charAt(j-1);
                if(c=='0'){ // If character is 0
                    board[i][j] = false; // cell is dead
                }else{
                    board[i][j] = true; // otherwise cell is alive
                }
            }
        }
        printboard(board);


        // Simulate
        for(int loop = 0;loop<maxLoops;loop++) { // Loops
            System.out.println(" NEW LOOP, LOOP IS " + loop);
            for (int i = 1; i < 21; i++) { // Row
                for (int j = 1; j < 21; j++) { // Col
                    int aliveCells = checkNeighbours(board,i,j);

                    boolean alive = board[i][j]; // Checks if cell is alive or empty

                    if(alive == true) { // For a space that is populated:
                        if (aliveCells <= 1) { // Each cell with one or no neighbors dies, as if by solitude.
                            nextLoop[i][j] = 'K'; // Set index in nextLoop array to 'K' for kill
                        } else if (aliveCells >= 4) { // Each cell with four or more neighbors dies, as if by overpopulation.
                            nextLoop[i][j] = 'K';
                        } else { // Each cell with two or three neighbors survives.
                            board[i][j] = true;
                            System.out.println("cell kept alive");
                            printboard(board);
                        }
                    }else { //For a space that is empty or unpopulated:
                        if(aliveCells==3){ // Each cell with three neighbors becomes populated.
                            nextLoop[i][j] = 'B';
                        }
                    }

                }
            }


            // Create and kill cells at end of loop
            for (int i = 1; i < 21; i++) { // Row
                for (int j = 1; j < 21; j++) { // Col
                    if(nextLoop[i][j] == 'K'){ // If meant to kill a cell
                        board[i][j] = false; // Kill cell in board array
                        nextLoop[i][j] = ' '; // Reset index in nextLoop
                    }else if(nextLoop[i][j] == 'B'){ // If meant to create a cell
                        board[i][j] = true; // Create cell
                        nextLoop[i][j] = ' '; // Reset index in nextLoop
                    }
                }
            }

            System.out.println("");
            printboard(board);
        }

        int finalCellCount = 0;
        // Create and kill cells
        for (int i = 1; i < 21; i++) { // Row
            for (int j = 1; j < 21; j++) { // Col
                if(board[i][j] == true){ // If meant to kill a cell
                    finalCellCount++;
                }
            }
        }

        System.out.println(finalCellCount);

    }

    public static int checkNeighbours(boolean[][] board, int i, int j) {
        int row = i;
        int col = j;

//      |_|_|_|
//      |_|O|_|
//      |_|_|_|


        int aliveCells = 0; // number of alive cells surrounding cell

        if(board[row-1][col-1] == true){ // top left
            aliveCells++;
        }

        if(board[row-1][col] == true){ // top
            aliveCells++;
        }


        if(board[row-1][col+1] == true){ // top right
            aliveCells++;
        }


        if(board[row][col-1] == true){ // left
            aliveCells++;
        }


        if(board[row][col+1] == true){ // right
            aliveCells++;
        }

        if(board[row+1][col-1] == true){ // bottom left
            aliveCells++;
        }

        if(board[row+1][col] == true){ // below
            aliveCells++;
        }

        if(board[row+1][col+1] == true){ // bottom right
            aliveCells++;
        }
        return aliveCells;
    }


    public static void printboard(boolean[][] board) {
        for (int i = 1; i < 22; i++) {
            for (int j = 1; j < 22; j++) {
                if (board[i][j] == false) {
                    System.out.print("_");
                } else {
                    System.out.print("X");
                }
            }
            System.out.println();
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
