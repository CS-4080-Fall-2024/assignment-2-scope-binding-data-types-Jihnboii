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
