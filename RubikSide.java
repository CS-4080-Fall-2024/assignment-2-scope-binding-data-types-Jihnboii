/*
Jonathan Rodriguez
Date: 10/20/2024
CS 4080
Assignment 2

This class represents an individual face of the Rubik's Cube. It provides methods to 
get and set rows and columns, as well as rotate the face itself 
(clockwise or anti-clockwise).
*/

public class RubikSide implements Cloneable {
    private final int size;  // Size of the Rubik's cube side (e.g., 3 for a 3x3)
    private int[][] values;  // 2D array to represent the face colors

    // Constructor to initialize the side with a specific color
    public RubikSide(int size, int value) {
        this.size = size;
        values = new int[size][size];

        // Initialize the face with the given color value
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                values[i][j] = value;
            }
        }
    }

    // Get a row from the side
    public int[] getRow(int row) {
        return values[row];
    }

    // Get a column from the side
    public int[] getCol(int col) {
        int[] colValues = new int[size];
        for (int i = 0; i < size; i++) {
            colValues[i] = values[i][col];
        }
        return colValues;
    }

    // Set a row in the side
    public void setRow(int row, int[] newValues) {
        values[row] = newValues;
    }

    // Set a column in the side
    public void setCol(int col, int[] newValues) {
        for (int i = 0; i < size; i++) {
            values[i][col] = newValues[i];
        }
    }

    // Rotate the side 90 degrees clockwise
    public void rotateClockwise() {
        int[][] newValues = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                newValues[j][size - 1 - i] = values[i][j];
            }
        }
        values = newValues;
    }

    // Rotate the side 90 degrees anti-clockwise
    public void rotateAntiClockwise() {
        int[][] newValues = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                newValues[size - 1 - j][i] = values[i][j];
            }
        }
        values = newValues;
    }

    // Print the side for visualization
    public void printSide() {
        for (int[] row : values) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
