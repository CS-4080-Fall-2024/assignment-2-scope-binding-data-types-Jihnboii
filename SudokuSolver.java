public class SudokuSolver {
    public static void main(String[] args) {
        // Example Sudoku board (use '.' to represent empty spaces)
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        // Call solveSudoku to solve the puzzle
        solveSudoku(board);

        // Print the solved Sudoku board
        printBoard(board);
    }

    public static void solveSudoku(char[][] board) {
        solve(board);
    }

    // Backtracking function to solve the board
    private static boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    // Try placing digits 1 to 9
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c; // Place the digit

                            if (solve(board)) { // Recursively solve the rest
                                return true; // If solution is found, return true
                            } else {
                                board[i][j] = '.'; // Backtrack
                            }
                        }
                    }
                    return false; // If no digit can be placed, return false
                }
            }
        }
        return true; // If the board is fully filled, return true
    }

    // Check if placing a digit is valid
    private static boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            // Check the row, column, and 3x3 sub-box
            if (board[row][i] == c || board[i][col] == c || 
                board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false;
            }
        }
        return true;
    }

    // Function to print the Sudoku board
    private static void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
