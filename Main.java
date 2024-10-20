public class Main {
    public static void main(String[] args) {
        RubiksCube cube = new RubiksCube(3);  // Create a 3x3 Rubik's Cube
        cube.printCube();

        // Turn the top row to the right
        System.out.println("After turning top row to the right:");
        cube.turnRowToRight(0);
        cube.printCube();

        // Turn the top row to the left
        System.out.println("After turning top row to the left:");
        cube.turnRowToLeft(0);
        cube.printCube();

        // Turn the first column up
        System.out.println("After turning first column up:");
        cube.turnColUp(0);
        cube.printCube();

        // Turn the first column down
        System.out.println("After turning first column down:");
        cube.turnColDown(0);
        cube.printCube();
    }
}
