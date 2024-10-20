/*
Jonathan Rodriguez
Date: 10/20/2024
CS 4080
Assignment 2

This class represents the entire Rubik's Cube. It contains methods to rotate the faces, 
rows, and columns of the cube, and updates the cube’s state accordingly. It also 
provides a method for formatted printing to display the cube in its scrambled and 
solved states.
*/

public class RubiksCube {
    private RubikSide main, right, left, back, top, bottom;
    private int size;

    // Constructor to initialize the Rubik's cube
    public RubiksCube(int size) {
        this.size = size;
        main = new RubikSide(size, 1);  // Red
        right = new RubikSide(size, 2); // Blue
        back = new RubikSide(size, 3);  // Orange
        left = new RubikSide(size, 4);  // Green
        top = new RubikSide(size, 5);   // White
        bottom = new RubikSide(size, 6); // Yellow
    }

    // Rotate the front face clockwise
    public void rotateFrontClockwise() {
        main.rotateClockwise();  // Rotate the main face (front)

        // Store the top row temporarily (will be overwritten)
        int[] tempTopRow = top.getRow(size - 1);

        // Shift left column of the right side to the top row
        top.setRow(size - 1, Utils.reverseArray(left.getCol(size - 1)));

        // Shift bottom row of the top to the left column
        left.setCol(size - 1, bottom.getRow(0));

        // Shift right column of the bottom to the bottom row
        bottom.setRow(0, Utils.reverseArray(right.getCol(0)));

        // Shift the original top row to the right column
        right.setCol(0, tempTopRow);
    }

    // Rotate the front face counterclockwise
    public void rotateFrontAntiClockwise() {
        main.rotateAntiClockwise();  // Rotate the main face (front)

        // Store the top row temporarily (will be overwritten)
        int[] tempTopRow = top.getRow(size - 1);

        // Shift right column of the left side to the top row
        top.setRow(size - 1, right.getCol(0));

        // Shift bottom row of the top to the right column
        right.setCol(0, Utils.reverseArray(bottom.getRow(0)));

        // Shift left column of the bottom to the bottom row
        bottom.setRow(0, left.getCol(size - 1));

        // Shift the original top row to the left column
        left.setCol(size - 1, Utils.reverseArray(tempTopRow));
    }

    // Turn a row to the right
    public void turnRowToRight(int row) {
        int[] mainRow = main.getRow(row);
        main.setRow(row, left.getRow(row));
        left.setRow(row, back.getRow(row));
        back.setRow(row, right.getRow(row));
        right.setRow(row, mainRow);

        if (row == 0) {
            top.rotateAntiClockwise();
        } else if (row == (size - 1)) {
            bottom.rotateClockwise();
        }
    }

    // Turn a row to the left
    public void turnRowToLeft(int row) {
        int[] mainRow = main.getRow(row);
        main.setRow(row, right.getRow(row));
        right.setRow(row, back.getRow(row));
        back.setRow(row, left.getRow(row));
        left.setRow(row, mainRow);

        if (row == 0) {
            top.rotateClockwise();
        } else if (row == (size - 1)) {
            bottom.rotateAntiClockwise();
        }
    }

    // Turn a column upwards
    public void turnColUp(int col) {
        int[] mainCol = main.getCol(col);
        int[] topCol = top.getCol(col);
        int[] backCol = back.getCol(col);
        int[] bottomCol = bottom.getCol(col);

        main.setCol(col, bottomCol);
        bottom.setCol(col, backCol);
        back.setCol(col, topCol);
        top.setCol(col, mainCol);

        if (col == 0) {
            left.rotateAntiClockwise();
        } else if (col == (size - 1)) {
            right.rotateClockwise();
        }
    }

    // Turn a column downwards
    public void turnColDown(int col) {
        int[] mainCol = main.getCol(col);
        int[] topCol = top.getCol(col);
        int[] backCol = back.getCol(col);
        int[] bottomCol = bottom.getCol(col);

        main.setCol(col, topCol);
        top.setCol(col, backCol);
        back.setCol(col, bottomCol);
        bottom.setCol(col, mainCol);

        if (col == 0) {
            left.rotateClockwise();
        } else if (col == (size - 1)) {
            right.rotateAntiClockwise();
        }
    }

    // Print the cube in the adjusted format
    public void printCubeFormatted() {
        System.out.println("Cube:");

        // Print the top face (with fixed indentation)
        printIndentedFace(top);
        System.out.println();

        // Print left, main, right, and back faces side by side
        for (int i = 0; i < size; i++) {
            printRow(left, i);    // Left face
            System.out.print("   ");
            printRow(main, i);    // Main (front) face
            System.out.print("   ");
            printRow(right, i);   // Right face
            System.out.print("   ");
            printRow(back, i);    // Back face
            System.out.println();
        }

        // Print the bottom face (with fixed indentation)
        System.out.println();
        printIndentedFace(bottom);
    }

    // Print the face with a fixed indentation (for top and bottom faces)
    private void printIndentedFace(RubikSide face) {
        for (int i = 0; i < size; i++) {
            System.out.print("         ");  // Fixed spaces
            printRow(face, i);
            System.out.println();
        }
    }

    // Print a single row of a RubikSide
    private void printRow(RubikSide face, int row) {
        int[] faceRow = face.getRow(row);
        for (int j = 0; j < faceRow.length; j++) {
            System.out.print(faceRow[j] + " ");
        }
    }

    // Print the cube for visualization
    public void printCube() {
        System.out.println("Main Side:");
        main.printSide();
        System.out.println("Top Side:");
        top.printSide();
        System.out.println("Left Side:");
        left.printSide();
        System.out.println("Right Side:");
        right.printSide();
        System.out.println("Back Side:");
        back.printSide();
        System.out.println("Bottom Side:");
        bottom.printSide();
    }
}
