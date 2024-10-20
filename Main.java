/*
Jonathan Rodriguez
Date: 10/20/2024
CS 4080
Assignment 2

This class contains the main logic for scrambling and solving the Rubik's Cube. 
It uses a series of rotations to scramble the cube and then reverses those operations 
to restore it to its original state.
*/

public class Main {
    public static void main(String[] args) throws InterruptedException {
        RubiksCube cube = new RubiksCube(3);  // Create a 3x3 Rubik's Cube

        // Print the starting state
        System.out.println("Starting state:");
        cube.printCubeFormatted();

        // Scramble the cube with a series of rotations, print after each move
        System.out.println("After rotating the front face clockwise:");
        cube.rotateFrontClockwise();
        cube.printCubeFormatted();

        System.out.println("After turning middle row to the right:");
        cube.turnRowToRight(1);
        cube.printCubeFormatted();

        System.out.println("After rotating the top row to the right:");
        cube.turnRowToRight(0);
        cube.printCubeFormatted();

        System.out.println("After turning the right column upwards:");
        cube.turnColUp(2);
        cube.printCubeFormatted();

        System.out.println("After turning the left column downwards:");
        cube.turnColDown(0);
        cube.printCubeFormatted();

        System.out.println("After turning the middle column downwards:");
        cube.turnColDown(1);
        cube.printCubeFormatted();

        System.out.println("After turning the bottom row to the right:");
        cube.turnRowToRight(2);
        cube.printCubeFormatted();

        System.out.println("After rotating the front face counterclockwise:");
        cube.rotateFrontAntiClockwise();
        cube.printCubeFormatted();

        // Pause for 3 seconds while displaying "Thinking..."
        System.out.println("\nThinking...");
        Thread.sleep(3000);

        // Reverse the operations to restore the cube to its original state (without printing steps)
        cube.rotateFrontClockwise();        // Reverse of rotateFrontAntiClockwise
        cube.turnRowToLeft(2);              // Reverse of turnRowToRight (bottom row)
        cube.turnColUp(1);                  // Reverse of turnColDown (middle column)
        cube.turnColUp(0);                  // Reverse of turnColDown (left column)
        cube.turnColDown(2);                // Reverse of turnColUp (right column)
        cube.turnRowToLeft(0);              // Reverse of turnRowToRight (top row)
        cube.turnRowToLeft(1);              // Reverse of turnRowToRight (middle row)
        cube.rotateFrontAntiClockwise();    // Reverse of rotateFrontClockwise

        // Print the restored state
        System.out.println("\nRestored to the original state:");
        cube.printCubeFormatted();
    }
}
